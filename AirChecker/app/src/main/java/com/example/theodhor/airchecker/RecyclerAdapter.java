package com.example.theodhor.airchecker;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.theodhor.airchecker.Models.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dori on 4/16/2016.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.CategoryViewHolder>{

    List<Parameter> parameters = new ArrayList<>();

    public RecyclerAdapter(List<Parameter> categories){
        this.parameters = categories;
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView parameterName, parameterValue, parameterUnit;
        RelativeLayout parameterLayout;
        Integer sensorId;
        Data data;
        float limit;
        public Context context;

        CategoryViewHolder(final View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cardView);
            cv.setRadius(20);
            cv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), GraphActivity.class);
                    intent.putExtra("data", data);
                    intent.putExtra("sensor_id", sensorId);
                    itemView.getContext().startActivity(intent);
                }
            });
            parameterName = (TextView)itemView.findViewById(R.id.parameterName);
            parameterValue = (TextView)itemView.findViewById(R.id.parameterValue);
            parameterUnit = (TextView)itemView.findViewById(R.id.parameterUnit);
            parameterLayout = (RelativeLayout)itemView.findViewById(R.id.parameterLayout);
        }
    }

    @Override
    public int getItemCount() {
        return parameters.size();
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder categoryViewHolder, int i) {
        categoryViewHolder.parameterName.setText(parameters.get(i).parameterName);
        categoryViewHolder.parameterValue.setText(parameters.get(i).parameterValue);
        categoryViewHolder.parameterUnit.setText(parameters.get(i).parameterUnit);
        categoryViewHolder.data = parameters.get(i).data;
        categoryViewHolder.sensorId = parameters.get(i).sensorId;
        categoryViewHolder.parameterLayout.setBackgroundColor(Color.BLUE);
        chooseColor(categoryViewHolder.parameterLayout,parameters.get(i).limit,Float.parseFloat(parameters.get(i).parameterValue));
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.parameter_item, viewGroup, false);
        CategoryViewHolder cvh = new CategoryViewHolder(v);
        return cvh;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    private void chooseColor(RelativeLayout linearLayout, float limit, float current){
        float col = current/limit;
        if(col <= 0.8){
            //excellent
            linearLayout.setBackgroundColor(Color.parseColor("#6400E301"));
        }else if(col > 0.8 && col < 1.0){
            linearLayout.setBackgroundColor(Color.parseColor("#fd7e01"));
        }else if(col > 1.0){
            linearLayout.setBackgroundColor(Color.parseColor("#fd0001"));
        }
    }
}