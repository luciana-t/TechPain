package com.luciana.techpain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Ampere extends AppCompatActivity {

    Button btn_confirma;
    EditText edt_ampere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ampere);
        btn_confirma = (Button) findViewById(R.id.btn_confirma);
        edt_ampere = (EditText) findViewById(R.id.edt_ampere);
    }

    public void onClickConfirma (View view){

        Intent it = new Intent(getBaseContext(), PerfilAdicao.class);
        startActivity(it);
        finish();
    }
}
