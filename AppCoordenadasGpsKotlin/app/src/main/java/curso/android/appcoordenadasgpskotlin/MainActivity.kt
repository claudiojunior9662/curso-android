package curso.android.appcoordenadasgpskotlin

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.getSystemService
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.text.DecimalFormat

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    var permissoesRequeridas = arrayOf(
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION
    )

    val APP_PERMISSOES_ID = 2021

    var txtValorLatitude: TextView? = null
    var txtValorLongitude: TextView? = null

    var latitude: Double = 0.00
    var longitude: Double = 0.00

    var locationManager: LocationManager? = null

    var gpsAtivo = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        txtValorLongitude = findViewById(R.id.txtValorLongitude)
        txtValorLatitude = findViewById(R.id.txtValorLatitude)

        locationManager = application.getSystemService(LOCATION_SERVICE) as LocationManager

        gpsAtivo = locationManager!!.isProviderEnabled(LocationManager.GPS_PROVIDER)

        if(gpsAtivo){
            obterCoordenadas()
        }else{
            latitude = 0.00
            longitude = 0.00

            txtValorLatitude!!.setText(formatarGeopoint(latitude))
            txtValorLongitude!!.setText(formatarGeopoint(longitude))

            Toast.makeText(this, "Coordenadas não disponíveis", Toast.LENGTH_LONG)
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(latitude, longitude)
        mMap.addMarker(MarkerOptions().position(sydney).title("Celular localizado aqui"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
        mMap.uiSettings.setZoomControlsEnabled(true)
        mMap.setMinZoomPreference(9.5f)
        mMap.setMaxZoomPreference(12.5f)
    }

    private fun obterCoordenadas(){
        val permissaoAtiva: Boolean = solicitarPermissaoObterLocalizacao()
        if(permissaoAtiva)
            capturarUltimaLocalizacaoAtiva()
    }

    private fun solicitarPermissaoObterLocalizacao(): Boolean{
        Toast.makeText(this,"Verificando permissões...", Toast.LENGTH_LONG).show()
        val permissoesNegadas: MutableList<String> = ArrayList()
        var permissaoNegada: Int
        for(permissao in permissoesRequeridas){
            permissaoNegada = ContextCompat.checkSelfPermission(this@MainActivity, permissao)
            if(permissaoNegada != PackageManager.PERMISSION_GRANTED)
                permissoesNegadas.add(permissao)
        }
        return if(permissoesNegadas.isNotEmpty()){
            ActivityCompat.requestPermissions(this@MainActivity, permissoesNegadas.toTypedArray(), APP_PERMISSOES_ID)
            false
        } else {
            true
        }

        return true
    }

    @SuppressLint("MissingPermission")
    private fun capturarUltimaLocalizacaoAtiva(){
        val location = locationManager!!.getLastKnownLocation(LocationManager.GPS_PROVIDER)
        if(location != null) {
            latitude = location.latitude
            longitude = location.longitude
        } else {
            latitude = 0.00
            longitude = 0.00
        }

        txtValorLatitude!!.setText(formatarGeopoint(latitude))
        txtValorLongitude!!.setText(formatarGeopoint(longitude))

        Toast.makeText(this, "Coordenadas obtidas com sucesso", Toast.LENGTH_LONG).show()
    }

    private fun formatarGeopoint(valor: Double): String?{
        val result = DecimalFormat("#.####")
        return result.format(valor)
    }
}