package com.example.pill_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class add_purpose extends AppCompatActivity {


    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_purpose);

        Bundle b = new Bundle();
        b = getIntent().getExtras();
        name = b.getString("name");

        Log.i("add_p", name);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.add);

        TextView textView = findViewById(R.id.text_view_id_name);

        textView.setText(name+" ?");
//        Button sendButton = (Button) findViewById(R.id.ButtonSendFeedback);
//        sendButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent(activity_add_purpose.this, add_dosage.class);
//                startActivity(intent);
//
//            }
//        });
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
                Intent i = new Intent(add_purpose.this, mr_pillar.class);
                this.startActivity(i);
                return true;
            case R.id.account:
//                Intent i1 = new Intent(MainActivity.this, edit_text_medicine.class);
//                this.startActivity(i1);
                return true;
            case R.id.home:
                Intent i2 = new Intent(add_purpose.this, home2.class);
                this.startActivity(i2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void submitNameOfMed(View button) {
//         Do click handling here
        final EditText nameField = (EditText) findViewById(R.id.EditTextPurpose);
        String purpose = nameField.getText().toString();
        Intent intent = new Intent(add_purpose.this, add_dosage.class);
        intent.putExtra("purpose",purpose );
        intent.putExtra("name",name );
        startActivity(intent);
    }


}