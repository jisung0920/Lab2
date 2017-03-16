package com.example.park.myapplication;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class ResActivity extends AppCompatActivity {
    Switch s1 ;
    TextView t1, t2;
    Chronometer c1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res);
        init();
        s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked) {
                    c1.start();
                    t1.setVisibility(View.VISIBLE);
                    c1.setVisibility(View.VISIBLE);
                }
                else{
                    c1.setBase(SystemClock.elapsedRealtime());
                    t1.setVisibility(View.INVISIBLE);
                    c1.setVisibility(View.INVISIBLE);

                }
            }
        });
    }
    public void ResOnClick(View v) {


    }
    void init() {
        s1 = (Switch) findViewById(R.id.switch1);
        t1 = (TextView) findViewById(R.id.time);
        c1 = (Chronometer)findViewById(R.id.chronometer1);
    }
}
