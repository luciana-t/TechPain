package com.luciana.techpain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Cadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }
    public void clickButtonVolta(View view){
        Intent it = new Intent(getBaseContext(), MainActivity.class);
        startActivity(it);
    }
}
