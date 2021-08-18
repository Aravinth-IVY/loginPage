package com.example.dashboard;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.loginpage.R;

public class DashboardFragment extends Fragment implements View.OnClickListener {

    public FrameLayout home;
    public FrameLayout todayTask;
    public FrameLayout pendingTask;
    public FrameLayout searchTeam;
    public FrameLayout logout;
    public OnDashboardFragmentListener mCallback;

    public DashboardFragment() {
        // Required empty public constructor
    }
    public interface OnDashboardFragmentListener {
        void messageFromDashboardFragment(String message);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        home=(FrameLayout) view.findViewById(R.id.flhome);
        todayTask=(FrameLayout) view.findViewById(R.id.fltodaystask);
        pendingTask=(FrameLayout) view.findViewById(R.id.flpendingtask);
        searchTeam=(FrameLayout) view.findViewById(R.id.flsearchteam);
        logout=(FrameLayout) view.findViewById(R.id.fllogout);

        home.setOnClickListener(this);
        todayTask.setOnClickListener(this);
        pendingTask.setOnClickListener(this);
        searchTeam.setOnClickListener(this);
    }

    public void onClick(View v) {
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    String message = "this is home";
                    mCallback.messageFromDashboardFragment(message);
                /*getActivity().getSupportFragmentManager().beginTransaction()
                        .remove(currentFragment)
                        .commit();
                currentFragment = new HomeFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(fragment_container_view1, currentFragment)
                        .commit();*/
            }

        });


        todayTask.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String message = "this is Today Task";
                mCallback.messageFromDashboardFragment(message);
                /*getActivity().getSupportFragmentManager().beginTransaction()
                        .remove(currentFragment)
                        .commit();
                currentFragment = new TodaysTaskFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(fragment_container_view1, currentFragment)
                        .commit();*/
            }
        });

        pendingTask.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String message = "Pending Task";
                mCallback.messageFromDashboardFragment(message);
                /*getActivity().getSupportFragmentManager().beginTransaction()
                        .remove(currentFragment)
                        .commit();
                currentFragment = new PendingTaskFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(fragment_container_view1, currentFragment)
                        .commit();*/
            }
        });

        searchTeam.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String message = "this is Search Team";
                mCallback.messageFromDashboardFragment(message);
                /*getActivity().getSupportFragmentManager().beginTransaction()
                        .remove(currentFragment)
                        .commit();
                currentFragment = new SearchTeamFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(fragment_container_view1, currentFragment)
                        .commit();*/
            }
        });

    }
    public void onAttack(Context context) {
        super.onAttach(context);
       // if (context instanceof OnDashboardFragmentListener) {
            mCallback = (OnDashboardFragmentListener) context;
        //} else {
          //  throw new RuntimeException(context.toString()
            //        + " must implement OnDashboardFragmentListener");
      //  }
    }
   /* @Override
    public void onDetach() {
        super.onDetach();
        mCallback = null;
    }*/
}