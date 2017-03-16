package com.example.park.myapplication;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

public class ResActivity extends AppCompatActivity {
    Switch s1 ;
    TextView t1, t2, t3, t4, t5, t6, t7;
    EditText e1, e2, e3;
    Button b1, b2;
    Chronometer c1;
    DatePicker datePicker;
    TimePicker timePicker;
    GridLayout g1, g2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res);
        init();

    }
    public void ResOnClick(View v) {


    }
    void init() {
        s1 = (Switch) findViewById(R.id.switch1);
        t1 = (TextView) findViewById(R.id.time);
        c1 = (Chronometer)findViewById(R.id.chronometer1);
        b1 = (Button) findViewById(R.id.prev);
        b2 = (Button) findViewById(R.id.next);

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
                    c1.stop();
                    t1.setVisibility(View.INVISIBLE);
                    c1.setVisibility(View.INVISIBLE);

                }
            }
        });
    }
}
