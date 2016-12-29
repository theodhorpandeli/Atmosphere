package com.example.theodhor.airchecker;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import com.example.theodhor.airchecker.Connection.BusProvider;
import com.example.theodhor.airchecker.Connection.ResponseEvent;
import com.example.theodhor.airchecker.Models.Data;
import com.example.theodhor.airchecker.Models.Value;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.FillFormatter;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

public class GraphActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private ArrayList<Entry> entries;
    private LineDataSet dataset;
    private ArrayList<String> labels;
    private LineChart lineChart;
    private LineData lineData;
    private ArrayList<Value> valuesList;
    private Data data;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle( this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        assert drawer != null;
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        assert navigationView != null;
        navigationView.setNavigationItemSelectedListener(this);
        Bundle extras = getIntent().getExtras();
        data = (Data)extras.get("data");
        Integer sensorId = extras.getInt("sensor_id");
        if(data != null){
            showData(data,sensorId);
        }else{
        }


    }

    private void showData(Data data, Integer sensorId){
        String[] string, date;
        String day;
        entries = new ArrayList<>();
        entries.clear();
        labels = new ArrayList<String>();
        lineChart = (LineChart)findViewById(R.id.lineChart);
        valuesList = new ArrayList<>();
        valuesList.clear();
        LimitLine limitLine = null;
        switch (sensorId){
            case 1:
                valuesList.addAll(data.getTemperatureData().getValues());
                lineChart.setDescription(data.getTemperatureData().getUnit());
                dataset = new LineDataSet(entries, data.getTemperatureData().getStationName());
                getSupportActionBar().setTitle(data.getTemperatureData().getStationName());
                break;
            case 2:
                valuesList.addAll(data.getRadiationData().getValues());
                lineChart.setDescription(data.getRadiationData().getUnit());
                dataset = new LineDataSet(entries, data.getRadiationData().getStationName());
                getSupportActionBar().setTitle(data.getRadiationData().getStationName());
                lineChart.setExtraTopOffset(data.getRadiationData().getLimitValue() + 2f);
                limitLine = new LimitLine(data.getRadiationData().getLimitValue(), "Limiti");
                Log.e("LimitLine",""+limitLine.getLimit());
                break;
            case 3:
                valuesList.addAll(data.getDustData().getValues());
                lineChart.setDescription(data.getDustData().getUnit());
                dataset = new LineDataSet(entries, data.getDustData().getStationName());
                getSupportActionBar().setTitle(data.getDustData().getStationName());
                limitLine = new LimitLine(data.getDustData().getLimitValue(), "Limiti");
                Log.e("LimitLine",""+limitLine.getLimit());
                break;
            case 4:
                valuesList.addAll(data.getNoiseData().getValues());
                lineChart.setDescription(data.getNoiseData().getUnit());
                dataset = new LineDataSet(entries, data.getNoiseData().getStationName());
                getSupportActionBar().setTitle(data.getNoiseData().getStationName());
                limitLine = new LimitLine(data.getNoiseData().getLimitValue(), "Limiti");
                Log.e("LimitLine",""+limitLine.getLimit());
                break;
            case 9:
                valuesList.addAll(data.getCarbonMonoxideData().getValues());
                lineChart.setDescription(data.getCarbonMonoxideData().getUnit());
                dataset = new LineDataSet(entries, data.getCarbonMonoxideData().getStationName());
                getSupportActionBar().setTitle(data.getCarbonMonoxideData().getStationName());
                limitLine = new LimitLine(data.getCarbonMonoxideData().getLimitValue(), "Limiti");
                Log.e("LimitLine",""+limitLine.getLimit());
                break;
            case 5:
                valuesList.addAll(data.getAmoniumData().getValues());
                lineChart.setDescription(data.getAmoniumData().getUnit());
                dataset = new LineDataSet(entries, data.getAmoniumData().getStationName());
                getSupportActionBar().setTitle(data.getAmoniumData().getStationName());
                limitLine = new LimitLine(data.getAmoniumData().getLimitValue(), "Limiti");
                Log.e("LimitLine",""+limitLine.getLimit());
                break;
            case 10:
                valuesList.addAll(data.getHydrogenSulfideData().getValues());
                lineChart.setDescription(data.getHydrogenSulfideData().getUnit());
                dataset = new LineDataSet(entries, data.getHydrogenSulfideData().getStationName());
                getSupportActionBar().setTitle(data.getHydrogenSulfideData().getStationName());
                limitLine = new LimitLine(data.getHydrogenSulfideData().getLimitValue(), "Limiti");
                Log.e("LimitLine",""+limitLine.getLimit());
                break;
            case 8:
                valuesList.addAll(data.getSulfurDioxideData().getValues());
                lineChart.setDescription(data.getSulfurDioxideData().getUnit());
                dataset = new LineDataSet(entries, data.getSulfurDioxideData().getStationName());
                getSupportActionBar().setTitle(data.getSulfurDioxideData().getStationName());
                limitLine = new LimitLine(data.getSulfurDioxideData().getLimitValue(), "Limiti");
                Log.e("LimitLine",""+limitLine.getLimit());
                break;
            case 6:
                valuesList.addAll(data.getNitrogenDioxideData().getValues());
                lineChart.setDescription(data.getNitrogenDioxideData().getUnit());
                dataset = new LineDataSet(entries, data.getNitrogenDioxideData().getStationName());
                getSupportActionBar().setTitle(data.getNitrogenDioxideData().getStationName());
                limitLine = new LimitLine(data.getNitrogenDioxideData().getLimitValue(), "Limiti");
                Log.e("LimitLine",""+limitLine.getLimit());
                break;
            case 7:
                valuesList.addAll(data.getCarbonDioxideData().getValues());
                lineChart.setDescription(data.getCarbonDioxideData().getUnit());
                dataset = new LineDataSet(entries, data.getCarbonDioxideData().getStationName());
                getSupportActionBar().setTitle(data.getCarbonDioxideData().getStationName());
                limitLine = new LimitLine(data.getCarbonDioxideData().getLimitValue(), "Limiti");
                Log.e("LimitLine",""+limitLine.getLimit());
                break;
        }

        for(int i = 0;i<valuesList.size();i++){
            entries.add(new Entry(valuesList.get(i).getValue(),i));
            string = valuesList.get(i).getTime().split(" ");
            date = string[0].split("-");
            day = date[date.length-1];
            labels.add(day);
        }

        dataset.setColors(ColorTemplate.JOYFUL_COLORS);
        dataset.setDrawCircles(true);
        dataset.setDrawCubic(true);
        dataset.setDrawStepped(false);
        dataset.setFillColor(Color.BLUE);
        dataset.setFillFormatter(new FillFormatter() {
            @Override
            public float getFillLinePosition(ILineDataSet iLineDataSet, LineDataProvider lineDataProvider) {
                return 0;
            }
        });
        dataset.setLineWidth(3f);
        lineChart.setCameraDistance(6f);
        lineChart.setGridBackgroundColor(Color.BLUE);
        lineChart.setPinchZoom(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            lineChart.setNestedScrollingEnabled(true);
        }
        lineChart.animateX(5000);
        lineData = new LineData(labels, dataset);
        lineChart.setData(lineData);
        YAxis leftAxis = lineChart.getAxisLeft();
        if(limitLine != null){
            limitLine.setLineColor(Color.RED);
            limitLine.setLineWidth(4f);
            limitLine.setTextColor(Color.BLACK);
            limitLine.setTextSize(12f);
            leftAxis.addLimitLine(limitLine);
        }

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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.search_menu) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if(id == R.id.home){
            Intent a = new Intent(this,MainActivity.class);
            startActivity(a);
            finish();
        }
        if(id == R.id.temperatura){
            showData(data,1);
        }else if(id == R.id.radiacioni){
            showData(data,2);
        }else if(id == R.id.puhuri){
            showData(data,3);
        }else if(id == R.id.zhurma){
            showData(data,4);
        }else if(id == R.id.monoksidiKarbonit){
            showData(data,9);
        }else if(id == R.id.amonium){
            showData(data,5);
        }else if(id == R.id.sulfuriHidrogjenit){
            showData(data,10);
        }else if(id == R.id.dioksidiSulfurit){
            showData(data, 8);
        }else if(id == R.id.dioksidiAzotit){
            showData(data, 6);
        }else if(id == R.id.dioksidiKarbonit){
            showData(data,7);
        }else if(id == R.id.info){
            showInformationDialog();
        }else if(id == R.id.subscribe){
            Intent a = new Intent(this, SubscribeActivity.class);
            startActivity(a);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showInformationDialog(){
        final Dialog informationDialog = new Dialog(this);
        informationDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        informationDialog.setContentView(R.layout.information_dialog);
        informationDialog.show();
    }

    @Subscribe
    public void onResponseEvent(ResponseEvent responseEvent){
    }
}
