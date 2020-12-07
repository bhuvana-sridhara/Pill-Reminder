package com.example.pill_tracker;

import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.dpro.widgets.OnWeekdaysChangeListener;
import com.dpro.widgets.WeekdaysPicker;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;


public class add_schedule extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    List<String> nameArray = new ArrayList<>();
    List<String> purposeArray = new ArrayList<>();
    List<String> dosageArray = new ArrayList<>();
    List<String> scheduleArray = new ArrayList<>();
//    TextView tvTimer1;
//    int t1Hour, t1Minute;

    private TextView mTextView;
    Dialog myDialog;

    public static final String dosage="";
    public static final String name ="";
    public static final String purpose ="";
    public static final String schedule ="";

    public static final String CHANNEL_1_ID = "channel1";
    public static final String CHANNEL_2_ID = "channel2";


    String name1;
    String purpose1;
    String dosage1;

    WeekdaysPicker widget;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_schedule);

        Bundle b = new Bundle();
        b=getIntent().getExtras();

        name1 = b.getString("name");
        purpose1 = b.getString("purpose");
        dosage1 = b.getString("dosage");

        TextView textView = findViewById(R.id.text_view_id_name);

        textView.setText(name1 +" ?");

        myDialog = new Dialog(this);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.add);


        Log.i("Details",name1+purpose1+dosage1);
        mTextView = findViewById(R.id.textView);
        Button buttonTimePicker = findViewById(R.id.button_timepicker);
        buttonTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new time_picker_fragment();
                timePicker.show(getSupportFragmentManager(), "time picker");
            }
        });
        Button buttonCancelAlarm = findViewById(R.id.button_cancel);
        buttonCancelAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelAlarm();
            }
        });

        widget = (WeekdaysPicker) findViewById(R.id.weekdays);

        List<Integer> days = Arrays.asList();
        widget.setSelectedDays(days);

        widget.setOnWeekdaysChangeListener(new OnWeekdaysChangeListener() {
            @Override
            public void onChange(View view, int clickedDayOfWeek, List<Integer> selectedDays) {
                // Do Something
                Log.i("selectedDays", String.valueOf(selectedDays));
            }
        });

        addListenerOnButtonClick();
    }

    public void addListenerOnButtonClick(){
        CheckBox every_day = (CheckBox) findViewById(R.id.checkBox2);
        //Getting instance of CheckBoxes and Button from the activty_main.xml file
        every_day.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                if(every_day.isChecked()){
                    List<Integer> days = Arrays.asList(1,2,3,4,5,6,7);
                    widget.setSelectedDays(days);
                }
                else{
                    List<Integer> days = Arrays.asList();
                    widget.setSelectedDays(days);
                }
            }
        });

//        buttonOrder=(Button)findViewById(R.id.button);

        //Applying the Listener on the Button click
//        buttonOrder.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View view) {
//                int totalamount=0;
//                StringBuilder result=new StringBuilder();
//                result.append("Selected Items:");
//                if(pizza.isChecked()){
//                    result.append("\nPizza 100Rs");
//                    totalamount+=100;
//                }
//                result.append("\nTotal: "+totalamount+"Rs");
//                //Displaying the message on the toast
//
//            }
//
//        });
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Log.i("****Time is set to ", String.valueOf(hourOfDay+minute));
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND, 0);
        updateTimeText(c);
        try {
            startAlarm(c);
        } catch (PendingIntent.CanceledException e) {
            e.printStackTrace();
        }
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
                Intent i = new Intent(add_schedule.this, mr_pillar.class);
                this.startActivity(i);
                return true;
            case R.id.account:
//                Intent i1 = new Intent(MainActivity.this, edit_text_medicine.class);
//                this.startActivity(i1);
                return true;
            case R.id.home:
                Intent i2 = new Intent(add_schedule.this, home2.class);
                this.startActivity(i2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void updateTimeText(Calendar c) {
        String timeText = "Alarm set for: ";

        timeText += DateFormat.getTimeInstance(DateFormat.SHORT).format(c.getTime());
        Log.i("****Alarm set for:",timeText);
        mTextView.setText(timeText);
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void startAlarm(Calendar c) throws PendingIntent.CanceledException {

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Log.i("Alarm manager created", String.valueOf(alarmManager.getNextAlarmClock()));
        Intent intent = new Intent(this, alert_receiver.class);
        Log.i("time", String.valueOf(c.getTimeInMillis()));
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        Log.i("pending", String.valueOf(pendingIntent.getIntentSender()));
        if (c.before(Calendar.getInstance())) {
            Log.i("calendar added", c.toString());
            c.add(Calendar.DATE, 1);
        }

        Log.i("Build version is ", String.valueOf(Build.VERSION.SDK_INT));
//        if (Build.VERSION.SDK_INT < 19) {
//
//
//            alarmManager.set(AlarmManager.RTC,
//                    c.getTimeInMillis(), pendingIntent);
//        }
//        else if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT <= 22) {
//            alarmManager.setExact(AlarmManager.RTC,c.getTimeInMillis(), pendingIntent);
//        } else if (Build.VERSION.SDK_INT >= 23) {
//        alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC,
//                c.getTimeInMillis(), pendingIntent);
//    }



//        alarmManager.setExact(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pendingIntent);

//        Log.i("Alarm created", alarmManager.getNextAlarmClock().toString());


        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), 1000 * 60, pendingIntent);
        Log.i("Alarm manager created", String.valueOf(alarmManager.getNextAlarmClock()));


    }
    private void cancelAlarm() {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, alert_receiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);
        alarmManager.cancel(pendingIntent);
        mTextView.setText("Alarm canceled");
    }


    public  void ShowPopup(View view)
    {

        TextView textView;
        Button button;
        myDialog.setContentView(R.layout.popup);
        button = (Button) myDialog.findViewById(R.id.okbutton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(add_schedule.this, home2.class);
                startActivity(myIntent);
//                nameArray.add(name1);
//                purposeArray.add(purpose1);
//                dosageArray.add(dosage1);
//
//                for(int i  = 0; i< nameArray.size();i++) {
//                    Log.i("check", "" + nameArray.get(i));
//                    Log.i("check", "" + purposeArray.get(i));
//                    Log.i("check", "" + dosageArray.get(i));
//                    Log.i("check", "" + scheduleArray.get(i));

//                }

            }
        });
        myDialog.show();
    }
}


