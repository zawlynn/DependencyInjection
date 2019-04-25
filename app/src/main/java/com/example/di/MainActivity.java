package com.example.di;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject
    SmartPhone smartPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DIApplicaiton.getApplicaiton().getComponent().inject(this);
        smartPhone.makeACall();

    }
    public void openNewActivity(View view){
        Intent i=new Intent(this,Main2Activity.class);
        startActivity(i);
    }
}
