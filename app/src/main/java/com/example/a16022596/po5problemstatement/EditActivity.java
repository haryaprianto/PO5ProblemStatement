package com.example.a16022596.po5problemstatement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class EditActivity extends AppCompatActivity {

    Button btnUpdate,btnCancel,btnDelete;
    EditText etUpdateTitle,etUpdateSinger,etUpdateYear;
    RadioGroup rgUpdateStars;
    TextView tvId;
    Song data;
    ArrayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        btnUpdate = (Button)findViewById(R.id.buttonUpdate);
        btnCancel = (Button)findViewById(R.id.buttonCancel);
        btnDelete = (Button)findViewById(R.id.buttonDelete);

        etUpdateSinger = (EditText)findViewById(R.id.editTextUpdateSinger);
        etUpdateTitle = (EditText)findViewById(R.id.editTextUpdateTitle);
        etUpdateYear = (EditText)findViewById(R.id.editTextUpdateYear);

        tvId = (TextView)findViewById(R.id.textViewId);

        rgUpdateStars = (RadioGroup)findViewById(R.id.radioGroupUpdateStars) ;

        Intent i = getIntent();
        data = (Song) i.getSerializableExtra("data");

        etUpdateYear.setText(String.valueOf(data.getYear()));
        etUpdateTitle.setText(data.getTitle());
        etUpdateSinger.setText(data.getSinger());

        tvId.setText("ID: " + String.valueOf(data.getId()));

        int editedStars = data.getStars();

        if (editedStars == 1){
            RadioButton one = (RadioButton)findViewById(R.id.radioButton1);
            one.setChecked(true);
        }
        else if (editedStars ==2){
            RadioButton two = (RadioButton)findViewById(R.id.radioButton2);
            two.setChecked(true);
        }
        else if (editedStars ==3){
            RadioButton three = (RadioButton)findViewById(R.id.radioButton3);
            three.setChecked(true);
        }
        else if (editedStars ==4){
            RadioButton four = (RadioButton)findViewById(R.id.radioButton4);
            four.setChecked(true);
        }
        else{
            RadioButton five = (RadioButton)findViewById(R.id.radioButton5);
            five.setChecked(true);
        }

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditActivity.this);
                data.setSinger(etUpdateSinger.getText().toString());
                data.setTitle(etUpdateTitle.getText().toString());
                data.setYear(Integer.parseInt(etUpdateYear.getText().toString()));

                int selectedButtonId = rgUpdateStars.getCheckedRadioButtonId();
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
                data.setStars(starsValue);
                dbh.updateSong(data);
                dbh.close();
                Toast.makeText(EditActivity.this, "Update successful",
                        Toast.LENGTH_SHORT).show();
                Intent i = new Intent(EditActivity.this,
                        ShowList.class);
                startActivity(i);
                finish();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditActivity.this);
                dbh.deleteSong(data.getId());
                dbh.close();
                Intent i = new Intent(EditActivity.this,
                        ShowList.class);
                startActivity(i);
                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(EditActivity.this,
//                        MainActivity.class);
//                startActivity(i);
                finish();
            }
        });

    }
}
