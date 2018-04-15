package com.example.liquidityview;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference myRef;
    private String userID;
    public static float animal;
    public float b;
    
    public float weeklySavings = 100;
    public float weeklyBudget = 0;
    // private ListView mListView;
    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
    String Categories[] = { "Weekly Savings", "Weekly Budget", "Miscellaneous", "Transportation", "Shopping", "Entertainment"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //mListView = findViewById(R.id.listview);
        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();
        FirebaseUser user = mAuth.getCurrentUser();
        userID = user.getUid();
        //mRef = new Firebase("https://liquidityview.firebaseio.com/userId");
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null){
                    toastMessage("Successfully signed in with" + user.getEmail());
                }else{
                    toastMessage("Successfully signed out.");
                }
            }
        };

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("server/path/to/userid");
//
//        ref.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                UserPro profile = dataSnapshot.getValue(userid.class);
//                System.out.println(profile.getUserId());
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//               System.out.println("System Failed");
//            }
//        });

        setupPieChart();
    }
    float Expenses[] = {weeklyBudget,weeklySavings, 106.3f, 67.25f, 12, 59.8f };



    //
//    public void showData(DataSnapshot dataSnapshot) {
//
//        for(DataSnapshot ds : dataSnapshot.getChildren()) {
//            UserInformation uInfo = new UserInformation();
//            uInfo.setBilldue(ds.child(userID).getValue(UserInformation.class).getBilldue());
//            uInfo.setName(ds.child(userID).getValue(UserInformation.class).getName());
//            uInfo.setWeeklybudget(ds.child(userID).getValue(UserInformation.class).getWeeklybudget());
//            uInfo.setWeeklysavings(ds.child(userID).getValue(UserInformation.class).getWeeklysavings());
//
//
//            System.out.println("Animal:" + animal);
//
//        }
//    }

    @Override
    public void onStart() {
        super.onStart();;
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if(mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    public void viewBreakdown(View view) {
        Intent intent = new Intent(this, FinancialBreakdown.class);
        startActivity(intent);
    }

    public void viewTips(View view) {
        Intent intent = new Intent(this, TipsandStats.class);
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

    // Function that will calculate based on the interest specified in the FinancialCalculations.java class.
    private void makeCalculations() {

        // Import methods from the FinancialCalculations class.
        FinancialCalculations fCalculations = new FinancialCalculations();
        double loan2 = fCalculations.Loans();
        double debt2 = fCalculations.Debt();
        double tax2 = fCalculations.Taxes();
        double interest2 = fCalculations.Interest();

        // Replace input 0-3 with name of input boxes on the financial_breakdown.xml file.
        //double principal = Double.valueOf(input0.getText().toString());
        //double loan = Double.valueOf(input1.getText().toString());
        //double debt = Double.valueOf(input2.getText().toString());
        //double tax = Double.valueOf(input3.getText().toString());

        // Calculate
        //double result = principal * FinancialCalculations.sLoan;

        //iCalc_result.setText("The result is: " + result);
    }


}
