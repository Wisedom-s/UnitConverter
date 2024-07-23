package com.wisedom.unitconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WeightConv extends AppCompatActivity {

    Button button;
    EditText editText;
    TextView textView3;
    Switch switch2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_weight_conv);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);
        switch2 = findViewById(R.id.switch2);
        textView3 = findViewById(R.id.textView3);

        switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {
                    Toast.makeText(WeightConv.this, "Conversion from pounds to kilograms", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(WeightConv.this, "Conversion from kilograms to pounds", Toast.LENGTH_SHORT).show();
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String inputText = editText.getText().toString();
                            if(!inputText.isEmpty()){
                            double kilos = Double.parseDouble(textView3.getText().toString());
                            double pounds = convertKilosToPounds(kilos);
                            editText.setText(String.valueOf(pounds));
                            }
                            else {
                                editText.setError("Enter your weight in kg");
                            }
                        }
                    });
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = editText.getText().toString();
                if(!inputText.isEmpty()){
                double pounds = Double.parseDouble(inputText);
                double kilograms = convertPoundsToKilograms(pounds);
                // Do something with the kilograms value
                textView3.setText(String.valueOf(kilograms));
                }
                else {
                    editText.setError("Enter your weight in ibs");
                }
            }
        });
    }

    public double convertPoundsToKilograms(double pounds) {

        return pounds * 0.45;
    }

    public double convertKilosToPounds (double kilos){
        return kilos * 2.21;
    }
}