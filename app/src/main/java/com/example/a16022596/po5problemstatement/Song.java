package com.example.a16022596.po5problemstatement;

import java.io.Serializable;

public class Song implements Serializable {
    private int id;
    private String title;
    private String Singer;
    private int year;
    private int stars;

    public Song(int id, String title, String singer, int year, int stars) {
        this.id = id;
        this.title = title;
        Singer = singer;
        this.year = year;
        this.stars = stars;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return Singer;
    }

    public void setSinger(String singer) {
        Singer = singer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
