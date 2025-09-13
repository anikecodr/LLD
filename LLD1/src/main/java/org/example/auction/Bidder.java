package org.example.auction;

class Bidder extends User implements AuctionObserver {
    public Bidder(int userId, String username) {
        super(userId, username);
    }

    @Override
    public void onUpdate(int bidPrice) {
        System.out.println("📢 " + username + " notified: Current highest bid = " + bidPrice);
    }
}

