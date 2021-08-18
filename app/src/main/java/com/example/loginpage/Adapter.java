package com.example.loginpage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.AppViewHolder> {

    List<Reminders> reminders;

    public LayoutInflater layoutInflater;

   /*Adapter(String[] _data, String[] remindDate, String[] remindTime){
        rName = _data;
        rDate = remindDate;
        rTime = remindTime;
    }*/

    public Adapter(List<Reminders> reminders) {
        this.reminders = reminders;
    }

    @NonNull
    @Override
    public AppViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        layoutInflater=LayoutInflater.from(parent.getContext());
        View view =layoutInflater.inflate(R.layout.list_item_remainders,parent,false);

        return new AppViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AppViewHolder holder, int position) {

        /*String reminderName = rName[position];
        String reminderDate = rDate[position];
        String reminderTime = rTime[position];
        holder.reminderName.setText(reminderName);
        holder.reminderDate.setText(reminderDate);
        holder.reminderTime.setText(reminderTime);*/

        Reminders remindlist = reminders.get(position);
        String reminderName =remindlist.getName();
        String reminderDate =remindlist.getDate();
        String reminderTime =remindlist.getTime();

        holder.reminderName.setText(reminderName);
        holder.reminderDate.setText(reminderDate);
        holder.reminderTime.setText(reminderTime);
    }

    @Override
    public int getItemCount() {
        return reminders.size();
    }

    public static class AppViewHolder extends RecyclerView.ViewHolder{

        TextView reminderName;
        TextView reminderDate;
        TextView reminderTime;
        public AppViewHolder(@NonNull View itemview) {
            super(itemview);
            reminderName = itemview.findViewById(R.id.tvRemaindername);
            reminderDate = itemview.findViewById(R.id.tvRemaindedate);
            reminderTime = itemview.findViewById(R.id.tvRemaindertime);
        }
    }

    public class remindlist {
    }
}
