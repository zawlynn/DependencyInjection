package com.example.di;

import android.annotation.SuppressLint;
import android.util.Log;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Singleton
public class SmartPhone {

    private Battery battery;
    private MemoryCard memoryCard;
    private SIMCard simCard;
    private static final String TAG = "SmartPhone";
    private String time;

    @Inject
    public SmartPhone(Battery battery, MemoryCard memoryCard, SIMCard simCard) {
        this.battery = battery;
        this.memoryCard = memoryCard;
        this.simCard = simCard;
        battery.showType();
        SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        time=df.format(Calendar.getInstance().getTime());
    }
    public void makeACall(){
        Log.d(TAG, " making a call......... ");
        Log.d(TAG, "created time : "+time);
    }
}
