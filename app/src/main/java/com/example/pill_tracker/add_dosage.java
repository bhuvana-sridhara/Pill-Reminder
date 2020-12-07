package com.example.pill_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Spinner;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class add_dosage extends AppCompatActivity {

    public static final String dosage="";
    public static final String name ="";
    public static final String purpose ="";

    String name1;
    String purpose1;
    String record;



    private Spinner spinner;
    private static final String[] paths = {"ml", "mg", "iu","tabs"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dosage);

        Bundle b = new Bundle();
        b = getIntent().getExtras();
        name1 = b.getString("name");
        purpose1 = b.getString("purpose");
        Log.i("add_d", name1+purpose1);

        record ="";




        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.add);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.text_view_id_name);
        textView.setText(name1);

        //get the spinner from the xml.
        Spinner dropdown = findViewById(R.id.spinner1);
//create a list of items for the spinner.

//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, paths);
//set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);

        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        // Whatever you want to happen when the first item gets selected
                        record = "ml";
                        displayResult();
                        break;
                    case 1:
                        // Whatever you want to happen when the second item gets selected
                        record = "mg";
                        displayResult();
                        break;
                    case 2:
                        // Whatever you want to happen when the thrid item gets selected
                        record = "iu";
                        displayResult();
                        break;
                    case 3:
                        // Whatever you want to happen when the thrid item gets selected
                        record = "tabs";
                        displayResult();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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
                Intent i = new Intent(add_dosage.this, mr_pillar.class);
                this.startActivity(i);
                return true;
            case R.id.account:
//                Intent i1 = new Intent(MainActivity.this, edit_text_medicine.class);
//                this.startActivity(i1);
                return true;
            case R.id.home:
                Intent i2 = new Intent(add_dosage.this, home2.class);
                this.startActivity(i2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void submitNameOfMed(View button) {
        // Do click handling here

        Intent intent = new Intent(add_dosage.this, add_schedule.class);
        final EditText nameField = (EditText) findViewById(R.id.EditTextDosage);
        String dosage = nameField.getText().toString();
//        Log.i("Dosage",dosage);

        intent.putExtra("dosage", dosage);
        intent.putExtra("name", name1);
        intent.putExtra("purpose", purpose1);
        startActivity(intent);
//        Log.i("add_d", dosage+name1+purpose1);

    }

    public void displayResult(){
        TextView display_data = findViewById(R.id.display_result);
        display_data.setText(record);
    }

}