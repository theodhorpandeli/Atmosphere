package com.example.theodhor.airchecker;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.theodhor.airchecker.Connection.BusProvider;
import com.example.theodhor.airchecker.Connection.Communicator;
import com.example.theodhor.airchecker.Connection.ResponseEvent;
import com.example.theodhor.airchecker.Models.Value;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.FillFormatter;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

public class TemperatureActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private ArrayList<Entry> entries;
    private LineDataSet dataset;
    private ArrayList<String> labels;
    private LineChart lineChart;
    private LineData data;
    private ArrayList<Value> valuesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        entries = new ArrayList<>();
        dataset = new LineDataSet(entries, "# of Calls");
        labels = new ArrayList<String>();
        lineChart = (LineChart)findViewById(R.id.temperatureLineChart);
        dataset.setColors(ColorTemplate.JOYFUL_COLORS);
        dataset.setDrawCircles(true);
        dataset.setDrawCubic(true);
        dataset.setDrawStepped(false);
        dataset.setFillColor(Color.BLUE);
        dataset.setLabel("Temperatura");
        dataset.setFillFormatter(new FillFormatter() {
            @Override
            public float getFillLinePosition(ILineDataSet iLineDataSet, LineDataProvider lineDataProvider) {
                return 0;
            }
        });
        dataset.setLineWidth(3f);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            lineChart.setNestedScrollingEnabled(true);
        }
        lineChart.setGridBackgroundColor(Color.BLUE);
        lineChart.setPinchZoom(true);
        lineChart.animateX(5000);
        new Communicator().getData();
    }

    @Override
    protected void onPause() {
        super.onPause();
        BusProvider.getInstance().unregister(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        BusProvider.getInstance().register(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.search_menu) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Subscribe
    public void onResponseEvent(ResponseEvent responseEvent){
        String[] string;
        String date;
        Log.e("This", "" + responseEvent.getDataList().getTemperatureData().getValues().size());
        valuesList = new ArrayList<>();
        valuesList.addAll(responseEvent.getDataList().getNoiseData().getValues());
        for(int i = 0;i<valuesList.size();i++){
            entries.add(new Entry(valuesList.get(i).getValue(),i));
            string = valuesList.get(i).getTime().split(" ");
            date = string[0];
            labels.add(date);
        }
        data = new LineData(labels, dataset);
        lineChart.setData(data);
        lineChart.setDescription(responseEvent.getDataList().getNoiseData().getUnit());
    }
}