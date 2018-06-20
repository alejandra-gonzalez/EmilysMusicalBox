package com.example.android.emilysmusicalbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        TextView title = findViewById(R.id.title);
        TextView artist = findViewById(R.id.artist);
        TextView album = findViewById(R.id.album);

        Intent i = getIntent();
        String songTitle = i.getStringExtra("title");
        String songArtist = i.getStringExtra("artist");
        String songAlbum = i.getStringExtra("album");

        title.setText(songTitle);
        artist.setText(songArtist);
        album.setText(songAlbum);
    }
}
