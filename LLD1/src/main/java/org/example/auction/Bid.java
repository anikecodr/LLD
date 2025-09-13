package org.example.auction;

import java.util.Date;

public class Bid {
    private final Bidder bidder;
    private final int amount;
    private final Date timestamp;

    public Bid(Bidder bidder, int amount) {
        this.bidder = bidder;
        this.amount = amount;
        this.timestamp = new Date();
    }

    public Bidder getBidder() { return bidder; }
    public int getAmount() { return amount; }
    public Date getTimestamp() { return timestamp; }
}
