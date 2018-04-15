package com.example.liquidityview;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.nsd.NsdManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class SignUpActivity extends AppCompatActivity {
    private EditText txtEmailAddress;
    private EditText txtPassword;
    private EditText txtName;
    private FirebaseAuth firebaseAuth;
    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mUserIdRef = mRootRef.child("userId");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        txtEmailAddress = findViewById(R.id.txtEmailRegistration);
        txtPassword =  findViewById(R.id.txtPasswordRegistration);
        txtName = findViewById(R.id.txtNameRegistration);
        firebaseAuth = FirebaseAuth.getInstance();
    }
    public void btnRegisterUser_Click(View v){
        if (txtEmailAddress.getText().toString().isEmpty()) {
            Toast.makeText(SignUpActivity.this, "Please Enter Your Email", Toast.LENGTH_LONG).show();
            return;
        }
        else if (txtPassword.getText().toString().isEmpty()) {
            Toast.makeText(SignUpActivity.this, "Please Enter Your Password", Toast.LENGTH_LONG).show();
            return;
        }
        else if (txtName.getText().toString().isEmpty()) {
            Toast.makeText(SignUpActivity.this, "Please Enter Your Name", Toast.LENGTH_LONG).show();
            return;
        }
        (firebaseAuth.createUserWithEmailAndPassword(txtEmailAddress.getText().toString(), txtPassword.getText().toString()))
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    Toast.makeText(SignUpActivity.this, "Registration successful", Toast.LENGTH_LONG).show();
                    FirebaseDatabase database = FirebaseDatabase.getInstance();

                    initializeData();

                    Intent i = new Intent(SignUpActivity.this, LoginScreen.class);
                    startActivity(i);
                }
                else{
                    Log.e("ERROR: ", task.getException().toString());
                    Toast.makeText(SignUpActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void initializeData() {
        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        //Set id

        DatabaseReference mIdRef = mUserIdRef.child(currentFirebaseUser.getUid());
        DatabaseReference mBudgetRef = mIdRef.child("weeklybudget");
        DatabaseReference mSaveRef = mIdRef.child("weeklysavings");
        DatabaseReference mBillDueRef = mIdRef.child("billdue");
        DatabaseReference mNameRef = mIdRef.child("name");
        mNameRef.setValue(txtName.getText().toString());
        mBudgetRef.setValue(20);
        mSaveRef.setValue(100);
        mBillDueRef.setValue("PLACE HOLDER");

    }
}
