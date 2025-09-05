package org.example.observerdesignpattern;

public interface Obserable {
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);

    public void notifyAllObserver();

    public void updateStockPrice(int price);
}
