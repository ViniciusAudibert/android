package com.example.viniciusaudibert.starwars.activity.peopledetail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.viniciusaudibert.starwars.R;

public class PeopleDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_detail);
        TextView title = findViewById(R.id.toolbar_title);
        title.setText("People");
    }
}
