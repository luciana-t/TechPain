package com.luciana.techpain;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

public final class DataBase{
    Paciente paciente = new Paciente();
//    private static final DataBase ourInstance = new DataBase();
//
//    public int lado = 1;

//    static DataBase getInstance() {
//        return ourInstance;
//    }

    //Intancia da subclasse SQLiteOpenHelper
    Context ctx = MyApp.getAppContext();
    DataBaseHelper dbHelper = new DataBaseHelper(ctx);

    private DataBase(){
        //SQLiteDatabase db = dbHelper.getWritableDatabase();
        //dbHelper.onCreate(db);
        paciente.setGender(1);
    }

    public static class DataBaseEntry implements BaseColumns{

        public static final String TABLE_NAME_PACIENTE = "paciente";
        public static final String TABLE_NAME_MAPA = "mapa";
        public static final String TABLE_NAME_PONTOS = "pontos";

        public static final String COLUMN_NAME_CPF = "cpf";
        public static final String COLUMN_NAME_NOME = "nome";
        public static final String COLUMN_NAME_GENERO = "genero";
        public static final String COLUMN_NAME_DTNASCIMENTO = "dtNascimento";
        public static final String COLUMN_NAME_TELEFONE = "telefone";
        public static final String COLUMN_NAME_DTCRIADO = "dtCriado";
        public static final String COLUMN_NAME_MEDICO = "medico";
        public static final String COLUMN_NAME_IDPACIENTE = "idPaciente";

        public static final String COLUMN_NAME_IDMAPA = "idMapa";
        public static final String COLUMN_NAME_IDPACIENTE_FOREIGN = "idpaciente";
        public static final String COLUMN_NAME_DTADICIONADO = "dtAdicionado";
        public static final String COLUMN_NAME_AMPERE = "ampere";
        public static final String COLUMN_NAME_LADO = "lado";
        public static final String COLUMN_NAME_INTENSIDADE = "intensidade";


        public static final String COLUMN_NAME_IDPONTOS = "idPontos";
        public static final String COLUMN_NAME_IDMAPA_FOREIGN = "idMapa";
        public static final String COLUMN_NAME_CORDX = "x";
        public static final String COLUMN_NAME_CORDY = "y";

    }
    private static final String SQL_CREATE_ENTRIES_PACIENTE =
            "CREATE TABLE " + DataBaseEntry.TABLE_NAME_PACIENTE + " (" +
                DataBaseEntry._ID + " INTEGER PRIMARY KEY, " +
                DataBaseEntry.COLUMN_NAME_CPF + " INTEGER, " +
                DataBaseEntry.COLUMN_NAME_NOME + " TEXT, " +
                DataBaseEntry.COLUMN_NAME_GENERO + "TEXT, " +
                DataBaseEntry.COLUMN_NAME_DTNASCIMENTO + "NUMERIC, " +
                DataBaseEntry.COLUMN_NAME_TELEFONE + "INTEGER, " +
                DataBaseEntry.COLUMN_NAME_DTCRIADO + "NUMERIC, " +
                DataBaseEntry.COLUMN_NAME_MEDICO + "TEXT, " +
                DataBaseEntry.COLUMN_NAME_IDPACIENTE + "INTEGER)";

    private static final String SQL_CREATE_ENTRIES_MAPA =
            "CREATE TABLE " + DataBaseEntry.TABLE_NAME_MAPA + " (" +
                DataBaseEntry._ID + "INTEGER PRIMARY KEY," +
                DataBaseEntry.COLUMN_NAME_IDPACIENTE_FOREIGN + "INTEGER, " +
                DataBaseEntry.COLUMN_NAME_DTADICIONADO + "NUMERIC, " +
                DataBaseEntry.COLUMN_NAME_AMPERE + "NUMERIC, " +
                DataBaseEntry.COLUMN_NAME_LADO + "TEXT, " +
                DataBaseEntry.COLUMN_NAME_INTENSIDADE + "INTEGER)";

    private static final String SQL_CREATE_ENTRIES_PONTOS =
            "CREATE TABLE " + DataBaseEntry.TABLE_NAME_PONTOS + " (" +
                DataBaseEntry._ID + "INTEGER PRIMARY KEY, " +
                DataBaseEntry.COLUMN_NAME_IDMAPA_FOREIGN + "INTEGER, " +
                DataBaseEntry.COLUMN_NAME_IDPONTOS + "INTEGER, " +
                    DataBaseEntry.COLUMN_NAME_CORDX + "NUMERIC, " +
                    DataBaseEntry.COLUMN_NAME_CORDY + "NUMERIC)";

    private static final String SQL_DELETE_ENTRIES_PACIENTE =
            "DROP TABLE IF EXISTS " + DataBaseEntry.TABLE_NAME_PACIENTE;

    private static final String SQL_DELETE_ENTRIES_MAPA =
            "DROP TABLE IF EXISTS " + DataBaseEntry.TABLE_NAME_MAPA;

    private static final String SQL_DELETE_ENTRIES_PONTOS =
            "DROP TABLE IF EXISTS " + DataBaseEntry.TABLE_NAME_PONTOS;



    public static class DataBaseHelper extends SQLiteOpenHelper {
        // If you change the database schema, you must increment the database version.
        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "DataBase.db";

        public DataBaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_ENTRIES_PACIENTE);
            db.execSQL(SQL_CREATE_ENTRIES_PONTOS);
            db.execSQL(SQL_CREATE_ENTRIES_MAPA);
        }
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // This database is only a cache for online data, so its upgrade policy is
            // to simply to discard the data and start over
            db.execSQL(SQL_DELETE_ENTRIES_PACIENTE);
            db.execSQL(SQL_DELETE_ENTRIES_MAPA);
            db.execSQL(SQL_DELETE_ENTRIES_PONTOS);
            onCreate(db);
        }
        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            onUpgrade(db, oldVersion, newVersion);
        }

    }

}