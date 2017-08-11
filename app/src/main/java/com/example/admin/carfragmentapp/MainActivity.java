package com.example.admin.carfragmentapp;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AddNewCarFragment newCar = new AddNewCarFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.flFrame1, newCar, "MainActivity").commit();

        CarRecyclerViewFragment carList = new CarRecyclerViewFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.flFrame2, carList, "MainActivity").commit();
    }

    public void changeLayout(View view){
        Log.d("MainActivity", "From Main");
        CarRecyclerViewFragment fragment = (CarRecyclerViewFragment) getSupportFragmentManager().findFragmentById(R.id.flFrame2);
        fragment.changeLayout(view);
    }

}
