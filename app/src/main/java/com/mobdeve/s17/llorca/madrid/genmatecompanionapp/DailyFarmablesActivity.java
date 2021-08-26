package com.mobdeve.s17.llorca.madrid.genmatecompanionapp;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.mobdeve.s17.llorca.madrid.genmatecompanionapp.databinding.ActivityDailyFarmablesBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DailyFarmablesActivity extends AppCompatActivity {

    private ActivityDailyFarmablesBinding ADFbinding;
    private ArrayList<Farmable> farmablesList;
    private FarmableAdapter farmableAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_farmables);
        ADFbinding = ActivityDailyFarmablesBinding.inflate(getLayoutInflater());
        View mainView = ADFbinding.getRoot();
        setContentView(mainView);

        generateFarmables();
        farmableAdapter = new FarmableAdapter(getApplicationContext(), farmablesList);
        ADFbinding.rvForFarmables.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        ADFbinding.rvForFarmables.setAdapter(farmableAdapter);
    }

    private void generateFarmables(){
        farmablesList = new ArrayList<Farmable>();

        ArrayList<String> DaysAvailable = new ArrayList<>();

        Date currentDateAndTime= Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE", Locale.getDefault());
        String formattedDate = sdf.format(currentDateAndTime);

        if (formattedDate.equals("Monday") || formattedDate.equals("Thursday")){
            DaysAvailable.add("Monday");
            DaysAvailable.add("Thursday");
            farmablesList.add(new Farmable("Freedom", R.drawable.teachings_of_freedom, DaysAvailable));
            farmablesList.add(new Farmable("Prosperity", R.drawable.teachings_of_prosperity, DaysAvailable));
            farmablesList.add(new Farmable("Transcience", R.drawable.teachings_of_transience, DaysAvailable));
            farmablesList.add(new Farmable("Decarabian", R.drawable.tile_of_decarabians_tower, DaysAvailable));
            farmablesList.add(new Farmable("Guyun", R.drawable.luminous_sands_from_guyun, DaysAvailable));
            farmablesList.add(new Farmable("Distant Sea", R.drawable.coral_branch_of_a_distant_sea, DaysAvailable));
        }
        else if (formattedDate.equals("Tuesday") || formattedDate.equals("Friday")){
            DaysAvailable.add("Tuesday");
            DaysAvailable.add("Friday");
            farmablesList.add(new Farmable("Resistance", R.drawable.teachings_of_resistance, DaysAvailable));
            farmablesList.add(new Farmable("Diligence", R.drawable.teachings_of_diligence, DaysAvailable));
            farmablesList.add(new Farmable("Elegance", R.drawable.teachings_of_elegance, DaysAvailable));
            farmablesList.add(new Farmable("Boreal Wolf", R.drawable.boreal_wolfs_milk_tooth, DaysAvailable));
            farmablesList.add(new Farmable("Mist Veiled Elixir", R.drawable.mist_veiled_lead_elixir, DaysAvailable));
            farmablesList.add(new Farmable("Narukami", R.drawable.narukamis_wisdom, DaysAvailable));
        }
        else if(formattedDate.equals("Wednesday") || formattedDate.equals("Saturday")) {
            DaysAvailable.add("Wednesday");
            DaysAvailable.add("Saturday");
            farmablesList.add(new Farmable("Ballad", R.drawable.teachings_of_ballad, DaysAvailable));
            farmablesList.add(new Farmable("Gold", R.drawable.teachings_of_gold, DaysAvailable));
            farmablesList.add(new Farmable("Light", R.drawable.teachings_of_light, DaysAvailable));
            farmablesList.add(new Farmable("Dandelion Gladiator", R.drawable.fetters_of_the_dandelion_gladiator, DaysAvailable));
            farmablesList.add(new Farmable("Aerosiderite", R.drawable.grain_of_aerosiderite, DaysAvailable));
            farmablesList.add(new Farmable("Mask", R.drawable.mask_of_the_wicked_lieutenant, DaysAvailable));
        }
    }
}
