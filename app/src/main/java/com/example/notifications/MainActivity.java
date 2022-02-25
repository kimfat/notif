package com.example.notifications;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String logActivityName = "Log_activity";
    private TextView mInfoTextView;
    ServiceConnection sConn;
    boolean bound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mInfoTextView = (TextView) findViewById(R.id.textViewInfo);
        sConn = new ServiceConnection() {
            public void onServiceConnected(ComponentName name, IBinder binder) {
                bound = true;
            }
            public void onServiceDisconnected(ComponentName name) {
                bound = false;
            }
        };
    }

    public void onClick(View v) {
        if (v.getId() == R.id.startService) {
            mInfoTextView.setText("startService");
            startService(new Intent(this, ServiceActivity.class));
        }
    }

}