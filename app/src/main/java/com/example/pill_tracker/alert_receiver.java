package com.example.pill_tracker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.util.Log;

import androidx.core.app.NotificationCompat;

public class alert_receiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("****Alarm ringing", String.valueOf(context));
        final Ringtone r = RingtoneManager.getRingtone(context.getApplicationContext(), RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM));
        r.play();
        notification_helper notificationHelper = new notification_helper(context);
        NotificationCompat.Builder nb = notificationHelper.getChannelNotification();

        notificationHelper.getManager().notify(1, nb.build());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notificationHelper.getManager().cancel(1);
        r.stop();

    }
}
