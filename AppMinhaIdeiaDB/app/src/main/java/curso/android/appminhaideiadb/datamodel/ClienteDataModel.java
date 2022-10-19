package curso.android.appminhaideiadb.datamodel;

public class ClienteDataModel {

    public static final String TABELA = "cliente";

    public static final String ID = "id";
    public static final String NOME = "nome";
    public static final String EMAIL = "email";

    public static String criarTabela(){
        StringBuilder builder = new StringBuilder()
                .append("CREATE TABLE ")
                .append(TABELA)
                .append(" (")
                .append(ID)
                .append(" integer primary key autoincrement, ")
                .append(NOME)
                .append(" text, ")
                .append(EMAIL)
                .append((" text "))
                .append(")");
        return builder.toString();
    }

}
