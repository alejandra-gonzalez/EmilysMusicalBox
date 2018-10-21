package com.example.android.emilysmusicalbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class SongListDisplayActivity extends AppCompatActivity {

    public static final String title_key = "titleId";
    public static final String artist_key = "artistId";
    public static final String album_key = "albumId";

    /**
     * Sets up the layout, the arraylist of songs, and the adapter for the listview
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list_display);

        final ArrayList<Song> songsList = new ArrayList<>();
        songsList.add(new Song(R.string.first_song_title, R.string.first_song_artist, R.string.first_song_album));
        songsList.add(new Song(R.string.second_song_title, R.string.second_song_artist, R.string.second_song_album));
        songsList.add(new Song(R.string.third_song_title, R.string.third_song_artist, R.string.third_song_album));
        songsList.add(new Song(R.string.fourth_song_title, R.string.fourth_song_artist, R.string.fourth_song_album));
        songsList.add(new Song(R.string.fifth_song_title, R.string.fifth_song_artist, R.string.fifth_song_album));
        songsList.add(new Song(R.string.sixth_song_title, R.string.sixth_song_artist, R.string.sixth_song_album));
        songsList.add(new Song(R.string.seventh_song_title, R.string.seventh_song_artist, R.string.seventh_song_album));
        songsList.add(new Song(R.string.eighth_song_title, R.string.eighth_song_artist, R.string.eighth_song_album));
        songsList.add(new Song(R.string.ninth_song_title, R.string.ninth_song_artist, R.string.ninth_song_album));
        songsList.add(new Song(R.string.tenth_song_title, R.string.tenth_song_artist, R.string.tenth_song_album));
        songsList.add(new Song(R.string.eleventh_song_title, R.string.eleventh_song_artist, R.string.eleventh_song_album));
        songsList.add(new Song(R.string.twelfth_song_title, R.string.twelfth_song_artist, R.string.twelfth_song_album));
        songsList.add(new Song(R.string.thirteenth_song_title, R.string.thirteenth_song_artist, R.string.thirteenth_song_album));
        songsList.add(new Song(R.string.fourteenth_song_title, R.string.fourteenth_song_artist, R.string.fourteenth_song_album));
        songsList.add(new Song(R.string.fifteenth_song_title, R.string.fifteenth_song_artist, R.string.fifteenth_song_album));

        final SongAdapter itemsAdapter = new SongAdapter(this, songsList);

        RecyclerView recyclerView = findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Button nowPlaying = findViewById(R.id.now_playing);
        recyclerView.setAdapter(itemsAdapter);

        /*
         * This code launches the Now Playing activity.
         * First you get the song that is now playing, then send its information to the next activity via intent.
         */
        nowPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SongListDisplayActivity.this, NowPlayingActivity.class);
                if (itemsAdapter.getNowPlaying() != -1) {
                    Song playing = songsList.get(itemsAdapter.getNowPlaying());
                    i.putExtra(title_key, playing.getTitleId());
                    i.putExtra(artist_key, playing.getArtistId());
                    i.putExtra(album_key, playing.getAlbumId());
                }
                startActivity(i);
            }
        });
    }
}
