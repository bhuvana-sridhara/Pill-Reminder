package com.example.pill_tracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class edit_text_medicine extends AppCompatActivity {


    EditText name,purpose, dosage, np, tod, time;
    TextView medName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text_medicine);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.edit);

        name = (EditText)findViewById(R.id.medicine);
        purpose = (EditText)findViewById(R.id.purpose);
        dosage = (EditText)findViewById(R.id.dosage);
        np = (EditText)findViewById(R.id.nop);
//        tod = (EditText)findViewById(R.id.tod);
        time = (EditText)findViewById(R.id.time);

        medName = (TextView)findViewById(R.id.selectedMed);

        Bundle b = new Bundle();
        b = getIntent().getExtras();

        String nameMed = b.getString("name");
        String purposeMed = b.getString("purpose");
        String dosageMed = b.getString("dosage");
        String npMed = b.getString("numberOfPills");
        String todMed = b.getString("timeOfDay");
        String timeMed = b.getString("time");
        int position = b.getInt("position");

        name.setText(nameMed);
        purpose.setText(purposeMed);
        dosage.setText(dosageMed);
        np.setText(npMed);
//        tod.setText(todMed);
        time.setText(timeMed);

        medName.setText(nameMed);


        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.add:
//                        Toast.makeText(MainActivity.this, "Add", Toast.LENGTH_LONG).show();
                        Intent myIntent = new Intent(edit_text_medicine.this, add.class);
                        startActivity(myIntent);
                        break;
                    case R.id.edit:
//                        Toast.makeText(MainActivity.this, "Edit", Toast.LENGTH_LONG).show();
                        Intent myIntent1 = new Intent(edit_text_medicine.this, edit_window.class);
                        startActivity(myIntent1);
                        break;
                    case R.id.notification:
                        //Toast.makeText(MainActivity.this, "Notify", Toast.LENGTH_LONG).show();
                        Intent myIntent2 = new Intent(edit_text_medicine.this, notification.class);
                        startActivity(myIntent2);
                        break;
                    case R.id.setting:
                        //Toast.makeText(MainActivity.this, "Notify", Toast.LENGTH_LONG).show();
                        Intent myIntent3 = new Intent(edit_text_medicine.this, settings.class);
                        startActivity(myIntent3);
                        break;

                }
                return true;
            }
        });

        Button btn= (Button)findViewById(R.id.back);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), edit_window.class);
                view.getContext().startActivity(intent);}
        });

        Button save = (Button)findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

//                Log.i("check",""+position);

                String newName = String.valueOf(name.getText());
                String newPurpose = String.valueOf(purpose.getText());
                String newDosage = String.valueOf(dosage.getText());
                String newNp = String.valueOf(np.getText());
//                String newTod = String.valueOf(tod.getText());
                String newTime = String.valueOf(time.getText());

                edit_window obj = new edit_window();

                obj.detectChange(position, newName, newPurpose, newDosage, newNp,newTime);


                Intent intent1 = new Intent(view.getContext(), edit_window_dummy.class);
                intent1.putExtra("name",newName);
                intent1.putExtra("purpose",newPurpose);
                intent1.putExtra("dosage",newDosage);
                intent1.putExtra("np",newNp);
//                intent1.putExtra("tod",newTod);
                intent1.putExtra("time",newTime);
                intent1.putExtra("position",position);

                view.getContext().startActivity(intent1);

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
                Intent i = new Intent(edit_text_medicine.this, mr_pillar.class);
                this.startActivity(i);
                return true;
            case R.id.account:
//                Intent i1 = new Intent(MainActivity.this, edit_text_medicine.class);
//                this.startActivity(i1);
                return true;
            case R.id.home:
                Intent i2 = new Intent(edit_text_medicine.this, home2.class);
                this.startActivity(i2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}