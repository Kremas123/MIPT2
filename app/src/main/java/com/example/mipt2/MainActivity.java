package com.example.mipt2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtInputText;
    private Spinner spnCountType;
    private Button btnCalculate;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtInputText = findViewById(R.id.txtInputText);
        spnCountType = findViewById(R.id.spnCountType);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtResult = findViewById(R.id.txtResult);


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performCount();
            }
        });
    }


    private void performCount() {
        String inputText = txtInputText.getText().toString().trim();

        if (inputText.isEmpty()) {
            Toast.makeText(MainActivity.this, "Please enter some text.", Toast.LENGTH_SHORT).show();
            return;
        }


        String countType = spnCountType.getSelectedItem().toString();
        TextCounter textCounter = new TextCounter();

        int result = 0;
        if (countType.equals("Word Count")) {
            result = textCounter.getWordsCount(inputText);
        } else if (countType.equals("Character Count")) {
            result = textCounter.getCharacterCount(inputText);
        }

        txtResult.setText("Result: " + result);
    }
}
