package com.luciana.techpain;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class PerfilAdicao extends AppCompatActivity{
    RecyclerView recyclerView;
    MyAdapter adapter;
    List<listItem> listaitem;

    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_adicao);

        listaitem = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listaitem.add(
                new listItem("gabriel", "eh um cara legal")
        );
        listaitem.add(
                new listItem("lu", "eh uma muie legal")
        );
        listaitem.add(
                new listItem("socrates", "eh um cara legal")
        );
        listaitem.add(
                new listItem("gabriel", "eh um cara legal")
        );
        listaitem.add(
                new listItem("lu", "eh uma muie legal")
        );
        listaitem.add(
                new listItem("socrates", "eh um cara legal")
        );
        listaitem.add(
                new listItem("gabriel", "eh um cara legal")
        );
        listaitem.add(
                new listItem("lu", "eh uma muie legal")
        );
        listaitem.add(
                new listItem("socrates", "eh um cara legal")
        );
        adapter = new MyAdapter(listaitem, this);
        recyclerView.setAdapter(adapter);

        fab = (FloatingActionButton) findViewById(R.id.fab);
    }

    public void onClickFloating(View view){
        Intent it = new Intent(getBaseContext(), Intensity.class);
        startActivity(it);
    }
}
