package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;

public class AdaugareImobiliar extends AppCompatActivity {

    private EditText etAdresa, etPret;
    private RadioGroup rgMoneda;
    private Spinner spTipImobil;
    private CheckBox cbVanzare;
    private RatingBar ratingBar;
    private Button btnSalveaza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adaugare_imobiliar);

        etAdresa = findViewById(R.id.etAdresa);
        etPret = findViewById(R.id.etPret);
        rgMoneda = findViewById(R.id.rgMoneda);
        spTipImobil = findViewById(R.id.spTipImobil);
        cbVanzare = findViewById(R.id.cbVanzare);
        ratingBar = findViewById(R.id.ratingBar);
        btnSalveaza = findViewById(R.id.btnSalveaza);


        String[] tipuri = {"Apartament", "Casa", "Teren", "Spatiu Comercial"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, tipuri);
        spTipImobil.setAdapter(adapter);

        btnSalveaza.setOnClickListener(v -> {
            String adresa = etAdresa.getText().toString();
            double pret = etPret.getText().toString().isEmpty() ? 0 : Double.parseDouble(etPret.getText().toString());

            int selectedRadioId = rgMoneda.getCheckedRadioButtonId();
            RadioButton rb = findViewById(selectedRadioId);
            String moneda = (rb != null) ? rb.getText().toString() : "EUR";

            String tip = spTipImobil.getSelectedItem().toString();
            boolean esteVanzare = cbVanzare.isChecked();
            float rating = ratingBar.getRating();


            Imobil imobilNou = new Imobil(adresa, pret, esteVanzare, tip, moneda, rating);

            Intent intentResult = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("obiect_imobil", imobilNou);
            intentResult.putExtras(bundle);

            setResult(RESULT_OK, intentResult);
            finish();
        });
    }
}