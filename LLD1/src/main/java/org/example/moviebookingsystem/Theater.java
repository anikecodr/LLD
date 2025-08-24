package org.example.moviebookingsystem;

import java.util.ArrayList;
import java.util.List;

public class Theater {
    int theaterId;
    String theaterName;

    String address;

    List<Screen> screens;

    List<Show> shows;

    public Theater(int theaterId, String theaterName, String address) {
        this.theaterId = theaterId;
        this.theaterName = theaterName;
        this.address = address;
        this.screens = new ArrayList<>();
        this.shows = new ArrayList<>();
    }

    public int getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void addScreen(Screen screen) {
        this.screens.add(screen);
    }

    public List<Show> getShows() {
        return shows;
    }

    public void addShows(Show show) {
        this.shows.add(show);
    }


}
