package com.example.a16022596.po5problemstatement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ArrayAdapterSong extends ArrayAdapter<Song> {
    Context context;
    ArrayList<Song> songs;
    int resource;
    ImageView iv1, iv2, iv3, iv4, iv5;
    TextView tvTitle,tvYear,tvSinger;

    public ArrayAdapterSong(Context context, int resource, ArrayList<Song> songs) {
        super(context, resource, songs);
        this.context = context;
        this.songs = songs;
        this.resource = resource;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(resource, parent, false);
        tvSinger = (TextView) rowView.findViewById(R.id.textViewSinger);
        tvYear = (TextView) rowView.findViewById(R.id.textViewYear);
        tvTitle = (TextView) rowView.findViewById(R.id.textViewTitle);

        iv1  = (ImageView)rowView.findViewById(R.id.imageView1);
        iv2  = (ImageView)rowView.findViewById(R.id.imageView2);
        iv3  = (ImageView)rowView.findViewById(R.id.imageView3);
        iv4  = (ImageView)rowView.findViewById(R.id.imageView4);
        iv5  = (ImageView)rowView.findViewById(R.id.imageView5);
        Song currentSong= songs.get(position);
        tvTitle.setText("Title: " + currentSong.getTitle());
        tvSinger.setText("Singer: " + currentSong.getSinger());
        tvYear.setText("Year:" + currentSong.getYear());


        int stars = currentSong.getStars();

        //Match the UI components with Java variables

        //Check if the property for starts >= 5, if so, "light" up the stars
        if (stars == 1) {
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        } else if (stars == 2) {
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);

        } else if (stars == 3) {
            iv3.setImageResource(android.R.drawable.btn_star_big_on);
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        } else if (stars == 4) {
            iv4.setImageResource(android.R.drawable.btn_star_big_on);
            iv3.setImageResource(android.R.drawable.btn_star_big_on);
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        }
        else{
            iv5.setImageResource(android.R.drawable.btn_star_big_on);
            iv4.setImageResource(android.R.drawable.btn_star_big_on);
            iv3.setImageResource(android.R.drawable.btn_star_big_on);
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        }
        return rowView;
    }

}
