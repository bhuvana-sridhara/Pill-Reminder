package com.example.pill_tracker;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class mr_pillar extends AppCompatActivity {

ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mr_pillar);

        imageButton = (ImageButton) findViewById(R.id.imageButton3);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(mr_pillar.this, faq.class);
                startActivity(intent);
            }
        });

        TextView send = (TextView) findViewById(R.id.textView2);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(mr_pillar.this, mr_pillar_send_message.class);
                startActivity(intent);
            }
        });



        ActionBar actionBar = getSupportActionBar();
        String title = actionBar.getTitle().toString();
        getSupportActionBar().setDisplayShowHomeEnabled(true);

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
                Intent i = new Intent(mr_pillar.this, mr_pillar.class);
                this.startActivity(i);
                return true;
            case R.id.account:
                Intent i1 = new Intent(mr_pillar.this, edit_text_medicine.class);
                this.startActivity(i1);
                return true;
            case R.id.home:
                Intent i2 = new Intent(mr_pillar.this, home2.class);
                this.startActivity(i2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}