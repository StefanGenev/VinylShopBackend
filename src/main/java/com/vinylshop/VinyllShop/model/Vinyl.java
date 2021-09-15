package com.vinylshop.VinyllShop.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Vinyl implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long id;

    private String name;
    private String artist;
    private String genre;
    private String releaseDate;
    private String imgURL;

    public Vinyl(){}

    public Vinyl(String name, String artist, String genre, String releaseDate, String imgURL){
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.imgURL = imgURL;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    @Override
    public String toString() {
        return "vinyl{" +
                "id = " + id +
                "name = " + name +
                "artist = " + artist +
                "genre = " + genre +
                "releaseDate = " + releaseDate +
                "imgURL = " + imgURL;
    }
}
