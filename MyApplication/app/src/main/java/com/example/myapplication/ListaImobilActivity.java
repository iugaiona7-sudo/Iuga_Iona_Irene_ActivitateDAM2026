package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListaImobilActivity extends AppCompatActivity {

    private ListView lvImobile;
    private ArrayList<Imobil> listaImobile;
    private ArrayAdapter<Imobil> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_imobil);

        lvImobile = findViewById(R.id.lvImobile);
// buton in apoi in lista
        Button btnBack = findViewById(R.id.btnBack);
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }


        listaImobile = (ArrayList<Imobil>) getIntent().getSerializableExtra("lista_imobile");
        if (listaImobile == null) {
            listaImobile = new ArrayList<>();
        }

// adapter
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaImobile);
        lvImobile.setAdapter(adapter);


        lvImobile.setOnItemClickListener((parent, view, position, id) -> {
            Imobil imobilSelectat = listaImobile.get(position);
            Toast.makeText(ListaImobilActivity.this, "Selectat: " + imobilSelectat.toString(), Toast.LENGTH_SHORT).show();
        });


        lvImobile.setOnItemLongClickListener((parent, view, position, id) -> {
            Imobil imobilSters = listaImobile.remove(position);
            adapter.notifyDataSetChanged();
            Toast.makeText(ListaImobilActivity.this, "Șters: " + imobilSters.toString(), Toast.LENGTH_SHORT).show();
            return true;
        });
    }
}