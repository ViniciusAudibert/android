package com.example.viniciusaudibert.troopersapp.model;

import com.example.viniciusaudibert.troopersapp.R;

/**
 * Created by vinicius.audibert on 18/11/2017.
 */

public enum Affiliation {
    GALATIC_REPUBLIC(0, R.drawable.galactic_republic),
    GALATIC_EMPIRE(1, R.drawable.galactic_empire),
    FIRST_ORDER(2, R.drawable.first_order);

    Affiliation(int value, int image) {
        this.value = value;
        this.image = image;
    }

    private int value;
    private int image;

    public int getValue() {
        return value;
    }

    public int getImage() {
        return image;
    }
}
