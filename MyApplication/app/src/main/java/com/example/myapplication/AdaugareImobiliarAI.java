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

public class AdaugareImobiliarAI extends AppCompatActivity {

    private EditText etAdresa, etPret;
    private RadioGroup rgMoneda;
    private Spinner spTipImobil;
    private CheckBox cbVanzare;
    private RatingBar ratingBar;
    private Button btnSalveaza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adaugare_imobiliar_ai);

        etAdresa = findViewById(R.id.etAdresaAI);
        etPret = findViewById(R.id.etPretAI);
        rgMoneda = findViewById(R.id.rgMonedaAI);
        spTipImobil = findViewById(R.id.spTipImobilAI);
        cbVanzare = findViewById(R.id.cbVanzareAI);
        ratingBar = findViewById(R.id.ratingBarAI);
        btnSalveaza = findViewById(R.id.btnSalveazaAI);

        String[] tipuri = {"Apartament", "Casă", "Teren", "Spațiu Comercial"};
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