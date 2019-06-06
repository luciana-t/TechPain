package com.luciana.techpain;

import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class BodyImage extends AppCompatActivity {


    Button btn_desfaz;
    Button btn_salvar;
    Button btn_voltar;
    Body1 body_frente, body_tras;   //lado 1 = frente --------- lado 2 = tras
    ConstraintLayout layout;
    Intent it = getIntent(); //progresso passado

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        body_tras = new Body1(this, 2);
        body_frente = new Body1(this, 1);

        setContentView(R.layout.activity_body_image);
        layout = (ConstraintLayout)findViewById(R.id.container);

       // if(DataBase.getInstance().lado == 1){
        if(true){
            Log.i("BODYIMAGE", "onCreate lado 1 frente");
            layout.addView(body_frente);
        }
        else{
            Log.i("BODYIMAGE", "onCreate lado 2 costas");
            layout.addView(body_tras);
        }

        btn_desfaz = (Button) findViewById(R.id.btn_desfaz);
        btn_salvar = (Button) findViewById(R.id.btn_salvar);
        btn_voltar = (Button) findViewById(R.id.btn_voltar_imagem);
    }

    public void voltar(View view){
        finish();
    }

    public void onClickLado(View view){
       // if (DataBase.getInstance().lado == 1) {
            if(true){
          //  DataBase.getInstance().lado = 2;
            layout.removeView(body_frente);
            layout.addView(body_tras);
            Log.i("BODYIMAGE", "onClickLado 10");
        }
        else{
         //   DataBase.getInstance().lado = 1;
            layout.removeView(body_tras);
            layout.addView(body_frente);
            Log.i("BODYIMAGE", "onClickLado = 0");
        }
    }

    public void onClickBtnSalva(View view){

        Intent it = new Intent(getBaseContext(), Ampere.class);
        startActivity(it);
    }

    public void onClickBtnDesfaz(View view){
//        if(DataBase.getInstance().lado == 1) {
        if(true){
            body_frente.reset();
        }
        else {
            body_tras.reset();
            Log.i("BODYIMAGE", "onClickBtnDesfaz lado 2");
        }
    }
}
