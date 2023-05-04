package professor.marcomaddo.appbancodedadosmeusclientes.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.Arrays;
import java.util.List;

import professor.marcomaddo.appbancodedadosmeusclientes.controller.ClienteORMController;
import professor.marcomaddo.appbancodedadosmeusclientes.R;
import professor.marcomaddo.appbancodedadosmeusclientes.model.ClienteORM;

public class MainActivity extends AppCompatActivity {

    private final ClienteORMController clienteORMController = new ClienteORMController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(ClienteORM cliente : clienteORMController.listar()) {
            Log.d("db_log", "onCreate: " + cliente);
        }

        ClienteORM consulta = clienteORMController.getById(4);

        if(consulta != null)
            Log.d("db_log", "onCreate: " + consulta);
        else
            Log.d("db_log", "onCreate: Não encontrado");
    }
}