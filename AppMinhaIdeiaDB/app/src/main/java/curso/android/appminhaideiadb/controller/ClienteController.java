package curso.android.appminhaideiadb.controller;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import curso.android.appminhaideiadb.api.AppUtil;
import curso.android.appminhaideiadb.datamodel.ClienteDataModel;
import curso.android.appminhaideiadb.datasource.AppDataBase;
import curso.android.appminhaideiadb.model.Cliente;

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
        contentValues.put(ClienteDataModel.EMAIL, obj.getEmail());
        insert(ClienteDataModel.TABELA, contentValues);
        return true;
    }

    @Override
    public boolean alterar(Cliente obj) {
        contentValues = new ContentValues();
        contentValues.put(ClienteDataModel.ID, obj.getId());
        contentValues.put(ClienteDataModel.NOME, obj.getNome());
        contentValues.put(ClienteDataModel.EMAIL, obj.getEmail());
        return true;
    }

    @Override
    public boolean deletar(Cliente obj) {
        contentValues = new ContentValues();
        contentValues.put(ClienteDataModel.ID, obj.getId());
        return true;
    }

    @Override
    public List<Cliente> listar() {
        return new ArrayList<>();
    }
}
