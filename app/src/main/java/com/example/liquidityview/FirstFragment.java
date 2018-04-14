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

        HorizontalBarChart barChart = (HorizontalBarChart) myView.findViewById(R.id.chart1);

        setupBarChart();

        return myView;
    }

    private void setupBarChart() {


        ArrayList<BarEntry> barEntry = new ArrayList<>();

        barEntry.add(new BarEntry(240f,0));
        barEntry.add(new BarEntry(88f,1));
        barEntry.add(new BarEntry(150f,2));
        barEntry.add(new BarEntry(55f,3));
        barEntry.add(new BarEntry(230f,4));
        barEntry.add(new BarEntry(45f,5));
        barEntry.add(new BarEntry(45f,6));

        BarDataSet dataSet = new BarDataSet(barEntry,"Categories");

        ArrayList<String> labels = new ArrayList<>();

        labels.add("School Expenses");
        labels.add("Transport");
        labels.add("Health");
        labels.add("Entertainment");
        labels.add("Clothing");
        labels.add("Food");
        labels.add("Miscellaneous");

        BarData data = new BarData(labels, dataSet);
        barChart.setData(data);

//        barChart.setDescription("Expenses Breakdown");
        dataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);

        barChart.invalidate();
    }
}
