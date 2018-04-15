package com.example.liquidityview;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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
    private EditText Income;
    private EditText Loan1;
    private EditText Loan2;

    
    public float weeklySavings = 100;
    public float weeklyBudget = 0;
    // private ListView mListView;
    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

//    String Categories[] = {"Food", "Travel", "Miscellaneous", "Transportation", "Shopping", "Entertainment"};
    String Categories[] = { "Weekly Savings", "Weekly Budget", "Miscellaneous", "Transportation", "Shopping", "Entertainment"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Income = (EditText) findViewById(R.id.Income);
        Loan1 = (EditText) findViewById(R.id.Loan1);
        Income = (EditText) findViewById(R.id.Loan2);
        Button calc = (Button) findViewById(R.id.calculate);
        // mListView = findViewById(R.id.listview);
        //mListView = findViewById(R.id.listview);
        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();
        FirebaseUser user = mAuth.getCurrentUser();
        userID = user.getUid();

//        mRef = new Firebase("https://liquidityview.firebaseio.com/userId");
        //mRef = new Firebase("https://liquidityview.firebaseio.com/userId");
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    toastMessage("Successfully signed in with" + user.getEmail());
                } else {
                    toastMessage("Successfully signed out.");
                }
            }
        };

       /* public static class UserID {

        }

    }

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("server/path/to/userid")

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Userid profile = dataSnapshot.getValue(userid.class);
                System.out.println(profile.getUserId());
            }

            @Override
          public void onCancelled(DatabaseError databaseError) {
               System.out.println("System Failed");
          }
        });
*/
        setupPieChart();
    }

    float Expenses[] = {weeklyBudget, weeklySavings, 106.3f, 67.25f, 12, 59.8f};


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
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    // Goes to the Manual Entry page once the "Manual Entry" button is clicked.
    public void manualClick(View v){
        Intent i = new Intent(MainActivity.this, ManualActivity.class);
        startActivity(i);
    }

    // Goes to the Financial Breakdown page once the "View Breakdown" button is clicked.
    public void viewBreakdown(View view) {
        Intent intent = new Intent(this, FinancialBreakdown.class);
        startActivity(intent);
    }

    // Goes to the Tips and Pointers page once the "Tips/Stats" button is clicked.
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
    public class Calc {



        private void make() {

            // Import methods from the FinancialCalculations class.
        /*FinancialCalculations fCalculations = new FinancialCalculations();
            double principle = 3000;
            double loan3 = fCalculations.Loans();
            double debt2 = fCalculations.Debt();
            double tax2 = fCalculations.Taxes();
            double interest2 = fCalculations.Interest();

            double result = principle - loan3;
            System.out.println(result);*/


            // Replace input 0-3 with name of input boxes on the financial_breakdown.xml file.

            double principle = Double.valueOf(Income.getText().toString());
            double loan1 = Double.valueOf(Loan1.getText().toString());
            double loan2 = Double.valueOf(Loan2.getText().toString());


        }
    }
}


