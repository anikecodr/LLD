package org.example.moviebookingsystem;

import org.example.moviebookingsystem.constant.City;

import java.util.*;

public class TheaterController {
    Map<City, List<Theater>> cityVsTheaters;
    List<Theater> allTheaters;

    public TheaterController() {
        this.cityVsTheaters = new HashMap<>();
        this.allTheaters = new ArrayList<>();
    }

    public void addTheater(Theater theater) {
        this.allTheaters.add(theater);

    }
    public void mapTheaterToCity(City city, Theater theater) {
        List<Theater> theaterList = cityVsTheaters.getOrDefault(city, new ArrayList<>());
        theaterList.add(theater);
        cityVsTheaters.put(city, theaterList);
    }

    public List<Theater> getAllTheaters() {
        return allTheaters;
    }

    public void setAllTheaters(List<Theater> allTheaters) {
        this.allTheaters = allTheaters;
    }

    public List<Theater> getTheaterForCity(City city) {
        return cityVsTheaters.getOrDefault(city, Collections.emptyList());
    }

}
