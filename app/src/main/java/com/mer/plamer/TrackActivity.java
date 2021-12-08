package com.mer.plamer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mer.plamer.controller.PlayControl;
import com.mer.plamer.controller.TrackAdapter;
import com.mer.plamer.usecases.PlayAction;
import com.mer.plamer.usecases.TrackLibraryAction;

import java.util.ArrayList;

public class TrackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.track_layout);

        // set button
        ImageButton playing = findViewById(R.id.trackPlaying);
        ImageButton playButton = findViewById(R.id.track_play);
        ImageButton repeatButton = findViewById(R.id.track_repeat_list);
        ImageButton prevButton = findViewById(R.id.track_prev);
        ImageButton nextButton = findViewById(R.id.track_next);
        setButton(playButton);

        // back to the last page
        ImageButton back = findViewById(R.id.track_back_last_page);
        back.setOnClickListener(v -> finish());

        // initialize data
        final ArrayList<TrackAdapter.TrackDataHolder> dataList = new ArrayList<>();
        ArrayList<String> allTrack =  TrackLibraryAction.fetchAllTrackIDs();
        for (String id : allTrack){
            dataList.add(new TrackAdapter.TrackDataHolder(id));
        }

        // set adapter
        final TrackAdapter adapter = new TrackAdapter(TrackActivity.this, dataList);
        final ListView lv = findViewById(R.id.trackList);
        lv.setAdapter(adapter);

        // play track when click on the track in the list
        lv.setOnItemClickListener((adapterView, view, i, l) -> {
            Toast.makeText(TrackActivity.this,
                    dataList.get(i).tittle +
                            " will be played.",Toast.LENGTH_SHORT).show();
            PlayControl.setMedia("NONE", dataList.get(i).id);
            setButton(playButton);
        });

        // open the playing page
        playing.setOnClickListener(v -> {
            Intent intent = new Intent(TrackActivity.this, PlayerActivity.class);
            startActivity(intent);
        });

        // play/pause music
        playButton.setOnClickListener(v -> {
            PlayControl.playPause();
            if (PlayAction.isPlaying()) {
                ((ImageButton)v).setImageResource(R.drawable.pause);
            } else{
                ((ImageButton) v).setImageResource(R.drawable.play);
            }
        });

        // change the loop style
        repeatButton.setOnClickListener(v -> PlayAction.loop());

        // previous music
        prevButton.setOnClickListener(v -> {
            PlayControl.prev();
        });

        // next music
        nextButton.setOnClickListener(v -> {
            PlayControl.next();
        });
    }

    public static void setButton(ImageButton playButton) {
        // set play/pause
        if (PlayAction.isPlaying()) {
            playButton.setImageResource(R.drawable.pause);
        } else{
            playButton.setImageResource(R.drawable.play);
        }
    }
}