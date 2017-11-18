package com.example.viniciusaudibert.troopersapp.model;

import java.io.Serializable;

/**
 * Created by vinicius.audibert on 18/11/2017.
 */

public class Trooper implements Serializable {

    public static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String imageUrl;
    private String description;
    private Affiliation affiliation;

    public Trooper(Long id, String name, String imageUrl, String description, Affiliation affiliation) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.description = description;
        this.affiliation = affiliation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Affiliation getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(Affiliation affiliation) {
        this.affiliation = affiliation;
    }
}
