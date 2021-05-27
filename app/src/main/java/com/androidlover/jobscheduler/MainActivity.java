package com.androidlover.jobscheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    ToggleButton tb;
    JobScheduler MyJob;
    JobInfo MyJobInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tb=(ToggleButton)findViewById(R.id.toggleButton);

        tb.setOnCheckedChangeListener(this);

        MyJob = (JobScheduler)getSystemService(JOB_SCHEDULER_SERVICE);

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(b)
        {
           JobInfo.Builder JobBuilder = new JobInfo.Builder(1, new ComponentName(getPackageName(),MyService.class.getName()))
           .setRequiresCharging(true)
           .setRequiredNetworkType(MyJobInfo.NETWORK_TYPE_ANY)
           .setRequiresDeviceIdle(false);

           MyJobInfo = JobBuilder.build();
           MyJob.schedule(MyJobInfo);

        }
    }
}