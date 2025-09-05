package org.example.observerdesignpattern;

public class Investor2 implements Observer{
    @Override
    public void update(int price) {
        System.out.println("Investor2: The price of stock is " + price);
    }
}
