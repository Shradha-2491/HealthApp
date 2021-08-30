package com.mycoding.healthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BMICalActivity extends AppCompatActivity {

    EditText weight, height;
    TextView Output;
    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_cal);

        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        Output = findViewById(R.id.output);
        calculate = findViewById(R.id.calc);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weightStr = weight.getText().toString();
                String heightStr = height.getText().toString();

                if (heightStr != null && !"".equals(heightStr) && weightStr != null && !"".equals(weightStr)){
                    float W = Float.parseFloat(weightStr);
                    float H = Float.parseFloat(heightStr)/100;

                    float result = W/ (H * H);

                    displayResult(result);
                }
            }
        });
    }

    private void displayResult(float result) {
        String num_res = result+"";

        if (result < 18.9){
            Toast.makeText(BMICalActivity.this, "Below Normal Weight", Toast.LENGTH_SHORT).show();
        }
        if (result >= 18.9 && result < 24.9){
            Toast.makeText(BMICalActivity.this, "Normal Weight", Toast.LENGTH_SHORT).show();
        }
        if (result > 25){
            Toast.makeText(BMICalActivity.this, "Above Normal Weight", Toast.LENGTH_SHORT).show();
        }
        
        Output.setText(num_res);
    }
}