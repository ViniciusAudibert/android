package com.example.viniciusaudibert.starwars.activity.people;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.viniciusaudibert.starwars.business.person.Person;

/**
 * Created by vinicius.audibert on 18/11/2017.
 */

public class PersonHolder extends RecyclerView.ViewHolder {
    private Person person;

    public PersonHolder(View view) {
        super(view);
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
