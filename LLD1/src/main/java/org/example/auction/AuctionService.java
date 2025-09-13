package org.example.auction;

import org.example.auction.AuctionObservable;
import org.example.auction.AuctionObserver;
import org.example.auction.Bid;
import org.example.auction.Seller;

import java.util.ArrayList;
import java.util.List;

class Auction implements AuctionObservable {
    private final int auctionId;
    private final Seller seller;
    private final String item;
    private int currentBid;
    private List<Bid> bidHistory;
    private List<AuctionObserver> observers;

    public Auction(int auctionId, Seller seller, String item, int startPrice) {
        this.auctionId = auctionId;
        this.seller = seller;
        this.item = item;
        this.currentBid = startPrice;
        this.bidHistory = new ArrayList<>();
        this.observers = new ArrayList<>();
        System.out.println("🎉 Auction started for: " + item + " | Starting Price: " + startPrice);
    }

    public int getCurrentBid() { return currentBid; }
    public String getItem() { return item; }

    @Override
    public void addObserver(AuctionObserver obs) {
        observers.add(obs);
    }

    @Override
    public void removeObserver(AuctionObserver obs) {
        observers.remove(obs);
    }

    @Override
    public void notifyAllObservers() {
        for (AuctionObserver obs : observers) {
            obs.onUpdate(currentBid);
        }
    }

    public void placeBid(Bid bid) {
        if (bid.getAmount() > currentBid) {
            currentBid = bid.getAmount();
            bidHistory.add(bid);
            System.out.println("✅ New bid placed: " + bid.getAmount() + " by " + bid.getBidder().getUsername());
            notifyAllObservers();
        } else {
            System.out.println("❌ Bid too low from " + bid.getBidder().getUsername() + ": " + bid.getAmount());
        }
    }
}
