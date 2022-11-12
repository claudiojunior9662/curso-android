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
        insert(ProdutoDataModel.TABELA, contentValues);
        return false;
    }

    @Override
    public boolean alterar(Produto obj) {
        contentValues = new ContentValues();
        contentValues.put(ProdutoDataModel.ID, obj.getId());
        contentValues.put(ProdutoDataModel.NOME, obj.getNome());
        contentValues.put(ProdutoDataModel.FORNECEDOR, obj.getFornecedor());
        return update(ProdutoDataModel.TABELA, contentValues);
    }

    @Override
    public boolean deletar(int id) {
        return deleteById(ProdutoDataModel.TABELA, id);
    }

    @Override
    public List<Produto> listar() {
        return new ArrayList<>();
    }
}
