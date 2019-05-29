package com.luciana.techpain;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

class DataBase implements BaseColumns {
    private static final DataBase ourInstance = new DataBase();
    Context ctx = MyApp.getAppContext();
    DataBaseHelper dbHelper = new DataBaseHelper(ctx);

    static DataBase getInstance() {
        return ourInstance;
    }

    private DataBase() {
    }

    public static final String TABLE_NAME_PACIENTE = "paciente";
    public static final String TABLE_NAME_MAPA = "mapa";
    public static final String TABLE_NAME_PONTOS = "pontos";

    public static final String COLUMN_NAME_IDPONTOS = "idPontos";
    public static final String COLUMN_NAME_IDMAPA = "idMapa";
    public static final String COLUMN_NAME_LADO = "lado";
    public static final String COLUMN_NAME_PATH = "path";


    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME_PONTOS + " (" +
                    _ID + " INTEGER PRIMARY KEY," +
                    COLUMN_NAME_IDPONTOS + " INTEGER," +
                    COLUMN_NAME_IDMAPA + " INTEGER," +
                    COLUMN_NAME_LADO + "TEXT," +
                    COLUMN_NAME_PATH + "NUMERIC)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME_PONTOS;


    public class DataBaseHelper extends SQLiteOpenHelper {
        // If you change the database schema, you must increment the database version.
        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "DataBase.db";

        public DataBaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        public void insert(){
            // Gets the data repository in write mode
            SQLiteDatabase db = dbHelper.getWritableDatabase();

// Create a new map of values, where column names are the keys
            ContentValues values = new ContentValues();
//            values.put(COLUMN_NAME_IDPONTOS, );
//            values.put(COLUMN_NAME_IDMAPA, );
//            values.put(COLUMN_NAME_LADO, );
//            values.put(COLUMN_NAME_PATH, );

// Insert the new row, returning the primary key value of the new row
            long newRowId = db.insert(TABLE_NAME_PONTOS, null, values);

        }

        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_ENTRIES);
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // This database is only a cache for online data, so its upgrade policy is
            // to simply to discard the data and start over
            db.execSQL(SQL_DELETE_ENTRIES);
            onCreate(db);
        }

        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            onUpgrade(db, oldVersion, newVersion);
        }
    }
}
