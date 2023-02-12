package curso.android.appgeradorqrcodekotlin

import android.graphics.Bitmap
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.google.zxing.qrcode.QRCodeWriter

class MainActivity : AppCompatActivity() {

    var editQRCode: EditText? = null
    var btnGerarQRCode: Button? = null
    var imageView: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponents()

        btnGerarQRCode!!.setOnClickListener {
            if(TextUtils.isEmpty(editQRCode!!.text.toString())) {
                editQRCode!!.error = "*"
                editQRCode!!.requestFocus()
            } else {
                gerarQRCode(editQRCode!!.text.toString())
            }
        }
    }

    fun gerarQRCode(content: String) {
        val qrCode = QRCodeWriter()
        try{
            val bitMatrix = qrCode.encode(content, BarcodeFormat.QR_CODE, 196, 196)
            val bitmap = Bitmap.createBitmap(bitMatrix.width, bitMatrix.height, Bitmap.Config.RGB_565)
            for(x in 0 until bitMatrix.width) {
                for (y in 0 until bitMatrix.height) {
                    bitmap.setPixel(x, y, if (bitMatrix[x, y]) Color.BLACK else Color.WHITE)
                }
            }
            imageView!!.setImageBitmap(bitmap)
        } catch (e:WriterException) {

        }
    }

    fun initComponents() {
        editQRCode = findViewById(R.id.editQRCode)
        btnGerarQRCode = findViewById(R.id.btnGerarQRCode)
        imageView = findViewById(R.id.imageView)
    }
}