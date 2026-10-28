package com.example.seminar3;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private ActivityResultLauncher<Intent> launcherRezultat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        launcherRezultat = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        Intent data = result.getData();


                        String mesajInapoi = data.getStringExtra("mesaj_inapoi");
                        int suma = data.getIntExtra("suma_calculata", 0);


                        String textAfisat = mesajInapoi + "\nSuma primita inapoi: " + suma;
                        Toast.makeText(MainActivity.this, textAfisat, Toast.LENGTH_LONG).show();
                    }
                }
        );
    }


    public void deschideActivitate(View view) {
        Intent it = new Intent(this, ActivitateRezultat.class);

        Bundle bundle = new Bundle();
        bundle.putString("mesaj", "Trimit numerele pentru suma:");
        bundle.putInt("numar1", 15);
        bundle.putInt("numar2", 25);

        it.putExtras(bundle);

        launcherRezultat.launch(it);
    }
}