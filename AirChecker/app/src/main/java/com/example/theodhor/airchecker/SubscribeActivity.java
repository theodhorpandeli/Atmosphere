package com.example.theodhor.airchecker;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.ArrayList;

public class SubscribeActivity extends AppCompatActivity {

    private Spinner ageSpinner;
    private SpinnerAdapter spinnerAdapter;
    private ArrayList<String> agesList;
    private ProgressDialog progressDialog;
    //private

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscribe);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Merr njoftime");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ageSpinner = (Spinner)findViewById(R.id.ageGroup);
        agesList = new ArrayList<>();
        agesList.add("10 - 20");
        agesList.add("21 - 30");
        agesList.add("31 - 40");
        agesList.add("41 - 50");
        agesList.add("50+");

        spinnerAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,agesList);
        ageSpinner.setAdapter(spinnerAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if(fab!=null)
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog = ProgressDialog.show(SubscribeActivity.this,"","Duke u derguar...",true,true);
                subscribe();
            }
        });
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        finish();
    }

    private void subscribe(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                new AlertDialog.Builder(SubscribeActivity.this)
                        .setTitle("Sukses!")
                        .setMessage("Ju sapo u rregjistruat per te marre njoftime")
                        .setNegativeButton("Mbylle", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                progressDialog.dismiss();
                                finish();
                            }
                        })
                        .show();
            }
        },3000);
    }

}
