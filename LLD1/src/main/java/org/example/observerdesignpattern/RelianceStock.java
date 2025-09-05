package org.example.observerdesignpattern;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RelianceStock implements Obserable{

    int price;

    List<Observer> observers;

    public RelianceStock(int price) {
        this.price = price;
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyAllObserver() {

        for (Observer observer: observers) {
            observer.update(this.price);
        }
    }

    @Override
    public void updateStockPrice(int price) {
        this.price = price;
    System.out.println("Reliance price update");
    notifyAllObserver();
    }
}
