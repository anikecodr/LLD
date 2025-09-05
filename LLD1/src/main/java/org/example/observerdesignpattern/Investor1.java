package org.example.observerdesignpattern;

public class Investor1 implements Observer{
    @Override
    public void update(int price) {
    System.out.println("Investor1: The price of stock is " + price);
    }
}
