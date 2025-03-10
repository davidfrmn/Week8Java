package com.example.week8java;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView textResult;
    private EditText inputFirstNumber;
    private EditText inputSecondNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textResult = findViewById(R.id.textResult);
        inputFirstNumber = findViewById(R.id.inputFirstNumber);
        inputSecondNumber = findViewById(R.id.inputSecondNumber);

    }

    private int valueOf(EditText textField){
        return Integer.parseInt(textField.getText().toString());
    }
    public void plus(View view){
        int firstNumber = valueOf(inputFirstNumber);
        int secondNumber = valueOf(inputSecondNumber);
        textResult.setText(String.valueOf(firstNumber+secondNumber));
        //
    }
    public void minus(View view){
        int firstNumber = valueOf(inputFirstNumber);
        int secondNumber = valueOf(inputSecondNumber);
        textResult.setText(String.valueOf(firstNumber-secondNumber));
    }
    public void multiply(View view){
        int firstNumber = valueOf(inputFirstNumber);
        int secondNumber = valueOf(inputSecondNumber);
        textResult.setText(String.valueOf(firstNumber*secondNumber));
    }
    public void divide(View view){
        double firstNumber = valueOf(inputFirstNumber);
        int secondNumber = valueOf(inputSecondNumber);
        String output;
        if (secondNumber==0){
            output = "You can't divide by zero!";
        }else{
            output = Double.toString(firstNumber/secondNumber);
        }

        textResult.setText(output);
    }
}