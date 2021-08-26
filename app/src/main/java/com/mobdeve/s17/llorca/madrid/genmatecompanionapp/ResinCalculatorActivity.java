package com.mobdeve.s17.llorca.madrid.genmatecompanionapp;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.mobdeve.s17.llorca.madrid.genmatecompanionapp.databinding.ActivityDailyFarmablesBinding;
import com.mobdeve.s17.llorca.madrid.genmatecompanionapp.databinding.ActivityResinCalculatorBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ResinCalculatorActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivityResinCalculatorBinding ARCbinding;
    private ResinTimeAdapter resinTimeAdapter;
    private ArrayList<ResinTime> resinTimesList = new ArrayList<ResinTime>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resin_calculator);
        createNotificationChannel();
        ARCbinding = ActivityResinCalculatorBinding.inflate(getLayoutInflater());
        View mainView = ARCbinding.getRoot();
        setContentView(mainView);

        ARCbinding.acbCalculateResinTimes.setOnClickListener(this);
        resinTimeAdapter = new ResinTimeAdapter(getApplicationContext(), resinTimesList);
        ARCbinding.rvForResinTimes.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        ARCbinding.rvForResinTimes.setAdapter(resinTimeAdapter);
    }

    private void calculateResinTimes(){
        resinTimesList = new ArrayList<ResinTime>();
        String curAmountResin = ARCbinding.etCurResinInput.getText().toString();

        if (curAmountResin.matches("") || Integer.parseInt(curAmountResin) < 0 || Integer.parseInt(curAmountResin)>=160) {
            Toast.makeText(this, "You did not enter a valid resin Amount", Toast.LENGTH_LONG).show();
            resinTimeAdapter = new ResinTimeAdapter(getApplicationContext(), resinTimesList);
            ARCbinding.rvForResinTimes.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            ARCbinding.rvForResinTimes.setAdapter(resinTimeAdapter);
            return;
        }

        int parsedCurAmountResin = Integer.parseInt(ARCbinding.etCurResinInput.getText().toString());
        int minuteCounter = 0;

        Calendar currentTimeNow = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm a", Locale.getDefault());

        for (int i = parsedCurAmountResin; i <=160; i++){
            if (i % 20 == 0 && i != 0 && i != parsedCurAmountResin){
                resinTimesList.add(new ResinTime(sdf.format(currentTimeNow.getTime()), i, minuteCounter));

                resinTimeAdapter = new ResinTimeAdapter(getApplicationContext(), resinTimesList);
                ARCbinding.rvForResinTimes.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                ARCbinding.rvForResinTimes.setAdapter(resinTimeAdapter);
            }
            currentTimeNow.add(Calendar.MINUTE, 8);
            minuteCounter += 8;
        }

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.acbCalculateResinTimes) {
            calculateResinTimes();
        }
    }

    private void createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "GenMateReminderChannel";
            String description = "Channel for GenMate Reminder";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel ("notifyUserResin", name, importance);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }



}
