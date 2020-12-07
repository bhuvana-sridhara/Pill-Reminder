package com.example.pill_tracker;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class edit_window extends AppCompatActivity {



    ListView list;
    String[] name = {
            "Paracetemol","Crocin","Insulin"
    };
    String[] purpose = {
            "Pain","Headache","Diabetes"
    };

    String[] Dosage = {
            "600mg","500mg","100ml"
    };

    String[] numberOfPills = {
            "1","3","1"
    };

    Integer[] image = {R.drawable.caret_right};

//    String[] timeOfDay = {
//            "Afternoon","Morning","Evening"
//    };

    String[] time = {
            "9:00 A.M.", "4:00 P.M.", "10:09 A.M."
    };

    public static int pos;
    MyAdapter myAdapter;


    @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_edit_window);
            this.setTitle("My Medicines");

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.edit);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.add:
//                        Toast.makeText(MainActivity.this, "Add", Toast.LENGTH_LONG).show();
                        Intent myIntent = new Intent(edit_window.this, add.class);
                        startActivity(myIntent);
                        break;
                    case R.id.edit:
//                        Toast.makeText(MainActivity.this, "Edit", Toast.LENGTH_LONG).show();
                        Intent myIntent1 = new Intent(edit_window.this, edit_window.class);
                        startActivity(myIntent1);
                        break;
                    case R.id.notification:
                        //Toast.makeText(MainActivity.this, "Notify", Toast.LENGTH_LONG).show();
                        Intent myIntent2 = new Intent(edit_window.this, notification.class);
                        startActivity(myIntent2);
                        break;
                    case R.id.setting:
                        //Toast.makeText(MainActivity.this, "Notify", Toast.LENGTH_LONG).show();
                        Intent myIntent3 = new Intent(edit_window.this, settings.class);
                        startActivity(myIntent3);
                        break;

                }
                return true;
            }
        });

            list = findViewById(R.id.list);
            myAdapter = new MyAdapter(edit_window.this, name, purpose, Dosage,numberOfPills, time);
            list.setAdapter(myAdapter);
            ImageView imageView = (ImageView) findViewById( R.id.imageViewEdit1);
            imageView.setImageResource(image[0]);
            imageView = (ImageView) findViewById( R.id.imageViewEdit2);
            imageView.setImageResource(image[0]);
            imageView = (ImageView) findViewById( R.id.imageViewEdit3);
            imageView.setImageResource(image[0]);

            registerForContextMenu(list);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                                            @Override
                                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                                String set = String.valueOf(position);

                                                pos = Integer.parseInt(set);
                                                Intent intent = new Intent(edit_window.this, edit_text_medicine.class);
                                                String name1,purpose1,dosage1,numberOfPills1,timeOfDay1,time1;
                                                name1 = name[position];
                                                purpose1 = purpose[position];
                                                dosage1 = Dosage[position];
                                                numberOfPills1 = numberOfPills[position];
//                                                timeOfDay1 = timeOfDay[position];
                                                time1 = time[position];
                                                intent.putExtra("name",name1);
                                                intent.putExtra("purpose",purpose1);
                                                intent.putExtra("dosage",dosage1);
                                                intent.putExtra("numberOfPills",numberOfPills1);
//                                                intent.putExtra("timeOfDay",timeOfDay1);
                                                intent.putExtra("time",time1);
                                                intent.putExtra("position", pos);
                                                startActivity(intent);


                                            }
                                        }

            );

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
                Intent i = new Intent(edit_window.this, mr_pillar.class);
                this.startActivity(i);
                return true;
            case R.id.account:
//                Intent i1 = new Intent(MainActivity.this, edit_text_medicine.class);
//                this.startActivity(i1);
                return true;
            case R.id.home:
                Intent i2 = new Intent(edit_window.this, home2.class);
                this.startActivity(i2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void detectChange(int position, String newMed, String newPurpose,String newDosage,String newNp,  String newTime) {

            Log.i("check",""+position);
            Log.i("name",""+newMed);

            name[position] = newMed;
            purpose[position] = newPurpose;
            Dosage[position] = newDosage;
            numberOfPills[position] = newNp;
//            timeOfDay[position] = newTod;
            time[position] = newTime;

            Log.i("name",""+name[position]);


//        myAdapter = new MyAdapter(edit_Window.this, name, purpose, Dosage,numberOfPills, timeOfDay, time);
//            myAdapter.notifyDataSetChanged();
//         list.setAdapter(myAdapter);

        }
//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
//
//        super.onCreateContextMenu(menu, view, menuInfo);
//        getMenuInflater().inflate(R.menu.menu,menu);
//    }
//

    }


