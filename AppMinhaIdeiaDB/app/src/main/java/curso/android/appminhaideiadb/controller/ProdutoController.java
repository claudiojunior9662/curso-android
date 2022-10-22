package curso.android.appminhaideiadb.controller;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import curso.android.appminhaideiadb.datamodel.ProdutoDataModel;
import curso.android.appminhaideiadb.datasource.AppDataBase;
import curso.android.appminhaideiadb.model.Produto;

public class ProdutoController extends AppDataBase implements ICrud<Produto> {

    ContentValues contentValues;

    public ProdutoController(Context context) {
        super(context);
    }

    @Override
    public boolean incluir(Produto obj) {
        contentValues = new ContentValues();
        contentValues.put(ProdutoDataModel.NOME, obj.getNome());
        contentValues.put(ProdutoDataModel.FORNECEDOR, obj.getFornecedor());
        return false;
    }

    @Override
    public boolean alterar(Produto obj) {
        contentValues = new ContentValues();
        contentValues.put(ProdutoDataModel.ID, obj.getId());
        contentValues.put(ProdutoDataModel.NOME, obj.getNome());
        contentValues.put(ProdutoDataModel.FORNECEDOR, obj.getFornecedor());
        return false;
    }

    @Override
    public boolean deletar(Produto obj) {
        contentValues = new ContentValues();
        contentValues.put(ProdutoDataModel.ID, obj.getId());
        return false;
    }

    @Override
    public List<Produto> listar() {
        List<Produto> result = new ArrayList<>();
        return result;
    }
}
