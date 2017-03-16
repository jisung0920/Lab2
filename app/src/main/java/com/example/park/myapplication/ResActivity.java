package com.example.park.myapplication;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
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
    int index = -1;
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
        setTitle("레스토랑 예약하기");

        init();

    }
    public void ResOnClick(View v) {

        if(v.getId() == R.id.next) {
            index++;
            change();
        }
        else if(v.getId() == R.id.prev) {
            index--;
            change();
        }
    }

    void init() {
        s1 = (Switch) findViewById(R.id.switch1);
        t1 = (TextView) findViewById(R.id.time);
        t2 = (TextView) findViewById(R.id.datetextView);
        t3 = (TextView) findViewById(R.id.timetextView);
        t4 = (TextView) findViewById(R.id.adulttextView);
        t5 = (TextView) findViewById(R.id.teentextView);
        t6 = (TextView) findViewById(R.id.babytextView);
      //  t7 = (TextView) findViewById(R.id.time);
        e1 = (EditText) findViewById(R.id.adult);
        e2 = (EditText) findViewById(R.id.teen);
        e3 = (EditText) findViewById(R.id.baby);
        datePicker = (DatePicker)findViewById(R.id.datePicker);
        timePicker = (TimePicker)findViewById(R.id.timePicker);
        g1 = (GridLayout)findViewById(R.id.grid1);
        g2 = (GridLayout)findViewById(R.id.grid2);
        c1 = (Chronometer)findViewById(R.id.chronometer1);
        b1 = (Button) findViewById(R.id.prev);
        b2 = (Button) findViewById(R.id.next);

        s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                c1.setBase(SystemClock.elapsedRealtime());
                if(isChecked) {
                    index++;
                    change();
                }
                else{
                    index = -1;
                    change();
                }
            }
        });

        datePicker.init(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                t2.setText(i+"년"+(i1+1)+"월"+i2+"일");
            }
        });
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {

                int hour = timePicker.getCurrentHour();
                int minute = timePicker.getCurrentMinute();
                t3.setText(hour+"시"+minute+"분");
            }
        });
    }
    void change() {
        if(index == -1) {
            t1.setVisibility(View.INVISIBLE);
            c1.setVisibility(View.INVISIBLE);
            b1.setVisibility(View.INVISIBLE);
            b2.setVisibility(View.INVISIBLE);
            datePicker.setVisibility(View.INVISIBLE);
            timePicker.setVisibility(View.INVISIBLE);
            g1.setVisibility(View.INVISIBLE);
            g2.setVisibility(View.INVISIBLE);
            b2.setEnabled(true);
            t2.setText("0000년00월00일");
            t3.setText("00시00분");
        }
        else if(index == 0) {
            c1.start();
            t1.setVisibility(View.VISIBLE);
            c1.setVisibility(View.VISIBLE);
            b1.setVisibility(View.VISIBLE);
            b2.setVisibility(View.VISIBLE);
            datePicker.setVisibility(View.VISIBLE);
            timePicker.setVisibility(View.INVISIBLE);
            g1.setVisibility(View.INVISIBLE);
            g2.setVisibility(View.INVISIBLE);
            b1.setEnabled(false);
        }
        else if(index == 1) {
            timePicker.setVisibility(View.VISIBLE);
            datePicker.setVisibility(View.INVISIBLE);
            g1.setVisibility(View.INVISIBLE);
            g2.setVisibility(View.INVISIBLE);
            b1.setEnabled(true);
        }
        else if(index == 2) {
            g1.setVisibility(View.VISIBLE);
            timePicker.setVisibility(View.INVISIBLE);
            datePicker.setVisibility(View.INVISIBLE);
            g2.setVisibility(View.INVISIBLE);
            b2.setEnabled(true);
        }
        else if(index == 3) {
            g2.setVisibility(View.VISIBLE);
            datePicker.setVisibility(View.INVISIBLE);
            g1.setVisibility(View.INVISIBLE);
            timePicker.setVisibility(View.INVISIBLE);
            b2.setEnabled(false);
        }
    }
}
