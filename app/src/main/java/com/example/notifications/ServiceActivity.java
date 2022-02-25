package com.example.notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.core.app.NotificationCompat;

public class ServiceActivity extends Service {
    final String LOG_TAG = "myLogs";
    // Идентификатор уведомления
    private static final int NOTIFY_ID = 102;

    // Идентификатор канала
    private static String CHANNEL_ID = "my channel";

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {

        Intent notificationIntent = new Intent(this, SecondActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,
                0, notificationIntent,
                PendingIntent.FLAG_CANCEL_CURRENT);

        Intent notificationIntent1 = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent1 = PendingIntent.getActivity(this,
                0, notificationIntent1,
                PendingIntent.FLAG_CANCEL_CURRENT);

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_notification)
                        .setContentTitle("Уведомление")
                        .setContentText("Переход")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .addAction(R.drawable.ic_1_ac, "активность 1", pendingIntent)
                        .addAction(R.drawable.ic_2_ac, "активность 2", pendingIntent1)
                        .setAutoCancel(true);

        Notification notification = builder.build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1,notification);
        startForeground(1, notification);


        return super.onStartCommand(intent,flags,startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}