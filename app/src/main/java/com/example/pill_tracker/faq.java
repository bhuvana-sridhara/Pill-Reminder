package com.example.pill_tracker;

//import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class faq extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String,List<String>> listHash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_a_q);


        listView = (ExpandableListView)findViewById(R.id.lvExp);
        initData();
        listAdapter = new ExpandableList(faq.this,listDataHeader,listHash);
        listView.setAdapter(listAdapter);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
//                        Toast.makeText(MainActivity.this, "Add", Toast.LENGTH_LONG).show();
                        Intent myIntent = new Intent(faq.this, home2.class);
                        startActivity(myIntent);
                        break;

                }
                return true;
            }
        });

    }

    private void initData() {
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        listDataHeader.add("How to add Medicine?");
        listDataHeader.add("Steps to add Medicine?");
        listDataHeader.add("How to I update the Medicines?");
        listDataHeader.add("How can I send a message tot the caretaker?");

        List<String> addMed = new ArrayList<>();
        addMed.add("Click on the +(Add) icon at the bottom");

        List<String>  steps= new ArrayList<>();
        steps.add("Add Medicine Name");
        steps.add("Add purpose");
        steps.add("Add Dosage");
        steps.add("Add a reminder time");

        List<String> edit = new ArrayList<>();
        edit.add(" Click on the edit icon at the bottom");
        edit.add("Select the Medicine which you want to change");
        edit.add("Make the changes");
        edit.add("Click on save");


        List<String> message = new ArrayList<>();
        message.add("Click on the message icon at the top");
        message.add("Click on the help you need");
        message.add("Click on the message you want to send");
        message.add("UWP Firebase ");

        listHash.put(listDataHeader.get(0),addMed);
        listHash.put(listDataHeader.get(1),steps);
        listHash.put(listDataHeader.get(2),edit);
        listHash.put(listDataHeader.get(3),message);
    }
}
