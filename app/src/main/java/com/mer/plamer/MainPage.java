package com.mer.plamer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import com.mer.plamer.controller.PlayerActivity;
import com.mer.plamer.usecases.PlayAction;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page_layout);

        ImageButton main_setting = (ImageButton) findViewById(R.id.main_settings);
        main_setting.setOnClickListener(v -> {
            Intent intent = new Intent(MainPage.this, SettingActivity.class);
            startActivity(intent);
        });

        ImageButton main_track = (ImageButton) findViewById(R.id.main_track_list);
        main_track.setOnClickListener(v -> {
            Intent intent = new Intent(MainPage.this, TrackActivity.class);
            startActivity(intent);
        });

        ImageButton main_playlist = (ImageButton) findViewById(R.id.main_playlist);
        main_playlist.setOnClickListener(v -> {
            Intent intent = new Intent(MainPage.this, PlaylistActivity.class);
            startActivity(intent);
        });

        ImageButton playing = (ImageButton) findViewById(R.id.main_playing);
        playing.setOnClickListener(v -> {
            Intent intent = new Intent(MainPage.this, PlayerActivity.class);
            startActivity(intent);
        });

        ImageButton playButton = (ImageButton) findViewById(R.id.main_play);
        playButton.setOnClickListener(v -> PlayAction.playPause());

        ImageButton repeatButton = (ImageButton) findViewById(R.id.main_repeat_list);
        repeatButton.setOnClickListener(v -> PlayAction.loop());

    }
}