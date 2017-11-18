package com.example.viniciusaudibert.starwars.activity.people;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.viniciusaudibert.starwars.R;
import com.example.viniciusaudibert.starwars.business.person.Person;

import java.util.Arrays;
import java.util.List;

public class PeopleActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);

        TextView title = findViewById(R.id.toolbar_title);
        title.setText(R.string.people_title);

        setPeopleList();
    }

    private void setPeopleList() {
        mRecyclerView = findViewById(R.id.people_list);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new PeopleAdapter(getDataSetMock());
        mRecyclerView.setAdapter(mAdapter);
    }

    private List<Person> getDataSetMock() {
        return Arrays.asList(
                new Person(1L, "Luke Skywalker", R.drawable.luke),
                new Person(2L, "Obi-wan", R.drawable.obi_wan),
                new Person(3L, "Hans Solo", R.drawable.hans_solo),
                new Person(4L, "Lando", R.drawable.lando),
                new Person(5L, "Padmé", R.drawable.padme),
                new Person(6L, "Boba Fett", R.drawable.boba_fett)
        );
    }
}
