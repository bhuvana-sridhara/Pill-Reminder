package com.example.pill_tracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class notification extends AppCompatActivity {private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String,List<String>> listHash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        listView = (ExpandableListView)findViewById(R.id.lvExp);
        initData();
        listAdapter = new ExpandableList(notification.this,listDataHeader,listHash);
        listView.setAdapter(listAdapter);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.notification);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
//                        Toast.makeText(MainActivity.this, "Add", Toast.LENGTH_LONG).show();
                        Intent myIntent = new Intent(notification.this, home2.class);
                        startActivity(myIntent);
                        break;
                    case R.id.setting:
                        //Toast.makeText(MainActivity.this, "Notify", Toast.LENGTH_LONG).show();
                        Intent myIntent3 = new Intent(notification.this, settings.class);
                        startActivity(myIntent3);
                        break;

                }
                return true;
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_app_bar, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.message:
                Intent i = new Intent(notification.this, mr_pillar.class);
                this.startActivity(i);
                return true;
            case R.id.account:
//                Intent i1 = new Intent(MainActivity.this, edit_text_medicine.class);
//                this.startActivity(i1);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void initData() {
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();


        listDataHeader.add("Sunday, November 29, 9PM");
        listDataHeader.add("Sunday, November 29, 3PM");
        listDataHeader.add("Saturday, November 28, 12AM");


        List<String> med1 = new ArrayList<>();
        med1.add("Paracetamol, 500 mg, 1 tablet [Fever]");

        List<String> med2 = new ArrayList<>();
        med2.add("Aspirin, 250mg, 1 tablet [Headache]");

        List<String> med3 = new ArrayList<>();
        med3.add("Insulin, 100ml, 1 unit, [Diabetes]");

        listHash.put(listDataHeader.get(0),med1);
        listHash.put(listDataHeader.get(2),med2);
        listHash.put(listDataHeader.get(1),med3);

    }
}