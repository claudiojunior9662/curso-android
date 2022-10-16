package curso.android.appminhaideiadb.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import curso.android.appminhaideiadb.R;
import curso.android.appminhaideiadb.api.AppUtil;
import curso.android.appminhaideiadb.controller.ClienteController;

public class MainActivity extends AppCompatActivity {

    ClienteController clienteController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(AppUtil.TAG, "onCreate: app minha ideia database");

        clienteController = new ClienteController(getApplicationContext());
    }
}