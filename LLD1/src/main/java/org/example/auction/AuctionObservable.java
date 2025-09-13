package org.example.auction;

import org.example.observerdesignpattern.Observer;

public interface AuctionObservable {
    void addObserver(AuctionObserver obs);
    void removeObserver(AuctionObserver obs);
    void notifyAllObservers();
}

