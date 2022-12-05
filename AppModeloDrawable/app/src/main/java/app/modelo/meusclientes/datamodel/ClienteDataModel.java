package app.modelo.meusclientes.datamodel;

public class ClienteDataModel {

    public static final String TABELA = "cliente";

    public static final String ID = "id";
    public static final String NOME = "nome";
    public static final String TELEFONE = "telefone";
    public static final String EMAIL = "email";
    public static final String CEP = "cep";
    public static final String LOGRADOURO = "logradouro";
    public static final String NUMERO = "numero";
    public static final String BAIRRO = "bairro";
    public static final String CIDADE = "cidade";
    public static final String ESTADO = "estado";
    public static final String TERMO_DE_USO = "termo_de_uso";

    public static String criarTabela(){
        StringBuilder builder = new StringBuilder()
                .append("CREATE TABLE ")
                .append(TABELA)
                .append(" (")
                .append(ID)
                .append(" integer primary key autoincrement, ")
                .append(NOME)
                .append(" text, ")
                .append(TELEFONE)
                .append(" text, ")
                .append(EMAIL)
                .append(" text, ")
                .append(CEP)
                .append(" integer, ")
                .append(LOGRADOURO)
                .append(" text, ")
                .append(NUMERO)
                .append(" text, ")
                .append(BAIRRO)
                .append(" text, ")
                .append(CIDADE)
                .append(" text, ")
                .append(ESTADO)
                .append(" text, ")
                .append(TERMO_DE_USO)
                .append((" integer "))
                .append(")");
        return builder.toString();
    }

}
