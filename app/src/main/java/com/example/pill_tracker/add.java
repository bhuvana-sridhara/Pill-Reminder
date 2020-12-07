package com.example.pill_tracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;

public class add extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.add);
        ActionBar actionBar = getSupportActionBar();
        String title = actionBar.getTitle().toString();

        getSupportActionBar().setDisplayShowHomeEnabled(true);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
//                        Toast.makeText(MainActivity.this, "Add", Toast.LENGTH_LONG).show();
                        Intent myIntent = new Intent(add.this, home2.class);
                        startActivity(myIntent);
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
                Log.i("Message clicked","");
                Intent i = new Intent(add.this, mr_pillar.class);
                this.startActivity(i);
                return true;
            case R.id.account:
//                Intent i1 = new Intent(MainActivity.this, edit_text_medicine.class);
//                this.startActivity(i1);
                return true;
            case R.id.home:
                Intent i2 = new Intent(add.this, home2.class);
                this.startActivity(i2);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
    public void submitNameOfMed(View button) {


        Intent intent = new Intent(add.this, add_purpose.class);
        final EditText nameField = (EditText) findViewById(R.id.EditTextName);
        String name = nameField.getText().toString();
        intent.putExtra("name", name);
        startActivity(intent);
        Log.i("add", name);
    }
}