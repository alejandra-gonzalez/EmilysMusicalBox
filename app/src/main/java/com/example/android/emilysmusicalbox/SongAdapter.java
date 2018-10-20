package com.example.android.emilysmusicalbox;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by alex on 6/14/18.
 */

public class SongAdapter extends ArrayAdapter<Song> {
    private ArrayList<Song> songList;
    private int nowPlaying = -1;

    /**
     * My first review suggested that I use viewHolder so that I wouldn't have to call findViewById
     * as much.
     */
    static class ViewHolder {
        private TextView titleTextView;
        private TextView artistTextView;
        private ImageView statusImageView;

        public ViewHolder (View v){
            titleTextView = v.findViewById(R.id.title);
            artistTextView = v.findViewById(R.id.artist);
            statusImageView = v.findViewById(R.id.play_button);
        }
    }

    /**
     * Constructor for the SongAdapter
     * @param c Context
     * @param songs ArrayList of songs to display
     */
    public SongAdapter(Context c, ArrayList<Song> songs) {
        super(c, 0, songs);
        songList = songs;
    }

    /**
     * Sets up the view for each list item
     * @param position position of the song in the arraylist
     * @param convertView view for the list item
     * @return the view for the list item
     */
    @NonNull
    @Override
    public View getView(final int position, View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;

        //Basically this if statement creates a viewHolder for the list item if it hasn't already
        if (null == convertView) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);

            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        //Load current song and its information
        final Song currentSong = songList.get(position);

        holder.titleTextView.setText(getContext().getString(currentSong.getTitleId()));

        holder.artistTextView.setText(getContext().getString(currentSong.getArtistId()));

        if (position != nowPlaying){
            holder.statusImageView.setImageResource(R.drawable.purple_play_icons8);
        } else {
            holder.statusImageView.setImageResource(R.drawable.purple_pause_icons8);
        }
        //changes the icon depending on what song, if any, is playing
        holder.statusImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nowPlaying == position){
                    nowPlaying = -1;
                    SongAdapter.super.notifyDataSetChanged();
                }
                else {
                    nowPlaying = position;
                    SongAdapter.super.notifyDataSetChanged();
                }
            }
        });

        return convertView;
    }

    /**
     * @return the integer position of the song currently playing,
     * or -1 if no song is playing
     */
    public int getNowPlaying(){
        return nowPlaying;
    }
}
