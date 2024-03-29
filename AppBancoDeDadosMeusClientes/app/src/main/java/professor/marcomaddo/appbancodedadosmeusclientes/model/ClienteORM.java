package professor.marcomaddo.appbancodedadosmeusclientes.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class ClienteORM extends RealmObject {

    @PrimaryKey
    private int id;
    @Required
    private String nome;
    private double salario;
    private double preco;
    private int idade;
    private boolean ativo; // true false 0 1
    private String dataCadastro;
    private String horaCadastro;

    public ClienteORM() {}

    public ClienteORM(int id, String nome, double salario, double preco, int idade, boolean ativo, String dataCadastro, String horaCadastro) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
        this.preco = preco;
        this.idade = idade;
        this.ativo = ativo;
        this.dataCadastro = dataCadastro;
        this.horaCadastro = horaCadastro;
    }

    public ClienteORM(String nome, double salario, double preco, int idade, String dataCadastro, String horaCadastro) {
        this.nome = nome;
        this.salario = salario;
        this.preco = preco;
        this.idade = idade;
        this.dataCadastro = dataCadastro;
        this.horaCadastro = horaCadastro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getHoraCadastro() {
        return horaCadastro;
    }

    public void setHoraCadastro(String horaCadastro) {
        this.horaCadastro = horaCadastro;
    }

    public void updateEntity(ClienteORM updatedValue) {
        setNome(updatedValue.getNome());
        setSalario(updatedValue.getSalario());
        setPreco(updatedValue.getPreco());
        setIdade(updatedValue.getIdade());
        setAtivo(updatedValue.isAtivo());
        setDataCadastro(updatedValue.getDataCadastro());
        setHoraCadastro(updatedValue.getHoraCadastro());
    }

    @Override
    public String toString() {
        return "ClienteORM{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", salario=" + salario +
                ", preco=" + preco +
                ", idade=" + idade +
                ", ativo=" + ativo +
                ", dataCadastro='" + dataCadastro + '\'' +
                ", horaCadastro='" + horaCadastro + '\'' +
                '}';
    }
}
