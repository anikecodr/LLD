package org.example.moviebookingsystem;

import java.util.LinkedList;
import java.util.List;

public class Booking {
    int bookingId;
    Show show;
    List<Seat> seats;

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", show=" + show +
                ", seats=" + seats +
                ", payment=" + payment +
                '}';
    }

    Payment payment;

    public Booking(int bookingId, Show show, List<Seat> seats) {
        this.bookingId = bookingId;
        this.show = show;
        this.seats = seats;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
