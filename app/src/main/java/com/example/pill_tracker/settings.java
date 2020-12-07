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

public class settings extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String,List<String>> listHash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        listView = (ExpandableListView)findViewById(R.id.lvExp);
        initData();
        listAdapter = new ExpandableList(settings.this,listDataHeader,listHash);
        listView.setAdapter(listAdapter);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.setting);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
//                        Toast.makeText(MainActivity.this, "Add", Toast.LENGTH_LONG).show();
                        Intent myIntent = new Intent(settings.this, home2.class);
                        startActivity(myIntent);
                        break;

                    case R.id.notification:
                        //Toast.makeText(MainActivity.this, "Notify", Toast.LENGTH_LONG).show();
                        Intent myIntent2 = new Intent(settings.this, notification.class);
                        startActivity(myIntent2);
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
                Intent i = new Intent(settings.this, mr_pillar.class);
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


        listDataHeader.add("My Profile");
        listDataHeader.add("My Account");
        listDataHeader.add("My Caregiver");
        listDataHeader.add("FAQ");


        List<String> FAQ = new ArrayList<>();
        FAQ.add("How do I add a medication?");

        List<String> myprofile = new ArrayList<>();
        myprofile.add("Name");
        myprofile.add("Phone number");
        myprofile.add("Account type");
        myprofile.add("Email");

        List<String> myaccount = new ArrayList<>();
        myaccount.add("Account type");
        myaccount.add("Privacy");

        List<String> mycaregiver = new ArrayList<>();
        mycaregiver.add("Caregiver info");
        mycaregiver.add("Edit caregiver");
        mycaregiver.add("Other");

        listHash.put(listDataHeader.get(3),FAQ);
        listHash.put(listDataHeader.get(0),myprofile);
        listHash.put(listDataHeader.get(2),mycaregiver);
        listHash.put(listDataHeader.get(1),myaccount);

    }
}