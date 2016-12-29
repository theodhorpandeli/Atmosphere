package com.example.theodhor.airchecker.gcm;

/**
 * Created by Dori on 4/20/2016.
 */
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.theodhor.airchecker.MainActivity;
import com.example.theodhor.airchecker.R;
import com.google.android.gms.gcm.GcmListenerService;


public class MyGcmListenerService extends GcmListenerService {

    private static final String TAG = "MyGcmListenerService";
    // [START receive_message]
    @Override
    public void onMessageReceived(String from, Bundle data) {
            String message = data.getString("message");
            String message1 = data.getString("title");
            String message2 = data.getString("subtitle");
            String time = "14:00";
            Log.d(TAG, "From: " + from);
            Log.d(TAG, "Message: " + message);
            Log.d(TAG, "Message: " + message1);
            Log.d(TAG, "Message: " + message2);

            if (from.startsWith("/topics/")) {
            } else {
            }
            sendNotification();
    }

    private void sendNotification() {
        android.support.v7.app.NotificationCompat.Builder notification = new android.support.v7.app.NotificationCompat.Builder(this);
        Intent intent = new Intent(MyGcmListenerService.this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);
        notification.setSmallIcon(R.drawable.small_icon)
                .setWhen(System.currentTimeMillis())
                .setContentTitle("Kujdes!")
                .setContentText("Shmangni kalimin ne qender, ajer i renduar")
                .setAutoCancel(true)
                .setLights(Color.BLUE, 3000, 3000);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            notification.setColor(this.getResources().getColor(R.color.aqi_good,null));
        }
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        notification.setSound(alarmSound);
        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, notification.build());
    }
}

