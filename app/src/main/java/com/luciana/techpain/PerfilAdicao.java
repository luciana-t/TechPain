package com.luciana.techpain;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PerfilAdicao extends AppCompatActivity {

    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_adicao);

        fab = (FloatingActionButton) findViewById(R.id.fab);
    }

    public void onClickFloating(View view){
        Intent it = new Intent(getBaseContext(), BodyImage.class);
        startActivity(it);
    }
}
