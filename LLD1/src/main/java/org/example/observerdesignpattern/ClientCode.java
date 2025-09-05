package org.example.observerdesignpattern;

public class ClientCode {

    public static void main(String[] args){

        //cretae observers;

        Observer investor1 = new Investor1();

        Observer investor2 = new Investor2();

        //create Observable;

        Obserable tataStock= new TataStock(230);
        Obserable reliance = new RelianceStock(790);

        tataStock.registerObserver(investor1);
        tataStock.registerObserver(investor2);

        reliance.registerObserver(investor2);

        tataStock.updateStockPrice(280);

        reliance.updateStockPrice(345);
    }
}
