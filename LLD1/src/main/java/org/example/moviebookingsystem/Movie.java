package org.example.moviebookingsystem;


public class Movie {
    String movieName;
    int durationInMins;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getDurationInMins() {
        return durationInMins;
    }

    public void setDurationInMins(int durationInMins) {
        this.durationInMins = durationInMins;
    }

    public Movie(String movieName, int durationInMins) {
        this.movieName = movieName;
        this.durationInMins = durationInMins;
    }
}
