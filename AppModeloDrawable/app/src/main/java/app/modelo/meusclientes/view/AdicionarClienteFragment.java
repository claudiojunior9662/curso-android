package app.modelo.meusclientes.view;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import app.modelo.meusclientes.R;
import app.modelo.meusclientes.controller.ClienteController;
import app.modelo.meusclientes.model.Cliente;


public class AdicionarClienteFragment extends Fragment {

    View view;
    TextView txtTitulo;
    EditText editNomeCompleto;
    EditText editTelefoneCliente;
    EditText editEmailCliente;
    EditText editCepCliente;
    EditText editLogradouroCliente;
    EditText editNumeroCliente;
    EditText editBairroCliente;
    EditText editCidadeCliente;
    EditText editEstadoCliente;
    CheckBox checkTermos;
    Button btnCancelar;
    Button btnSalvar;

    Cliente novoCliente;
    ClienteController clienteController;

    public AdicionarClienteFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view =  inflater.inflate(R.layout.fragment_adicionar_cliente, container, false);

        iniciarComponentesDeLayout();
        escutarEventosDosBotoes();

        return view;
    }

    /**
     * Iniciar componentes de layout
     */
    private void iniciarComponentesDeLayout() {
        txtTitulo = view.findViewById(R.id.txtTitulo);
        txtTitulo.setText(R.string.adicionar_cliente);
        editNomeCompleto = view.findViewById(R.id.editNomeCompletoCliente);
        editTelefoneCliente = view.findViewById(R.id.editTelefoneCliente);
        editEmailCliente = view.findViewById(R.id.editEmailCliente);
        editCepCliente = view.findViewById(R.id.editCepCliente);
        editLogradouroCliente = view.findViewById(R.id.editLogradouroCliente);
        editNumeroCliente = view.findViewById(R.id.editNumeroCliente);
        editBairroCliente = view.findViewById(R.id.editBairroCliente);
        editCidadeCliente = view.findViewById(R.id.editCidadeCliente);
        editEstadoCliente = view.findViewById(R.id.editEstadoCliente);
        checkTermos = view.findViewById(R.id.checkTermos);
        btnCancelar = view.findViewById(R.id.btnCancelar);
        btnSalvar = view.findViewById(R.id.btnSalvar);

        novoCliente = new Cliente();
        clienteController = new ClienteController(getContext());
    }

    private void escutarEventosDosBotoes() {
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isDadosOk = true;

                if(TextUtils.isEmpty(editNomeCompleto.getText())) {
                    isDadosOk = false;
                    editNomeCompleto.setError("O nome completo é obrigatório");
                    editNomeCompleto.requestFocus();
                }if(TextUtils.isEmpty(editTelefoneCliente.getText())) {
                    isDadosOk = false;
                    editTelefoneCliente.setError("O telefone é obrigatório");
                    editTelefoneCliente.requestFocus();
                }if(TextUtils.isEmpty(editEmailCliente.getText())) {
                    isDadosOk = false;
                    editEmailCliente.setError("O email é obrigatório");
                    editEmailCliente.requestFocus();
                }if(TextUtils.isEmpty(editCepCliente.getText())) {
                    isDadosOk = false;
                    editCepCliente.setError("O cep é obrigatório");
                    editCepCliente.requestFocus();
                }if(TextUtils.isEmpty(editLogradouroCliente.getText())) {
                    isDadosOk = false;
                    editLogradouroCliente.setError("O logradouro é obrigatório");
                    editLogradouroCliente.requestFocus();
                }if(TextUtils.isEmpty(editNumeroCliente.getText())) {
                    isDadosOk = false;
                    editNumeroCliente.setError("O número é obrigatório");
                    editNumeroCliente.requestFocus();
                }if(TextUtils.isEmpty(editBairroCliente.getText())) {
                    isDadosOk = false;
                    editBairroCliente.setError("O bairro é obrigatório");
                    editBairroCliente.requestFocus();
                }if(TextUtils.isEmpty(editCidadeCliente.getText())) {
                    isDadosOk = false;
                    editCidadeCliente.setError("A cidade é obrigatório");
                    editCidadeCliente.requestFocus();
                }if(TextUtils.isEmpty(editEstadoCliente.getText())) {
                    isDadosOk = false;
                    editEstadoCliente.setError("O estado é obrigatório é obrigatório");
                    editEstadoCliente.requestFocus();
                }

                if(isDadosOk) {
                    novoCliente.setNome(editNomeCompleto.getText().toString());
                    novoCliente.setTelefone(editTelefoneCliente.getText().toString());
                    novoCliente.setEmail(editEmailCliente.getText().toString());
                    novoCliente.setCep(Integer.parseInt(editCepCliente.getText().toString()));
                    novoCliente.setLogradouro(editLogradouroCliente.getText().toString());
                    novoCliente.setNumero(editNumeroCliente.getText().toString());
                    novoCliente.setBairro(editBairroCliente.getText().toString());
                    novoCliente.setCidade(editCidadeCliente.getText().toString());
                    novoCliente.setEstado(editEstadoCliente.getText().toString());
                    novoCliente.setTermoDeUso(checkTermos.isChecked());

                    clienteController.incluir(novoCliente);
                } else {
                    Log.i("log_add_cliente", "onClick: Os ddados estão incompletos");
                }

            }
        });
    }


}
