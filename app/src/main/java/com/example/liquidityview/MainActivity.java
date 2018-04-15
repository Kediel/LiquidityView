package com.example.liquidityview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    float Expenses[] = {77, 20.5f, 106.3f, 67.25f, 12, 59.8f };

    String Categories[] = { "Food", "Travel", "Miscellaneous", "Transportation", "Shopping", "Entertainment"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupPieChart();

    }

    public void viewBreakdown(View view) {
        Intent intent = new Intent(this, FinancialBreakdown.class);
        startActivity(intent);
    }

    private void setupPieChart() {

        List<PieEntry> pieEntries = new ArrayList<>();

        for (int i = 0; i < Expenses.length; i++) {
            pieEntries.add(new PieEntry(Expenses[i], Categories[i]));
        }

        PieDataSet dataSet = new PieDataSet(pieEntries, "Budget This Month");
        PieData data = new PieData(dataSet);

        PieChart chart = (PieChart) findViewById(R.id.chart);

        chart.setData(data);
        data.setValueTextSize(15f);
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        chart.animateXY(1000, 1000);
        chart.invalidate();
    }

}
