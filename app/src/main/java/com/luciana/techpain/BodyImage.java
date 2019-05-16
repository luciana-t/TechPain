package com.luciana.techpain;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class BodyImage extends AppCompatActivity {


    Button btn_desfaz;
    Button btn_salvar;
    Button btn_voltar;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Body1 body = new Body1(this);
        setContentView(R.layout.activity_body_image);
        ConstraintLayout layout = (ConstraintLayout)findViewById(R.id.container);
        layout.addView(body);
        //AQUI MEXE NOS BOTOES

        btn_desfaz = (Button) findViewById(R.id.btn_desfaz);
        btn_salvar = (Button) findViewById(R.id.btn_salvar);
        btn_voltar = (Button) findViewById(R.id.btn_voltar_imagem);

    }

    public void voltar(View view){
        finish();

    }

    public void onClickBtnSalva(View view){

    }

    public void onClickBtnDesfaz(View view){

    }
}
