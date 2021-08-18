package com.example.dashboard;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.loginpage.R;
import com.example.loginpage.RemainderFragment;

import static com.example.loginpage.R.id.fragment_container_view1;

public class DashboardActivity extends AppCompatActivity implements DashboardFragment.OnDashboardFragmentListener{

    public Fragment currentFragment;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        //currentFragment = (Fragment) findViewById(R.id.fragment_container_view1);

        // this is the initial fragment
        currentFragment = new RemainderFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(fragment_container_view1,
                        currentFragment)
                .commit();

        DashboardFragment dashboardFragment = new DashboardFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container_view,
                        dashboardFragment)
                .commit();
        //home.setOnClickListener(this);
        //todayTask.setOnClickListener(this);
        //pendingTask.setOnClickListener(this);
        //searchTeam.setOnClickListener(this);
    }
    @Override
    public void messageFromDashboardFragment(String message) {

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
