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
        if (i.getExtras() != null) {
            int songTitle = i.getIntExtra(SongListDisplayActivity.title_key, 0);
            int songArtist = i.getIntExtra(SongListDisplayActivity.artist_key, 0);
            int songAlbum = i.getIntExtra(SongListDisplayActivity.album_key, 0);

            title.setText(getApplicationContext().getString(songTitle));
            artist.setText(getApplicationContext().getString(songArtist));
            album.setText(getApplicationContext().getString(songAlbum));
        } else {
            title.setText(getApplicationContext().getString(R.string.no_song_playing));
        }
    }
}
