package com.example.di;

import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {MemoryModule.class,BatteryModule.class})
public interface SmartPhoneComponent {
    void inject(MainActivity mainActivity);
}
