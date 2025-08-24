package org.example.moviebookingsystem;

import org.example.moviebookingsystem.constant.SeatCategory;

public class Seat {
    int seatNumber;
    SeatCategory seatCategory;

    public Seat(int seatNumber, SeatCategory category, int price) {
        this.seatNumber = seatNumber;
        this.seatCategory = category;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    int price;

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

}
