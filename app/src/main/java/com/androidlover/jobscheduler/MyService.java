package com.androidlover.jobscheduler;

import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends JobService {
    public MyService() {
    }

    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        Toast.makeText(this,"JOB Started",Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        Toast.makeText(this,"JOB Stopped",Toast.LENGTH_SHORT).show();
        return false;
    }


}