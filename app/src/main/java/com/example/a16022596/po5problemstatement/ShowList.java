package com.example.a16022596.po5problemstatement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowList extends AppCompatActivity {

    ListView lvResult;
    ArrayAdapter aa;
    ArrayList<Song> songs;
    DBHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list);

        lvResult = (ListView)findViewById(R.id.lvTitle);
        db = new DBHelper(this);
        db.getWritableDatabase();
        songs = db.getAllSongs();
        db.close();

        aa = new ArrayAdapterSong(ShowList.this, R.layout.row, songs);
        aa.setNotifyOnChange(true);
        lvResult.setAdapter(aa);

        lvResult.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long identity) {
                Intent i = new Intent(ShowList.this,
                        EditActivity.class);
                Song songData = songs.get(position);
                int id = songData.getId();
                String title = songData.getTitle();
                String singer = songData.getSinger();
                int year = songData.getYear();
                int stars = songData.getStars();
                Song target = new Song(id, title,singer,year,stars);
                i.putExtra("data", target);
                startActivityForResult(i, 9);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 9){
            lvResult.performClick();
        }
    }
}


