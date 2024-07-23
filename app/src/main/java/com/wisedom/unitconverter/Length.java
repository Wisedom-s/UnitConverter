package com.wisedom.unitconverter;

import android.content.Intent;
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

public class Length extends AppCompatActivity {

    Switch switch1;
    Button button2;
    EditText editlength;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_length);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        switch1 = findViewById(R.id.switch1);
        editlength = findViewById(R.id.editlength);
        textView2 = findViewById(R.id.textView2);
        button2 = findViewById(R.id.button2);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {
                    // inform the user of the conversion being made
                    Toast.makeText(Length.this, "Conversion from feet to metres", Toast.LENGTH_SHORT).show();
                } else {
                    // Inform the user of the conversion being made
                    Toast.makeText(Length.this, "Conversion from Metres to Feet", Toast.LENGTH_SHORT).show();
                    //Declare a function for the button to convert from m - ft
                    button2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String inputText = editlength.getText().toString();
                            if (!inputText.isEmpty()) {
                                double feet = Double.parseDouble(inputText);
                                double result = mToFt(feet);
                                textView2.setText(String.valueOf(result));
                            } else {
                                editlength.setError("Enter your height in Metres");
                            }
                        }
                    });
                }

                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        feetToMetres();

                    }
                });

            }

            private void feetToMetres() {
                String inputText = editlength.getText().toString();
                if (!inputText.isEmpty()) {
                    double value = Double.parseDouble(inputText);
                    double result = value * 0.31;
                    textView2.setText(String.valueOf(result));
                } else {
                    editlength.setError("Enter your height");
                }
            }

            public double mToFt(double feet) {
                return feet * 3.281;
            }


        });
    }
}