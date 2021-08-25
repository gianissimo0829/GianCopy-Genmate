package com.mobdeve.s17.llorca.madrid.genmatecompanionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mobdeve.s17.llorca.madrid.genmatecompanionapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivityMainBinding AMbinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AMbinding = ActivityMainBinding.inflate(getLayoutInflater());
        View mainView = AMbinding.getRoot();
        setContentView(mainView);

        AMbinding.acbDailyFarmables.setOnClickListener(this);
        AMbinding.acbResinCalculator.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.acbDailyFarmables:
                Intent gotoDailyFarmables = new Intent(MainActivity.this, DailyFarmablesActivity.class);
                startActivity(gotoDailyFarmables);
//                finish();
                break;
            case R.id.acbResinCalculator:
                Intent gotoResinCalculator = new Intent(MainActivity.this, ResinCalculatorActivity.class);
                startActivity(gotoResinCalculator);
//                finish();
                break;
        }
    }

}