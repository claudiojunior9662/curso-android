package app.modelo.meusclientes.view;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import app.modelo.meusclientes.R;
import app.modelo.meusclientes.controller.ClienteController;
import app.modelo.meusclientes.model.Cliente;


public class ListarClientesCardsFragment extends Fragment {

    private static final String TAG = "log";
    View view;

    EditText editPesquisarNome;

    ListView listView;

    List<Cliente> clienteList;

    List<String> clientes;

    ClienteController clienteController;

    ArrayAdapter<String> arrayAdapter;

    ArrayList<HashMap<String, String>> filtroClientes;

    Cliente cliente;

    public ListarClientesCardsFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view =  inflater.inflate(R.layout.fragment_listar_clientes, container, false);

        TextView txtTitulo = view.findViewById(R.id.txtTitulo);
        txtTitulo.setText(R.string.listar_clientes_cards);

//        txtTitulo.setTextColor(ColorStateList.valueOf(Color.BLACK));

        clienteController = new ClienteController(getContext());

        listView = (ListView) view.findViewById(R.id.listView);

        editPesquisarNome = view.findViewById(R.id.editPesquisarNome);

        clientes = clienteController.gerarListaClientesListView();

        arrayAdapter = new ArrayAdapter<>(getContext(), R.layout.fragment_listar_cliente_item, R.id.txtItemLista, clientes);

        listView.setAdapter(arrayAdapter);

        editPesquisarNome.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence filtro, int i, int i1, int i2) {
                ListarClientesCardsFragment.this.arrayAdapter.getFilter().filter(filtro);
                Log.i(TAG, "beforeTextChanged: "+filtro);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        return view;
    }


}
