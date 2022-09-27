package curso.android.appminhaideia.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import curso.android.appminhaideia.R;
import curso.android.appminhaideia.core.AppUtil;
import curso.android.appminhaideia.model.Cliente;

public class SplashActivity extends AppCompatActivity {

    int tempoDeEspera = 1000 * 10;

    Cliente objCliente;

    TextView txtAppVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(AppUtil.TAG, "onCreate: Tela Splash carregada...");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        txtAppVersion = findViewById(R.id.txtAppVersion);
        txtAppVersion.setText(AppUtil.returnVersion());
        trocarTela();
    }

    private void trocarTela() {
        Log.d(AppUtil.TAG, "trocarTela: Mudando de tela...");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d(AppUtil.TAG, "trocarTela: Trocando de tela...");

                objCliente = new Cliente("Claudio", "teste@teste.com", "55999999999", 23, true);

                Intent trocarDeTela = new Intent(SplashActivity.this, MainActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("nome", objCliente.getNome());
                bundle.putString("email", objCliente.getEmail());

                trocarDeTela.putExtras(bundle);

                startActivity(trocarDeTela);
                finish();
            }
        }, tempoDeEspera);
    }
}