package com.example.di;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class BatteryModule {
    @Binds
    abstract Battery  provideBattery(LithiumBattery battery);

}
