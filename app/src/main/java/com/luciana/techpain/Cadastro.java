package com.luciana.techpain;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Cadastro extends AppCompatActivity {

    Context ctx = MyApp.getAppContext();
    DataBase.DataBaseHelper dbHelper = new DataBase.DataBaseHelper(ctx);

    EditText nome, cpf, gender, dtnascimento, tel, med;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        nome = (EditText) findViewById(R.id.edt_nome);
        cpf = (EditText) findViewById(R.id.edt_cpf1);
        gender = (EditText) findViewById(R.id.edt_genero);
        dtnascimento = (EditText) findViewById(R.id.edt_dtnascimento);
        tel = (EditText) findViewById(R.id.edt_telefone);
        med = (EditText) findViewById(R.id.edt_med);
    }

    public void clickCad(View view){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();

        // Começo dos values.put(coluna, coteudo);

        values.put(DataBase.DataBaseEntry.COLUMN_NAME_CPF, cpf.getText().toString());
        values.put(DataBase.DataBaseEntry.COLUMN_NAME_NOME, nome.getText().toString());
        values.put(DataBase.DataBaseEntry.COLUMN_NAME_GENERO, gender.getText().toString());
        values.put(DataBase.DataBaseEntry.COLUMN_NAME_DTNASCIMENTO, dtnascimento.getText().toString());
        values.put(DataBase.DataBaseEntry.COLUMN_NAME_TELEFONE, tel.getText().toString());
        values.put(DataBase.DataBaseEntry.COLUMN_NAME_DTCRIADO, dtnascimento.getText().toString()); //TROCAR PRO DIA DE HOJE
        values.put(DataBase.DataBaseEntry.COLUMN_NAME_MEDICO, med.getText().toString());
        //values.put(DataBase.DataBaseEntry.COLUMN_NAME_IDPACIENTE, /*RANDOM*/);
        long newRowId = db.insert(DataBase.DataBaseEntry.TABLE_NAME_PACIENTE, null, values);

        Intent it = new Intent(getBaseContext(), PerfilAdicao.class);
        startActivity(it);
    }

    public void clickButtonVolta(View view){
        finish();
    }
}
