package com.luciana.techpain;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class Intensity extends AppCompatActivity {

    FloatingActionButton fab;
    SeekBar SB;
    ImageView iv;
    Intent it;
    TextView dor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intensity);
        it = new Intent(getBaseContext(), BodyImage.class);
        iv = (ImageView) findViewById(R.id.icones);
        SB = (SeekBar) findViewById(R.id.seekbar);
        SB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Toast.makeText(getApplicationContext(), "Dor: " + progress, Toast.LENGTH_LONG).show();
                //dor.setText("Intensidade da dor: " + progress);
                if(progress == 0) iv.setImageResource(R.drawable.face1);
                else if(progress == 1) iv.setImageResource(R.drawable.faces12);
                else if(progress == 2) iv.setImageResource(R.drawable.face2);
                else if(progress == 3) iv.setImageResource(R.drawable.faces23);
                else if(progress == 4) iv.setImageResource(R.drawable.face3);
                else if(progress == 5) iv.setImageResource(R.drawable.faces34);
                else if(progress == 6) iv.setImageResource(R.drawable.face4);
                else if(progress == 7) iv.setImageResource(R.drawable.faces45);
                else if(progress == 8) iv.setImageResource(R.drawable.face5);
                else if(progress == 9) iv.setImageResource(R.drawable.faces56);
                else if(progress == 10) iv.setImageResource(R.drawable.face6);
                it.putExtra("progress", progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        fab = (FloatingActionButton) findViewById(R.id.fab);
    }

    public void onClickFloating(View view){
        startActivity(it);
    }

}
