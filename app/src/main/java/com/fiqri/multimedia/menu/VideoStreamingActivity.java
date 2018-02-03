package com.fiqri.multimedia.menu;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.fiqri.multimedia.R;

public class VideoStreamingActivity extends AppCompatActivity {

    //TODO kenalin
    VideoView mVideo;
    String url ="http://www.androidbegin.com/tutorial/AndroidCommercial.3gp";
    ProgressDialog mDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_sederhana);
        //TODO hubungin
        mVideo = findViewById(R.id.videoView);
        //TODO siapkan progresDialog
        mDialog = new ProgressDialog(VideoStreamingActivity.this);
        mDialog.setTitle("Informasi");
        mDialog.setMessage("Loading pang . . .");
        mDialog.setIndeterminate(false);
        mDialog.setCancelable(false);
        mDialog.show();

        //TODO siapkan kontroler
        MediaController mController = new MediaController(VideoStreamingActivity.this);
        //TODO hubungkan controller dengan Video VIew
        mController.setAnchorView(mVideo);
        mVideo.setMediaController(mController);

        //TODO siapkan untuk dijalankan
        mVideo.setVideoURI(Uri.parse(url));
        mVideo.requestFocus();
        mVideo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
                mDialog.dismiss();
            }
        });
    }
}
