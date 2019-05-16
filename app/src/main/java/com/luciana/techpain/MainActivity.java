
package com.luciana.techpain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnLog, btnCad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLog = (Button) findViewById(R.id.btn_entrar);
        btnCad = (Button) findViewById(R.id.btn_cadastro);
    }

    public void clickButtonLog(View view){
        Intent it = new Intent(getBaseContext(),PerfilAdicao.class);
        startActivity(it);

    }
    public void clickButtonCad(View  view){
        Intent it = new Intent(getBaseContext(), Cadastro.class);
        startActivity(it);
    }
}
