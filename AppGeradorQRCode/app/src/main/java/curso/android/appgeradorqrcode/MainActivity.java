package curso.android.appgeradorqrcode;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class MainActivity extends AppCompatActivity {

    EditText editQRCode;
    Button btnGerarQRCode;
    ImageView imageQRCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();

        btnGerarQRCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(editQRCode.getText().toString())) {
                    editQRCode.setError("*");
                    editQRCode.requestFocus();
                } else {
                     gerarQRCode(editQRCode.getText().toString());
                }
            }
        });
    }

    private void initComponents() {
        editQRCode = findViewById(R.id.editQRCode);
        btnGerarQRCode = findViewById(R.id.btnGerarQRCode);
        imageQRCode = findViewById(R.id.imageView);
    }

    private void gerarQRCode(String content) {
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, 196, 196);
            Bitmap bitmap = Bitmap.createBitmap(bitMatrix.getWidth(), bitMatrix.getHeight(), Bitmap.Config.RGB_565);
            for (int i = 0; i < bitMatrix.getWidth(); i++) {
                for (int j = 0; j < bitMatrix.getHeight(); j++) {
                    bitmap.setPixel(i,j, bitMatrix.get(i,j) ? Color.BLACK : Color.WHITE);
                }
            }
            imageQRCode.setImageBitmap(bitmap);
        }catch (WriterException exception) {
            exception.printStackTrace();
        }
    }
}