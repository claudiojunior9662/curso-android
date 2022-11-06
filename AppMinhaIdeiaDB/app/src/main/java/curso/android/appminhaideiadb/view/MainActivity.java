package curso.android.appminhaideiadb.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import curso.android.appminhaideiadb.R;
import curso.android.appminhaideiadb.api.AppUtil;
import curso.android.appminhaideiadb.controller.ClienteController;
import curso.android.appminhaideiadb.model.Cliente;

public class MainActivity extends AppCompatActivity {

    ClienteController clienteController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(AppUtil.TAG, "onCreate: app minha ideia database");

        Cliente obj = new Cliente();
        obj.setNome("Claudio Jr.");
        obj.setEmail("teste@teste.com");

        clienteController = new ClienteController(getApplicationContext());

        if(clienteController.incluir(obj)){
            Toast.makeText(MainActivity.this, "Cliente " + obj.getNome() + " incluído com sucesso...", Toast.LENGTH_SHORT).show();
            Log.i(AppUtil.TAG, "Cliente " + obj.getNome() + " incluído com sucesso...");
        } else {
            Toast.makeText(MainActivity.this, "Cliente " + obj.getNome() + " não incluído com sucesso...", Toast.LENGTH_SHORT).show();
            Log.i(AppUtil.TAG, "Cliente " + obj.getNome() + " não incluído com sucesso...");
        }
    }
}