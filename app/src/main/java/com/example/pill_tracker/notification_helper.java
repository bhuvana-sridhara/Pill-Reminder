package com.example.pill_tracker;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.Build;

import androidx.core.app.NotificationCompat;

import static android.app.Notification.EXTRA_NOTIFICATION_ID;

public class notification_helper extends ContextWrapper {
    public static final String channelID = "channelID";
    public static final String channelName = "Channel Name";
    private static final String ACTION_SNOOZE = "Snooze";
    private NotificationManager mManager;
    public notification_helper(Context base) {
        super(base);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannel();
        }
    }
    @TargetApi(Build.VERSION_CODES.O)
    private void createChannel() {
        NotificationChannel channel = new NotificationChannel(channelID, channelName, NotificationManager.IMPORTANCE_HIGH);
        getManager().createNotificationChannel(channel);
    }
    public NotificationManager getManager() {
        if (mManager == null) {
            mManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return mManager;
    }
    public NotificationCompat.Builder getChannelNotification() {


        Intent snoozeIntent = new Intent(this, alert_receiver.class);
        snoozeIntent.setAction(ACTION_SNOOZE);
        snoozeIntent.putExtra(EXTRA_NOTIFICATION_ID, 0);
        PendingIntent snoozePendingIntent =
                PendingIntent.getBroadcast(this, 0, snoozeIntent, 0);


        return new NotificationCompat.Builder(getApplicationContext(), channelID)
                .setContentTitle("Time to take your medication!")
                .setContentText("Take 2 doses (150 ml) of Insulin")
                .setSmallIcon(R.drawable.piller_icon)
                .addAction(R.drawable.piller_icon,"Take",snoozePendingIntent)
                .addAction(R.drawable.piller_icon,"Skip",snoozePendingIntent)
                .addAction(R.drawable.snooze,"Snooze",snoozePendingIntent)
                ;
    }
}
