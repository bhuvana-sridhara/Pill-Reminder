package com.example.pill_tracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class mr_pillar_send_message extends AppCompatActivity {
    EditText textView; TextView textView1; Button button;

    Dialog myDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mr_pillar_send_message);
        textView1 = (TextView)findViewById(R.id.textView14);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("came", "cam");
                textView1.setBackgroundResource(R.color.gray);
            }
        });

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
//                        Toast.makeText(MainActivity.this, "Add", Toast.LENGTH_LONG).show();
                        Intent myIntent = new Intent(mr_pillar_send_message.this, home2.class);
                        startActivity(myIntent);
                        break;

                }
                return true;
            }
        });
        button = (Button) findViewById(R.id.back);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent(mr_pillar_send_message.this, home2.class);
            startActivity(intent);
            }
        });
        myDialog = new Dialog(this);
    }
    public  void ShowPopup2(View view)
    {
        TextView textView;
        Button button;
        myDialog.setContentView(R.layout.popup2);


        button = (Button) myDialog.findViewById(R.id.button);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });
        myDialog.show();
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
                Intent i = new Intent(mr_pillar_send_message.this, mr_pillar.class);
                this.startActivity(i);
                return true;
            case R.id.account:
//                Intent i1 = new Intent(mr_pillar.this, edit_text_medicine.class);
//                this.startActivity(i1);
                return true;
            case R.id.home:
                Intent i2 = new Intent(mr_pillar_send_message.this, home2.class);
                this.startActivity(i2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}