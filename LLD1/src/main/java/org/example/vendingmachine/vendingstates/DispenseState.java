package org.example.vendingmachine.vendingstates;

import org.example.vendingmachine.Coin;
import org.example.vendingmachine.Item;
import org.example.vendingmachine.VendingMachine;

import java.util.List;

public class DispenseState implements State{
    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception {

    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {

    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine vendingMachine) throws Exception {

    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, int code) throws Exception {

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
