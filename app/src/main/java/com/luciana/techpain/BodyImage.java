package com.luciana.techpain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BodyImage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_image);

        Body1 body = new Body1(this);
        setContentView(body);
    }
}
