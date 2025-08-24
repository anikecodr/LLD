package org.example.vendingmachine.vendingstates;

import org.example.vendingmachine.Coin;
import org.example.vendingmachine.Item;
import org.example.vendingmachine.VendingMachine;

import java.util.List;

public class SelectionState implements State{

    public SelectionState() {
    System.out.println("Currently in selection state");
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception {
    System.out.println("You cannot click on the insert coin button");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {

    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine vendingMachine) throws Exception {

    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, int code) throws Exception {

        //1. Get item of this codeNumber
       // Item item = ve

    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        return 0;
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        return null;
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int code) throws Exception {
        return null;
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {

    }
}
