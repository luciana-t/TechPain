package com.luciana.techpain;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Cadastro extends AppCompatActivity {
    /*
        Utilizando um objeto Singleton:
            Cursos c = BDSingleton.getInstance().find("tipo", new String[]{"idTipo", "nome}, "", "");
            BDSingleton.getInstance().delete("pokemonusuario", "");


                age.getText().toString()
        */

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
            /*
            ContentValues valores = new ContentValues();
            valores.put("nome", "Bill)
            valores.put(tel ", "9999 9999");
            db.update(“Autor”, valores, "nome = Deitel ’ ", null );*/

    public void clickCad(View view){
        ContentValues values = new ContentValues();
        values.put("CPF", cpf.getText().toString());
        values.put("Nome", nome.getText().toString());
        values.put("Genero", gender.getText().toString());
        values.put("DtNascimento", dtnascimento.getText().toString());
        values.put("Telefone", tel.getText().toString());
        values.put("DtCriado", dtnascimento.getText().toString()); //TROCAR PRO DIA DE HOJE
        values.put("Medico", med.getText().toString());
        //Cursor c = BDSingleton.getInstance().insert("Paciente", values);
        Intent it = new Intent(getBaseContext(), PerfilAdicao.class);
        startActivity(it);
    }

    public void clickButtonVolta(View view){
        Intent it = new Intent(getBaseContext(), MainActivity.class);
        startActivity(it);
    }
}
