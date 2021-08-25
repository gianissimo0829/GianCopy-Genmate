package com.mobdeve.s17.llorca.madrid.genmatecompanionapp;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.mobdeve.s17.llorca.madrid.genmatecompanionapp.databinding.ActivityDailyFarmablesBinding;
import com.mobdeve.s17.llorca.madrid.genmatecompanionapp.databinding.ActivityResinCalculatorBinding;

public class ResinCalculatorActivity extends AppCompatActivity {

    private ActivityResinCalculatorBinding ARCbinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resin_calculator);
        ARCbinding = ActivityResinCalculatorBinding.inflate(getLayoutInflater());
        View mainView = ARCbinding.getRoot();
        setContentView(mainView);
    }






}
