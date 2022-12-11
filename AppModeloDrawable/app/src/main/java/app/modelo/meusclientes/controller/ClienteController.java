package app.modelo.meusclientes.controller;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import java.util.List;

import app.modelo.meusclientes.api.AppUtil;
import app.modelo.meusclientes.datamodel.ClienteDataModel;
import app.modelo.meusclientes.datasource.AppDataBase;
import app.modelo.meusclientes.model.Cliente;


public class ClienteController extends AppDataBase implements ICrud<Cliente> {

    ContentValues contentValues;

    public ClienteController(Context context) {
        super(context);

        Log.d(AppUtil.TAG, "ClienteController: conectado");
    }

    @Override
    public boolean incluir(Cliente obj) {
        contentValues = new ContentValues();
        contentValues.put(ClienteDataModel.NOME, obj.getNome());
        contentValues.put(ClienteDataModel.TELEFONE, obj.getTelefone());
        contentValues.put(ClienteDataModel.EMAIL, obj.getEmail());
        contentValues.put(ClienteDataModel.CEP, obj.getCep());
        contentValues.put(ClienteDataModel.LOGRADOURO, obj.getLogradouro());
        contentValues.put(ClienteDataModel.NUMERO, obj.getNumero());
        contentValues.put(ClienteDataModel.BAIRRO, obj.getBairro());
        contentValues.put(ClienteDataModel.CIDADE, obj.getCidade());
        contentValues.put(ClienteDataModel.ESTADO, obj.getEstado());
        contentValues.put(ClienteDataModel.TERMO_DE_USO, obj.isTermoDeUso());
        insert(ClienteDataModel.TABELA, contentValues);
        return true;
    }

    @Override
    public boolean alterar(Cliente obj) {
        contentValues = new ContentValues();
        contentValues.put(ClienteDataModel.ID, obj.getId());
        contentValues.put(ClienteDataModel.NOME, obj.getNome());
        contentValues.put(ClienteDataModel.EMAIL, obj.getEmail());
        return update(ClienteDataModel.TABELA, contentValues);
    }

    @Override
    public boolean deletar(int id) {
        return deleteById(ClienteDataModel.TABELA, id);
    }

    @Override
    public List<Cliente> listar() {
        return getAllClientes(ClienteDataModel.TABELA);
    }
}
