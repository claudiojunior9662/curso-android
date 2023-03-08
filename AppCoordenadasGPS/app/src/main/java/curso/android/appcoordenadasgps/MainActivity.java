package curso.android.appcoordenadasgps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String[] requiredPermissions = {Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION};

    public static final int APP_PERMISSIONS_ID = 2023;

    TextView txtValorLatitude, txtValorLongitude;

    double latitude, longitude;
    LocationManager locationManager;
    boolean gpsAtivo = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtValorLatitude = findViewById(R.id.txtValorLatitude);
        txtValorLongitude = findViewById(R.id.txtValorLongitude);

        locationManager = (LocationManager) getApplication().getSystemService(Context.LOCATION_SERVICE);
        gpsAtivo = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

        if(gpsAtivo) {
            obterCoordenadas();
        } else {
            latitude = 0.00;
            longitude = 0.00;
            setValues();
            showToast("Coordenadas não disponíveis.");
        }
    }

    private void obterCoordenadas() {
        boolean permissaoAtiva = solicitarPermissaoParaObterLocalizacao();
        if(permissaoAtiva){
            capturarUltimaLocalizacaoValida();
        }
    }

    private boolean solicitarPermissaoParaObterLocalizacao() {
        List<String> deniedPermissions = new ArrayList<String>();
        for(String permission : requiredPermissions) {
            if(ContextCompat.checkSelfPermission(MainActivity.this, permission) != PackageManager.PERMISSION_GRANTED){
                deniedPermissions.add(permission);
            }
        }
        return false;
    }

    private void capturarUltimaLocalizacaoValida() {
        latitude = 1.98;
        longitude = -1.98;
        setValues();
        showToast("Coordenadas obtidas com sucesso.");
    }

    private void setValues() {
        txtValorLongitude.setText(String.valueOf(longitude));
        txtValorLatitude.setText(String.valueOf(latitude));
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}