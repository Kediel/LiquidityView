package com.example.liquidityview;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * Created by QuanPhan on 4/14/18.
 */

public class FirstFragment extends Fragment {

    HorizontalBarChart barChart;
    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        myView = inflater.inflate(R.layout.first_layout, container, false);

        HorizontalBarChart barChart = (HorizontalBarChart) findViewById(R.id.chart1);


        ArrayList<BarEntry> barEntries = new ArrayList<>();

        barEntries.add(new BarEntry(240f,0));
        barEntries.add(new BarEntry(88f,1));
        barEntries.add(new BarEntry(150f,2));
        barEntries.add(new BarEntry(55f,3));
        barEntries.add(new BarEntry(230f,5));
        barEntries.add(new BarEntry(45f,5));

        BarDataSet barDataSet = new BarDataSet (barEntries,"Categories");

        ArrayList<String> theExpense = new ArrayList<>();

        theExpense.add("School Expenses");
        theExpense.add("Transport");
        theExpense.add("Health");
        theExpense.add("Entertainment");
        theExpense.add("Clothing");
        theExpense.add("Food");
        theExpense.add("Miscellaneous");

        BarData data = new BarData (theExpense, barDataSet);
        barChart.setData(data);

        barChart.setDescription("Expenses Breakdown");
        barDataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);

        return myView;
    }
}
