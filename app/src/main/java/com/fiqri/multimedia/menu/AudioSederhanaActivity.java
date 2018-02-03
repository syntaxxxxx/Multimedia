package com.fiqri.multimedia.menu;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.fiqri.multimedia.R;

import java.io.IOException;

public class AudioSederhanaActivity extends AppCompatActivity implements View.OnClickListener {
    //TODO kenalin
    Button mPlay, mStop, mPause, mResume;
    MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_sederhana);
        //TODO hubungkan
        mPause = findViewById(R.id.btnPause);
        mPlay = findViewById(R.id.btnPlay);
        mResume = findViewById(R.id.btnResume);
        mStop = findViewById(R.id.btnStop);
        //TODO action
        mPlay.setOnClickListener(this);
        mPause.setOnClickListener(this);
        mStop.setOnClickListener(this);
        mResume.setOnClickListener(this);

        //TODO setAwal
        enable(mPlay);
        disable(mPause, mStop, mResume);
    }

    @Override
    public void onClick(View view) {
        //TODO ketika diklik
        if (view.getId() == R.id.btnPlay) {
            //TODO ketika play
            Uri uri_musik = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.music);
            mPlayer = new MediaPlayer();
            mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            try {
                mPlayer.setDataSource(AudioSederhanaActivity.this, uri_musik);
                mPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
            mPlayer.start();
            //TODO ketika playing
            enable(mStop, mPause);
            disable(mPlay, mResume);
        }else if (view.getId() == R.id.btnPause){
            //TODO ketika pause
            if (mPlayer.isPlaying()){
                mPlayer.pause();
                //TODO ketika pause berjalan
                enable(mResume);
                disable(mPlay, mStop, mPause);
            }
        }else if (view.getId() ==  R.id.btnResume){
            //TODO ketika resume
            mPlayer.start();
            //TODO ketika resum berjalan
            enable(mPause, mStop);
            disable(mPlay, mResume);
        }else if (view.getId() == R.id.btnStop){
            //TODO ketika stop
            if (mPlayer.isPlaying() && mPlayer != null) {
                mPlayer.stop();
                //TODO ketika stop berjalan
                enable(mPlay);
                disable(mStop, mResume, mPause);
            }
        }
    }

    //TODO set untuk enable
    public void enable(View ... views){
        for (View mView : views){
            mView.setEnabled(true);
        }
    }
    //TODO set untuk disable
    public void disable(View ... views){
        for (View mView : views){
            mView.setEnabled(false);
        }
    }
}