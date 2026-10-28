package com.example.myapplication;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ActivityResultLauncher<Intent> launcherAdaugare;

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
                                Toast.makeText(MainActivity.this, imobilPrimit.toString(), Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                }
        );


        Button btnDeschideAdaugare = findViewById(R.id.btnAdauga);
        if (btnDeschideAdaugare != null) {
            btnDeschideAdaugare.setOnClickListener(v -> {
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
    }
}
