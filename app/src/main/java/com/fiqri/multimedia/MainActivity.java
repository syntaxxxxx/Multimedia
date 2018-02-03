package com.fiqri.multimedia;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.fiqri.multimedia.menu.AudioSederhanaActivity;
import com.fiqri.multimedia.menu.AudioStreamingActivity;
import com.fiqri.multimedia.menu.VideoSederhanaActivity;
import com.fiqri.multimedia.menu.VideoStreamingActivity;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                //TODO ketika diklik
                case R.id.nav_audio_sederhana:
                    mTextMessage.setText("Audio Sederhana");
                    startActivity(new Intent(MainActivity.this, AudioSederhanaActivity.class));
                    return true;
                case R.id.nav_audio_streaming:
                    mTextMessage.setText("Audio Streaming");
                    startActivity(new Intent(MainActivity.this, AudioStreamingActivity.class));
                    return true;
                case R.id.nav_video_sederhana:
                    mTextMessage.setText("Video Sederhana");
                    startActivity(new Intent(MainActivity.this, VideoSederhanaActivity.class));
                    return true;
                case R.id.nav_video_streaming:
                    mTextMessage.setText("Video Streaming");
                    startActivity(new Intent(MainActivity.this, VideoStreamingActivity.class));
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
}
