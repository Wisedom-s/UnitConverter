package com.wisedom.unitconverter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MetresToFt extends AppCompatActivity {
    Switch switch1;

    private Switch activitySwitch;
    EditText editlength;
    TextView textView2;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_metres_to_ft);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        activitySwitch = findViewById(R.id.switch1);

        activitySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Switch to MetresToFt activity
                    Intent intent = new Intent(MetresToFt.this, Length.class);
                    startActivity(intent);
                } else {
                    // Switch back to Length activity (no need to explicitly startit, just finish the current one)
                    finish();
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate ();
            }
        });
    }
    private void calculate() {
        String inputText = editlength.getText().toString();
        double value = Double.parseDouble(inputText);
        double result = value * 3.281;
        textView2.setText(String.valueOf(result));
    }
}
