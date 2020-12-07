package com.example.pill_tracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.add:
//                        Toast.makeText(MainActivity.this, "Add", Toast.LENGTH_LONG).show();
                        Intent myIntent = new Intent(MainActivity.this, add.class);
                        startActivity(myIntent);
                        break;
                    case R.id.edit:
//                        Toast.makeText(MainActivity.this, "Edit", Toast.LENGTH_LONG).show();
                        Intent myIntent1 = new Intent(MainActivity.this, edit_window.class);
                        startActivity(myIntent1);
                        break;
                    case R.id.notification:
                        //Toast.makeText(MainActivity.this, "Notify", Toast.LENGTH_LONG).show();
                        Intent myIntent2 = new Intent(MainActivity.this, notification.class);
                        startActivity(myIntent2);
                        break;
                    case R.id.setting:
                        //Toast.makeText(MainActivity.this, "Notify", Toast.LENGTH_LONG).show();
                        Intent myIntent3 = new Intent(MainActivity.this, settings.class);
                        startActivity(myIntent3);
                        break;

                }
                return true;
            }
        });




        ActionBar actionBar = getSupportActionBar();
        String title = actionBar.getTitle().toString();


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
                Intent i = new Intent(MainActivity.this, mr_pillar.class);
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

}