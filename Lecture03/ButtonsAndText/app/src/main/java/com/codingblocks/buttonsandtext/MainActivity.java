package com.codingblocks.buttonsandtext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etVar1, etVar2;
    Button btnAdd;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etVar1 = findViewById(R.id.etVar1);
        etVar2 = findViewById(R.id.etVar2);
        btnAdd = findViewById(R.id.btnAdd);
        tvResult = findViewById(R.id.tvResult);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int var1 = Integer.valueOf(etVar1.getText().toString());
                int var2 = Integer.valueOf(etVar2.getText().toString());
                int result = var1 + var2;

                tvResult.setText(String.valueOf(result));
            }
        });


    }
}
