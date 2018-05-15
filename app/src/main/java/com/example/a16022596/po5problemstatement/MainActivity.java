package com.example.a16022596.po5problemstatement;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnShowList = (Button)findViewById(R.id.buttonShowList);
        Button btnAdd = (Button)findViewById(R.id.buttonInsert);
        final EditText etSinger = (EditText)findViewById(R.id.editTextInsertSinger);
        final EditText etTitle = (EditText)findViewById(R.id.editTextInsertTitle);
        final EditText etYear = (EditText)findViewById(R.id.editTextInsertYear);
        final RadioGroup rgStars = (RadioGroup)findViewById(R.id.radioGroupStars);


        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,
                        ShowList.class);
                startActivity(i);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(MainActivity.this);
                String singer = etSinger.getText().toString();
                String title = etTitle.getText().toString();
                String year = etYear.getText().toString();
                int yearInteger = Integer.valueOf(year);

                int selectedButtonId = rgStars.getCheckedRadioButtonId();
                RadioButton rbStars = (RadioButton)findViewById(selectedButtonId);
                String rbText = rbStars.getText().toString();
                int starsValue;
                if (rbText.equals("1")){
                    starsValue = 1;
                }
                else if(rbText.equals("2")){
                    starsValue = 2;
                }
                else if(rbText.equals("3")){
                    starsValue = 3;
                }
                else if(rbText.equals("4")){
                    starsValue = 4;
                }
                else{
                    starsValue = 5;
                }

                long row_affected = dbh.insertSong(title,singer,yearInteger,starsValue);
                dbh.close();
                if (row_affected != -1){
                    Toast.makeText(MainActivity.this, "Insert successful",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
