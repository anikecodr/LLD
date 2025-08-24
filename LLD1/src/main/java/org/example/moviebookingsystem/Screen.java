package org.example.moviebookingsystem;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    int screenNumber;
    List<Seat> seats;

    public Screen(int screenNumber) {
        this.screenNumber = screenNumber;
        this.seats = new ArrayList<>();
    }

    public int getScreenNumber() {
        return screenNumber;
    }

    public void setScreenNumber(int screenNumber) {
        this.screenNumber = screenNumber;
    }

    public List<Seat> getSeats() {
        return seats;
    }


    public void addSeat(Seat seat) {
        this.seats.add(seat);
    }

    public Seat getSeatForASeatNumber (int seatNumber) {
      return  seats.stream().filter(seat -> seat.getSeatNumber() == seatNumber).findFirst().orElse(null);
    }
}
