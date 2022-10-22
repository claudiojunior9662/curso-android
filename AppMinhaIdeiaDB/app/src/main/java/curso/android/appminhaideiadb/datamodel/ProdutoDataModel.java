package curso.android.appminhaideiadb.datamodel;

public class ProdutoDataModel {

    public static final String TABELA = "produto";

    public static final String ID = "id";
    public static final String NOME = "nome";
    public static final String FORNECEDOR = "fornecedor";

    public static String criarTabela(){
        StringBuilder builder = new StringBuilder()
                .append("CREATE TABLE ")
                .append(TABELA)
                .append(" (")
                .append(ID)
                .append(" integer primary key autoincrement, ")
                .append(NOME)
                .append(" text, ")
                .append(FORNECEDOR)
                .append((" text "))
                .append(")");
        return builder.toString();
    }

}
