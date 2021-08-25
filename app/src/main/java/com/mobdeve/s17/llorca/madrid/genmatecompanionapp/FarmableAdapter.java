package com.mobdeve.s17.llorca.madrid.genmatecompanionapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FarmableAdapter extends RecyclerView.Adapter<FarmableAdapter.FarmableViewHolder> {

    private ArrayList<Farmable> farmableArrayList;
    private Context context;

    public FarmableAdapter(Context context, ArrayList<Farmable> farmableArrayList){
        this.farmableArrayList = farmableArrayList;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return farmableArrayList.size();
    }

    @Override
    public FarmableAdapter.FarmableViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_farmable, parent, false);

        FarmableViewHolder farmableViewHolder = new FarmableViewHolder(view);

        return farmableViewHolder;
    }

    @Override
    public void onBindViewHolder(FarmableAdapter.FarmableViewHolder holder, int position) {
        holder.tvFarmableItemName.setText(farmableArrayList.get(position).getItemname());
        holder.ivFarmableImage.setImageResource(farmableArrayList.get(position).getImageDrawableId());
    }

    protected class FarmableViewHolder extends RecyclerView.ViewHolder{
        ImageView ivFarmableImage;
        TextView tvFarmableItemName;

        public FarmableViewHolder(View view){
            super(view);
            ivFarmableImage = view.findViewById(R.id.ivFarmableImage);
            tvFarmableItemName = view.findViewById(R.id.tvFarmableItemName);
        }
    }
}
