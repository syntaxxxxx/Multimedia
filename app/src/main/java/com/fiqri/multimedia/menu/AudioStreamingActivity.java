package com.fiqri.multimedia.menu;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.fiqri.multimedia.R;

import java.io.IOException;

public class AudioStreamingActivity extends AppCompatActivity {

    Button mPlay, mStop;
    ProgressBar mProgressbar;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_streaming);

        mPlay = findViewById(R.id.btnPlayStreaming);
        mStop = findViewById(R.id.btnStopStreaming);
        mProgressbar = findViewById(R.id.progressBar);

        mProgressbar.setVisibility(View.INVISIBLE);
        mProgressbar.setIndeterminate(false);
        mProgressbar.setMax(100);

        prepare();

        mPlay.setEnabled(true);
        mStop.setEnabled(false);

        mPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlay.setEnabled(false);
                mStop.setEnabled(true);
                mProgressbar.setVisibility(View.VISIBLE);
                mProgressbar.setIndeterminate(true);
                mediaPlayer.prepareAsync();
                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        mp.start();
                        mProgressbar.setIndeterminate(false);

                    }
                });
            }
        });

        mStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer == null) return;
                if (mediaPlayer.isPlaying()) {
                    mStop.setEnabled(false);
                    mPlay.setEnabled(true);
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    prepare();
                    mProgressbar.setVisibility(View.VISIBLE);
                    mProgressbar.setIndeterminate(true);
                }
            }
        });
    }
    private void prepare(){
        String url = "http://103.16.198.36:9160/stream";

        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaPlayer.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
            @Override
            public void onBufferingUpdate(MediaPlayer mp, int percent) {
                mProgressbar.setIndeterminate(true);
                mProgressbar.setSecondaryProgress(100);
            }
        });
    }
}

