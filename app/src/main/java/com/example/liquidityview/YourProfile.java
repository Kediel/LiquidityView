package com.example.liquidityview;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by QuanPhan on 4/14/18.
 */

public class YourProfile extends Fragment implements View.OnClickListener {
    View myView;
    private CheckBox checkbox_camera,checkbox_gift;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        myView = inflater.inflate(R.layout.your_profile, container, false);

        return myView;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        checkbox_camera=myView.findViewById(R.id.checkbox_camera);
        checkbox_gift=myView.findViewById(R.id.checkbox_gift);
        checkbox_camera.setOnClickListener(this);
        checkbox_gift.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.checkbox_camera){
            if(checkbox_camera.isChecked()){
                Toast.makeText(getContext(), "Checkbox checked", Toast.LENGTH_SHORT).show();
            }
        }

        if(v.getId()==R.id.checkbox_gift){
            if (checkbox_gift.isChecked()) {
                Toast.makeText(getContext(),"Checkbox checked", Toast.LENGTH_SHORT).show();
            }
        }
    }
}







