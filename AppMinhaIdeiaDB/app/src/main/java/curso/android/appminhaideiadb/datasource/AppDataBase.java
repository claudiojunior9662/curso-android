package curso.android.appminhaideiadb.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import curso.android.appminhaideiadb.api.AppUtil;
import curso.android.appminhaideiadb.datamodel.ClienteDataModel;
import curso.android.appminhaideiadb.datamodel.ProdutoDataModel;
import curso.android.appminhaideiadb.model.Cliente;
import curso.android.appminhaideiadb.model.Produto;

public class AppDataBase extends SQLiteOpenHelper {

    public static final String DB_NAME = "AppMinhaIdeia.sqlite";
    public static final int DB_VERSION = 1;

    SQLiteDatabase db;

    public AppDataBase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        Log.d(AppUtil.TAG, "AppDataBase: criando banco de dados");
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ClienteDataModel.criarTabela());
        Log.d(AppUtil.TAG, "onCreate: tabela cliente criada..." + ClienteDataModel.criarTabela());
        db.execSQL(ProdutoDataModel.criarTabela());
        Log.d(AppUtil.TAG, "onCreate: tabela produto criada..." + ProdutoDataModel.criarTabela());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    /**
     * Método para inserir do banco de dados
     * @param tabela nome da tabela para ser inserida
     * @param dados conjunto de dados para serem inseridos
     * @return true se os dados forem inseridos com sucesso ou false caso ocorra erro
     */
    public boolean insert(String tabela, ContentValues dados) {
        boolean result;
        db = getWritableDatabase();
        try{
            result = db.insert(tabela, null, dados) > 0;
        }catch (Exception e) {
            Log.d(AppUtil.TAG, "insert: " + e.getMessage());
            result = false;
        }
        return result;
    }

    /**
     * Método para deletar do banco de dados
     * @param tabela nome da tabela para ser inserida
     * @param id chave primária do objeto a ser excluído
     * @return true se os dados forem inseridos com sucesso ou false caso ocorra erro
     */
    public boolean deleteById(String tabela, int id) {
        boolean result;
        db = getWritableDatabase();
        try{
            result = db.delete(tabela, "id = ?", new String[] {String.valueOf(id)}) > 0;
        }catch (Exception e) {
            Log.d(AppUtil.TAG, "delete: " + e.getMessage());
            result = false;
        }
        return result;
    }
}
