package com.example.volumecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class CylinderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cylinder);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText editText = findViewById(R.id.editText);
        EditText ed2=findViewById(R.id.editText2);
        TextView rezultat = findViewById(R.id.textView);
        Button calculate = findViewById(R.id.buttonCalculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String height = editText.getText().toString();
                String radious = ed2.getText().toString();
                double valoareH= Double.parseDouble(height);
                double valoareR= Double.parseDouble(radious);
                double volume =  Math.PI*valoareR*valoareR*valoareH;
                DecimalFormat decimalFormat = new DecimalFormat("#.####");
                String formattedNumber = decimalFormat.format(volume);
                rezultat.setText("" + formattedNumber+" m^3");


            }
        });
    }
}