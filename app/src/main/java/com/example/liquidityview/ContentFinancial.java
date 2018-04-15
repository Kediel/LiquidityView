package com.example.liquidityview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by QuanPhan on 4/15/18.
 */

public class ContentFinancial extends AppCompatActivity{

    private TextView mTransactionsTextView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_financial_breakdown);

        mTransactionsTextView = (TextView) findViewById(R.id.transaction_view);

        String[] transactions = {

                "Chicken:         $18",
                "Movie Tickets:   $5",
                "H&M T-Shirt:     $25",
                "Beef:            $10",
                "Flight Tickets:  $18",
                "Taxi:             $8",
                "Stove:           $80",

        };

        for (String transaction: transactions) {
            mTransactionsTextView.append(transaction + "\n\n");
        }
    }
}
