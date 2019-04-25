package com.example.di;


import android.util.Log;
import dagger.Module;
import dagger.Provides;

@Module
public class MemoryModule {
    private int memory_size;
    private static final String TAG = "SmartPhone";
    public MemoryModule(int memory_size) {
        this.memory_size = memory_size;
    }

    @Provides
    MemoryCard provideMemory(){
        Log.d(TAG, "provideMemory: is " + memory_size);
        return  new MemoryCard();
    }
}
