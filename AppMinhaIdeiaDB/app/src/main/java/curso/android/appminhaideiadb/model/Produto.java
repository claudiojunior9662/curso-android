package curso.android.appminhaideiadb.model;

import android.util.Log;

import curso.android.appminhaideiadb.api.AppUtil;
import curso.android.appminhaideiadb.controller.ICrud;

public class Produto {

    private int id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
