package com.fiqri.multimedia.menu;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

import com.fiqri.multimedia.R;

public class VideoSederhanaActivity extends AppCompatActivity {

    VideoView mVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_video_sederhana);

        Uri uri_video = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.androidcommercial);

        mVideo = findViewById(R.id.videoView);

        MediaController mediaController = new MediaController(VideoSederhanaActivity.this);

        mediaController.setAnchorView(mVideo);
        mVideo.setMediaController(mediaController);

        mVideo.setVideoURI(uri_video);

        mVideo.requestFocus();
        mVideo.start();


    }
}
