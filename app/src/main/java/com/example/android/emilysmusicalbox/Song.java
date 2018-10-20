package com.example.android.emilysmusicalbox;

/**
 * Created by alex on 6/14/18.
 */

public class Song {
    private int titleId;
    private int artistId;
    private int albumId;

    public Song(int title, int artist, int album){
        titleId = title;
        artistId = artist;
        albumId = album;
    }

    public int getTitleId(){
        return titleId;
    }

    public int getArtistId(){
        return artistId;
    }

    public int getAlbumId(){
        return albumId;
    }
}
