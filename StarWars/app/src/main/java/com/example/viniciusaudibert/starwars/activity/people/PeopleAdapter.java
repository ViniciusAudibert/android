package com.example.viniciusaudibert.starwars.activity.people;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.viniciusaudibert.starwars.R;
import com.example.viniciusaudibert.starwars.business.person.Person;

import java.util.List;

/**
 * Created by vinicius.audibert on 18/11/2017.
 */

public class PeopleAdapter extends RecyclerView.Adapter<PersonHolder> {
    private List<Person> listPeople;

    public PeopleAdapter(List<Person> listPeople) {
        this.listPeople = listPeople;
    }

    @Override
    public PersonHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_people_list, parent, false);

        return new PersonHolder(v);
    }

    @Override
    public void onBindViewHolder(PersonHolder holder, int position) {
        Person person = listPeople.get(position);
        holder.setPerson(person);
    }

    @Override
    public int getItemCount() {
        return listPeople.size();
    }
}
