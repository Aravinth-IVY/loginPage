package com.example.loginpage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

public class RemainderFragment extends Fragment {

    public RecyclerView recyclerview;
    public RecyclerView.Adapter Adapter;
    public RecyclerView.LayoutManager layoutManager;
    public String[] remindName ={"remainder1","remainder2","remainder3","remainder4","remainder5"};
    public String[] remindDate ={"date1","date2","date3","date4","date5"};
    public String[] remindTime ={"time1","time2","time3","time4","time5"};
    public View listitemsview;

    public RemainderFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // UserDetails userDetails = (UserDetails)getIntent().getParcelableExtra("user");



        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        listitemsview=inflater.inflate(R.layout.fragment_remainder,container,false);
        recyclerview=listitemsview.findViewById(R.id.tvrecyclerview);

        layoutManager=new LinearLayoutManager(getContext());
        recyclerview.setLayoutManager(layoutManager);
        String strJson = "{\"reminders\": [{\"name\": \"Reminder 1\",\"date\": \"01/09/2021\",\"time\": \"12:00 PM\"},{\"name\": \"Reminder 2\",\"date\": \"07/09/2021\",\"time\": \"12:00 PM\"},{\"name\": \"Reminder 3\",\"date\": \"14/09/2021\",\"time\": \"12:00 PM\"}],\"userActive\": true,\"userName\": \"Roger Kent\",\"userId\": 123,\"credentials\": {\"email\": \"abc@gmail.com\",\"authenticationType\": 1},\"userRole\": \"Admin\"}";
        Gson gson = new Gson();
        UserDetails userDetails = gson.fromJson(strJson, UserDetails.class);
        if (userDetails != null) {

            if (userDetails.getReminders().size() > 0){
                Adapter= new Adapter(userDetails.getReminders());
                recyclerview.setAdapter(Adapter);
                //Toast.makeText(this, Toast.LENGTH_SHORT, "Remainders list is not empty").show();
            }
            //Toast.makeText(this,userDetails.getUserName(), Toast.LENGTH_SHORT).show();
        }


        return listitemsview;
    }
}