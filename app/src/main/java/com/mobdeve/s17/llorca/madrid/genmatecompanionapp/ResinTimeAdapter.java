package com.mobdeve.s17.llorca.madrid.genmatecompanionapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ResinTimeAdapter extends RecyclerView.Adapter<ResinTimeAdapter.ResinTimeViewHolder> {

    private ArrayList<ResinTime> resinTimesArrayList;
    private Context context;

    public ResinTimeAdapter(Context context, ArrayList<ResinTime> resinTimesArrayList){
        this.resinTimesArrayList = resinTimesArrayList;
        this.context = context;
    }

    @Override
    public ResinTimeAdapter.ResinTimeViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_resin_entry, parent, false);

        ResinTimeViewHolder resinTimeViewHolder = new ResinTimeViewHolder(view);

        return resinTimeViewHolder;
    }

    @Override
    public void onBindViewHolder(ResinTimeAdapter.ResinTimeViewHolder holder, int position) {
        holder.tvTimeToGetResinAmount.setText(resinTimesArrayList.get(position).getTimeToGetResinAmount());
        holder.tvResinAmount.setText(Integer.toString(resinTimesArrayList.get(position).getFutureResinAmount()));
        holder.acbResinReminder.setOnClickListener( v -> {
                    Toast.makeText(context, "Reminder Set", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(context, ReminderBroadcast.class);
                    PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);

                    AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

                    long timeAtButtonClick = System.currentTimeMillis();

                    long durationOfGoalResinInMillis = 1000 * 60 * resinTimesArrayList.get(position).getMinsTilResinAmount();

                    alarmManager.set(AlarmManager.RTC_WAKEUP, timeAtButtonClick + durationOfGoalResinInMillis, pendingIntent);
                }
        );
    }

    protected class ResinTimeViewHolder extends RecyclerView.ViewHolder{

        TextView tvTimeToGetResinAmount;
        TextView tvResinAmount;

        AppCompatButton acbResinReminder;

        public ResinTimeViewHolder(View view){
            super(view);
            tvTimeToGetResinAmount = view.findViewById(R.id.tvTimeToGetResinAmount);
            tvResinAmount = view.findViewById(R.id.tvResinAmount);
            acbResinReminder = view.findViewById(R.id.acbResinReminder);
        }

    }
    @Override
    public int getItemCount() {
        return resinTimesArrayList.size();
    }
}
