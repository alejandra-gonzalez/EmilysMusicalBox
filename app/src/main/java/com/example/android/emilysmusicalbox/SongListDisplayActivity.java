package com.example.android.emilysmusicalbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class SongListDisplayActivity extends AppCompatActivity {

    /**
     * Sets up the layout, the arraylist of songs, and the adapter for the listview
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list_display);

        final ArrayList<Song> songsList = new ArrayList<>();
        songsList.add(new Song("I Miss You", "blink-182", "Blink-182"));
        songsList.add(new Song("Yours To Hold", "Skillet", "Comatose"));
        songsList.add(new Song("LOVE. (FT Zacari)", "Kendrick Lamar", "DAMN."));
        songsList.add(new Song("Hold On, We're Going Home", "Majid Jordan, Drake", "Nothing Was the Same (Deluxe)"));
        songsList.add(new Song("Better in Stereo", "Dove Cameron", "Liv and Maddie (Music from the TV Series)"));
        songsList.add(new Song("As If", "Blaque", "Blaque Out"));
        songsList.add(new Song("Me Enamore", "Shakira", "El Dorado"));
        songsList.add(new Song("Let Me Love You", "Mario", "Turning Point"));
        songsList.add(new Song("I'm Already Gone", "A Day to Remember", "Common Courtesy"));
        songsList.add(new Song("Te Quiero Tanto, Tanto", "OV7", "Entrega Total"));
        songsList.add(new Song("In Florida", "A Day to Remember", "Bad Vibrations"));
        songsList.add(new Song("Mi Niña Bonita", "Chino y Nacho", "Mi Niña Bonita"));
        songsList.add(new Song("Down", "Lil Wayne, Jay Sean", "All or Nothing"));
        songsList.add(new Song("Antes De Que Te Vayas", "Marco Antonio Solis", "Trozos de Mi Alma, Vol. 2"));
        songsList.add(new Song("Love Story", "Taylor Swift", "Fearless"));

        final SongAdapter itemsAdapter = new SongAdapter(this, songsList);

        ListView listView = (ListView) findViewById(R.id.list);
        Button nowPlaying = (Button) findViewById(R.id.now_playing);

        listView.setAdapter(itemsAdapter);

        /*
         * This code launches the Now Playing activity.
         * First you get the song that is now playing, then send its information to the next activity via intent.
         */
        nowPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SongListDisplayActivity.this, NowPlayingActivity.class);
                if (itemsAdapter.getNowPlaying() == -1){
                    i.putExtra("title", "No song playing");
                    i.putExtra("artist", "");
                    i.putExtra("album", "");
                }
                else {
                    Song playing = songsList.get(itemsAdapter.getNowPlaying());
                    i.putExtra("title", playing.getTitle());
                    i.putExtra("artist", playing.getArtist());
                    i.putExtra("album", playing.getAlbum());
                }
                startActivity(i);
            }
        });
    }
}
