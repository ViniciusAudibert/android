package com.example.viniciusaudibert.starwars.business.person;

/**
 * Created by vinicius.audibert on 18/11/2017.
 */

public class Person {
    public Person(Long id, String name, int imageSrc) {
        this.id = id;
        this.name = name;
        this.imageSrc = imageSrc;
    }

    private Long id;
    private String name;
    private int imageSrc;
}
