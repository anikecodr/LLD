package org.example.moviebookingsystem;

public class Payment {
    int paymentId;
    String paymentType;

    int amount;

    public Payment(int paymentId, String paymentType, int amount) {
        this.paymentId = paymentId;
        this.paymentType = paymentType;
        this.amount = amount;
    }
}
