package org.example.auction;

public class AuctionDemo {


        public static void main(String[] args) {
            Seller seller = new Seller(1, "AniketSeller");
            Auction auction = new Auction(101, seller, "MacBook Pro", 500);

            Bidder bidder1 = new Bidder(21, "Aniket");
            Bidder bidder2 = new Bidder(31, "Aman");

            auction.addObserver(bidder1);
            auction.addObserver(bidder2);

            auction.placeBid(new Bid(bidder1, 600));
            auction.placeBid(new Bid(bidder2, 550)); // too low
            auction.placeBid(new Bid(bidder2, 700));
        }
    }


