package com.example.myapplication;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityResultLauncher<Intent> launcherAdaugare;

    private ArrayList<Imobil> listaImobile = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        launcherAdaugare = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        Bundle bundle = result.getData().getExtras();
                        if (bundle != null) {
                            Imobil imobilPrimit = (Imobil) bundle.getSerializable("obiect_imobil");
                            if (imobilPrimit != null) {
                                listaImobile.add(imobilPrimit);
                                Toast.makeText(MainActivity.this, "Imobil adăugat! Total: " + listaImobile.size(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
        );

        Button btnDeschide = findViewById(R.id.btnAdauga);
        if (btnDeschide != null) {
            btnDeschide.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, AdaugareImobiliar.class);
                launcherAdaugare.launch(intent);
            });
        }

        Button btnDeschideAI = findViewById(R.id.btnAdaugaAI);
        if (btnDeschideAI != null) {
            btnDeschideAI.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, AdaugareImobiliarAI.class);
                launcherAdaugare.launch(intent);
            });
        }


        Button btnVeziLista = findViewById(R.id.btnVeziLista);
        if (btnVeziLista != null) {
            btnVeziLista.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, ListaImobilActivity.class);
                intent.putExtra("lista_imobile", listaImobile);
                startActivity(intent);
            });
        }
    }
}