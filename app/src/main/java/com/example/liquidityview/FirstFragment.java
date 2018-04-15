package com.example.liquidityview;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * Created by QuanPhan on 4/14/18.
 */

public class FirstFragment extends Fragment {

    View myView;
    HorizontalBarChart barChart;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        myView = inflater.inflate(R.layout.first_layout, container, false);

        return myView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        HorizontalBarChart barChart = (HorizontalBarChart) myView.findViewById(R.id.chart1);


        ArrayList<BarEntry> barEntries = new ArrayList<>();

        barEntries.add(new BarEntry(1, 240f));
        barEntries.add(new BarEntry(2, 88f));
        barEntries.add(new BarEntry(3, 150f));
        barEntries.add(new BarEntry(4, 55f));
        barEntries.add(new BarEntry(5, 340f));
        barEntries.add(new BarEntry(6, 200f));
        barEntries.add(new BarEntry(7, 40f));


        BarDataSet barDataSet = new BarDataSet(barEntries, "Categories");

        BarData data = new BarData(barDataSet);
        data.setBarWidth(0.9f);

        barChart.setData(data);
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barChart.animateXY(3000,3000);
        barDataSet.setValueTextSize(15f);

//        String[] categories = new String[]{"School Expenses", "Transport", "Health", "Entertainment", "Clothing", "Food", "Miscellaneous"};
//        XAxis xAxis = barChart.getXAxis();
////        xAxis.setValueFormatter(new MyXAxisValueFormatter(categories));
//        xAxis.setPosition(XAxis.XAxisPosition.BOTH_SIDED);
//        xAxis.setGranularity(1);
//        xAxis.setCenterAxisLabels(true);
//        xAxis.setAxisMinimum(1);
    }

//    public class MyXAxisValueFormatter implements IAxisValueFormatter {
//
//        private String[] mValues;
//
//        public MyXAxisValueFormatter(String[] values) {
//            this.mValues = values;
//
//        }
//
//        @Override
//        public String getFormattedValue(float value, AxisBase axis) {
//            return mValues[(int) value];
//        }
//    }
}