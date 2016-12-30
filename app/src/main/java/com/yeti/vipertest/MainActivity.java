package com.yeti.vipertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yeti.vipertest.Interactor.PictureInteractor;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onResume(){
        super.onResume();

        // Pass any number of strings as parameters, to be turned into an array in the Interactor
        new PictureInteractor().execute("GET");

        new PictureInteractor().execute("POST");
    }
}
