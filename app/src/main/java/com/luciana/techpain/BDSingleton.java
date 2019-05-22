package com.luciana.techpain;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public final class BDSingleton{

    /*
    Utilizando um objeto Singleton:
        Cursos c = BDSingleton.getInstance().find("tipo", new String[]{"idTipo", "nome}, "", "");
        BDSingleton.getInstance().delete("pokemonusuario", "");

    */


    protected SQLiteDatabase db;
    private final String DB_NAME = "DBTP";
    private static BDSingleton INSTANCE = new BDSingleton();

    private final String[] SCRIPT_DATABASE_CREATE = new String[]{
            "CREATE TABLE Mapa ( ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " +
                    "IdPaciente INTEGER NOT NULL, DtAdicionado INTEGER NOT NULL, " +
                    " FOREIGN KEY(IdPaciente) REFERENCES Paciente(CPF));",
            "CREATE TABLE Paciente ( CPF INTEGER NOT NULL UNIQUE, Nome TEXT NOT NULL, " +
                    "Genero TEXT NOT NULL, DtNascimento NUMERIC NOT NULL, Telefone INTEGER, " +
                    "DtCriado INTEGER NOT NULL, Medico TEXT NOT NULL, IDPaciente INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE);",
            "CREATE TABLE Pontos ( IdMapa INTEGER, Lado TEXT NOT NULL, IdPontos INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE," +
                    "Path NUMERIC, FOREIGN KEY(IdMapa) REFERENCES Mapa(ID));"
    };

    private BDSingleton(){
        Context ctx = AppContext.getAppContext();
        //Abre ou cria o bd
        db = ctx.openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null);
        //---slide2: SELECT * FROM sqlite_master WHERE type = 'table' ??
        Cursor c = find("sqlite_master", null, "type = 'table'", "");

        if(c.getCount() == 1){
            for(int i=0; i < SCRIPT_DATABASE_CREATE.length; i++){
                db.execSQL(SCRIPT_DATABASE_CREATE[i]);
            }
            Log.i("DATA_BASE", "Created and fill db");
        }
        c.close();
        //----

        //log criação
        Log.i("DATA_BASE", "Opened connection with db");
    }

    public long insert(String table, ContentValues values){
        //Insere registro
        long id = db.insert(table, null, values);
        //log inserção
        Log.i("DATA_BASE", "Inserted: " + id);
        return id;
    }

    public int update(String table, ContentValues values, String where){
        //Atualiza registro
        int count = db.update(table, values, where, null);
        //log update
        Log.i("DATA_BASE", "Updated: " + count);
        return count;
    }

    public int delete(String table, String where){
        //Deleta registros
        int count = db.delete(table, where, null);
        //log delete
        Log.i("DATA_BASE", "Deleted:: " + count);
        return count;
    }

    public Cursor find(String table, String columns[], String where, String orderBy){
        //Acha registros
        Cursor c;
        if(!where.equals(""))
            c = db.query(table, columns, where, null, null, null, orderBy);
        else
            c = db.query(table, columns, null, null, null, null, orderBy);
        //log achar
        Log.i("DATA_BASE", "Return: " + c.getCount());
        return c;
    }

    public void openConection(Context ctx){
        //CONEXAO COM O BANCO DE DADOS
        db = ctx.openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null);
        //log abertura
        Log.i("DATA_BASE", "Open connection");
    }

    public static BDSingleton getInstance(){
        return INSTANCE;
    }

    public void closeConection(){
        if (db != null)
            db.close();
        //log fechar
        Log.i("DATA_BASE", "Closed connection");
    }
}