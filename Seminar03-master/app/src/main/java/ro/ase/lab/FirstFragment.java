package ro.ase.lab;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FirstFragment extends Fragment {

    public FirstFragment() {
        super(R.layout.fragment_first);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText etBill = view.findViewById(R.id.etBill);
        EditText etPercentage = view.findViewById(R.id.etPercentage);
        Button btnCalculate= view.findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(v-> {
            try {
                {
                    String billText = etBill.getText().toString().trim().replace(',', '.');
                    String percentageText=etPercentage.getText().toString().trim().replace(',', '.');

                    if (billText.isEmpty() || percentageText.isEmpty())
                    {
                        Toast.makeText(requireContext(), "Completeaza ambele campuri", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    double tip= bill*precentage/100;

                    Bundle data= new Bundle();
                    data.putDouble("bill",bill);
                    data.putDouble("tip", tip);
                }
            }
        });


    }
}