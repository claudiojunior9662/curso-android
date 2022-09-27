package curso.android.appminhaideia.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import curso.android.appminhaideia.R;
import curso.android.appminhaideia.core.AppUtil;

public class MainActivity extends AppCompatActivity {

    TextView txtNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(AppUtil.TAG, "onCreate: Tela principal carregada...");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = getIntent().getExtras();

        Log.d(AppUtil.TAG, "onCreate: Nome... " + bundle.get("nome"));
        Log.d(AppUtil.TAG, "onCreate: Email... " + bundle.get("email"));

        txtNome = findViewById(R.id.txtNome);
        txtNome.setText("Bem vindo " + bundle.getString("nome"));
    }
}