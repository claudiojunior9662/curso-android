package curso.android.appaulasp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "App_aulaSP";
    private static final String PREF_NOME = "App_aulaSP_pref";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor dados;

    String nomeProduto;
    int codigoProduto;
    float precoProduto;
    boolean estoque;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "onCreate: Rodando");

        sharedPreferences = getSharedPreferences(PREF_NOME, Context.MODE_PRIVATE);

        Log.i(TAG, "onCreate: Pasta shared criada");

        dados = sharedPreferences.edit();
        nomeProduto = "notebook";
        codigoProduto = 1;
        precoProduto = 997.97f;
        estoque = true;

        dados.putString("nomeProduto", nomeProduto);
        dados.putInt("codigoProduto", codigoProduto);
        dados.putFloat("precoProduto", precoProduto);
        dados.putBoolean("estoque", estoque);

        dados.apply();

        Log.i(TAG, "onCreate: dados para serem salvos");
        Log.i(TAG, "onCreate: produto "+nomeProduto);
        Log.i(TAG, "onCreate: codigo "+codigoProduto);
        Log.i(TAG, "onCreate: preco "+precoProduto);
        Log.i(TAG, "onCreate: tem estoque "+estoque);

//        dados.clear();
//        dados.apply();

//        dados.remove("estoque");
//        dados.apply();

        Log.i(TAG, "onCreate: dados recuperados");
        Log.d(TAG, "onCreate: produto "+sharedPreferences.getString("nomeProduto", ""));
        Log.d(TAG, "onCreate: codigo "+sharedPreferences.getInt("codigoProduto", -1));
        Log.d(TAG, "onCreate: preco "+sharedPreferences.getFloat("precoProduto", -1f));
        Log.d(TAG, "onCreate: tem estoque "+sharedPreferences.getBoolean("estoque", false));

    }
}