package curso.android.appminhaideiadb.model;

import android.util.Log;

import curso.android.appminhaideiadb.api.AppUtil;
import curso.android.appminhaideiadb.controller.ICrud;

public class Produto implements ICrud {

    private String nome;
    private String fornecedor;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Override
    public void incluir() {
        Log.i(AppUtil.TAG, "incluir: ");
    }

    @Override
    public void alterar() {
        Log.i(AppUtil.TAG, "alterar: ");
    }

    @Override
    public void deletar() {
        Log.i(AppUtil.TAG, "deletar: ");
    }

    @Override
    public void listar() {
        Log.i(AppUtil.TAG, "listar: ");
    }
}
