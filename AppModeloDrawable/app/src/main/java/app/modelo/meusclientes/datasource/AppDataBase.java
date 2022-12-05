package app.modelo.meusclientes.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import app.modelo.meusclientes.api.AppUtil;
import app.modelo.meusclientes.datamodel.ClienteDataModel;
import app.modelo.meusclientes.model.Cliente;


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

    /**
     * Método para atualizar no banco de dados
     * @param tabela nome da tabela para ser inserida
     * @param dados conjunto de dados para serem atualizados
     * @return true se os dados forem atualizados com sucesso ou false caso ocorra erro
     */
    public boolean update(String tabela, ContentValues dados) {
        boolean result;
        db = getWritableDatabase();
        try{
            result = db.update(tabela, dados, "id = ?", new String[] {String.valueOf(dados.get("id"))}) > 0;
        }catch (Exception e) {
            Log.d(AppUtil.TAG, "insert: " + e.getMessage());
            result = false;
        }
        return result;
    }

    public List<Cliente> getAllClientes(String tabela) {
        db = getWritableDatabase();
        List<Cliente> clientes = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM " + tabela, null);
        if(cursor.moveToFirst()){
            do{
                clientes.add(new Cliente(
                        cursor.getInt(cursor.getColumnIndexOrThrow(ClienteDataModel.ID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ClienteDataModel.NOME)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ClienteDataModel.EMAIL))
                ));
            }while(cursor.moveToNext());
        }
        return clientes;
    }
}
