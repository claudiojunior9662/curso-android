package curso.android.appminhaideiadb.model;

import android.util.Log;

import curso.android.appminhaideiadb.api.AppUtil;
import curso.android.appminhaideiadb.controller.ICrud;

public class Cliente {

    private int id;
    private String nome;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }
}
