package com.example.alarmmanager;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class AlertReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Intent activityIntent = new Intent(context.getApplicationContext(), MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context.getApplicationContext(), 0, activityIntent, 0);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context.getApplicationContext());
        Notification notification = new NotificationCompat.Builder(context.getApplicationContext(), App.CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle("Alarm!")
                .setContentText("Your alarm in working")
                .setContentIntent(contentIntent)
                .build();
        notificationManager.notify(1, notification);
    }
}
