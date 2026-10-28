package com.example.seminar3;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class ActivitateRezultat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String mesajPrimit = bundle.getString("mesaj", "");
            int num1 = bundle.getInt("numar1", 0);
            int num2 = bundle.getInt("numar2", 0);


            String textToast = mesajPrimit + "\nSuma initiala: " + (num1 + num2);
            Toast.makeText(this, textToast, Toast.LENGTH_SHORT).show();


            int suma = num1 + num2;


            Intent intentRaspuns = new Intent();
            intentRaspuns.putExtra("mesaj_inapoi", "Suma a fost calculata cu succes!");
            intentRaspuns.putExtra("suma_calculata", suma);


            setResult(RESULT_OK, intentRaspuns);
        }
    }
}
