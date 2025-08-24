package org.example.moviebookingsystem;

import java.util.ArrayList;
import java.util.List;

public class Show {
    int showId;
    Movie movie;
    int startTime;
    Screen screen;
    List<Seat> bookingSeatIds;

    public Show(int showId, Movie movie, int startTime, Screen screen) {
        this.showId = showId;
        this.movie = movie;
        this.startTime = startTime;
        this.screen = screen;
        this.bookingSeatIds = new ArrayList<>();
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public List<Seat> getBookingSeatIds() {
        return bookingSeatIds;
    }

    public void addBookingSeat(Seat bookingSeat) {
        this.bookingSeatIds.add(bookingSeat);
    }


}
