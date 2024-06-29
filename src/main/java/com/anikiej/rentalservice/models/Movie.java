package com.anikiej.rentalservice.models;

import java.io.Serializable;

public class Movie implements Serializable {
    private Long id;
    private String name;
    private Category category;
    private int yearReleased;
    private boolean isAvailable;

    public Movie() {
    }

    public Movie(Long id, String name, Category category, int yearReleased, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.yearReleased = yearReleased;
        this.isAvailable = isAvailable;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getYearReleased() {
        return yearReleased;
    }

    public void setYearReleased(int yearReleased) {
        this.yearReleased = yearReleased;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", yearReleased=" + yearReleased +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
