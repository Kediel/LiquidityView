package com.example.liquidityview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


public class ManualActivity extends AppCompatActivity {
    private EditText txtIncome;
    private EditText txtSavings;
    private EditText txtLoan;
    private TextView txtResult;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual);
        txtIncome = findViewById(R.id.Income);
        txtSavings = findViewById(R.id.Savings);
        txtLoan = findViewById(R.id.Loan2);

        txtResult = findViewById(R.id.result);
    }
    private void calculate_Click(View v){
        Integer.parseInt(txtIncome.getText().toString());

        float results = Float.parseFloat(txtIncome.getText().toString()) + Float.parseFloat(txtSavings.getText().toString()) - Float.parseFloat(txtLoan.getText().toString());

        TextView t = (TextView) findViewById(R.id.result);
        t.setText(""+results);
    }
}
