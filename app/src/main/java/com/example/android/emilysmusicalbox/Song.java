package com.example.android.emilysmusicalbox;

/**
 * Created by alex on 6/14/18.
 */

public class Song {
    private String title;
    private String artist;
    private String album;

    public Song(String t, String a, String al){
        title = t;
        artist = a;
        album = al;
    }

    public String getTitle(){
        return title;
    }

    public String getArtist(){
        return artist;
    }

    public String getAlbum(){
        return album;
    }
}
