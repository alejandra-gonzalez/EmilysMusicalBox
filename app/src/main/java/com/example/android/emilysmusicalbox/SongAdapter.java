package com.example.android.emilysmusicalbox;

import android.content.Context;
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
    private ArrayList<Song> mSongList = new ArrayList<>();
    private int mNowPlaying = -1;

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
        mSongList = songs;
    }

    /**
     * Sets up the view for each list item
     * @param position position of the song in the arraylist
     * @param convertView view for the list item
     * @param parent
     * @return the view for the list item
     */
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        //Basically this if statement creates a viewHolder for the list item if it hasn't already
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);

            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        //Load current song and its information
        final Song currentSong = mSongList.get(position);

        holder.titleTextView.setText(currentSong.getTitle());

        holder.artistTextView.setText(currentSong.getArtist());

        if (position != mNowPlaying){
            holder.statusImageView.setImageResource(R.drawable.purple_play_icons8);
        } else {
            holder.statusImageView.setImageResource(R.drawable.purple_pause_icons8);
        }
        //changes the icon depending on what song, if any, is playing
        holder.statusImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mNowPlaying == position){
                    mNowPlaying = -1;
                    SongAdapter.super.notifyDataSetChanged();
                }
                else {
                    mNowPlaying = position;
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
        return mNowPlaying;
    }
}
