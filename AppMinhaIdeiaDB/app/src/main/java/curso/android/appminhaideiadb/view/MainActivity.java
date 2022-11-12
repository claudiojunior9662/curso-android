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

        clienteController = new ClienteController(getApplicationContext());

//        for(int i=0;i<49;i++){
//            clienteController.incluir(new Cliente("Claudio "+i, i+"_claudio@teste"));
//        }

        for(Cliente cliente : clienteController.listar()){
            Log.i("Listar", "onCreate: " + cliente.toString());
        }
    }
}