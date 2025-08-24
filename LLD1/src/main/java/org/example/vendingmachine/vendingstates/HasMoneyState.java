package org.example.vendingmachine.vendingstates;

import org.example.vendingmachine.Coin;
import org.example.vendingmachine.Item;
import org.example.vendingmachine.VendingMachine;

import java.util.List;

public class HasMoneyState implements State{

    public HasMoneyState() {
    System.out.println("Currently vending machine is in HasMoneyState");
    }
    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception {
        return;
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
    System.out.println("Currently vending machine is at Has Money State and inserting coin");
    vendingMachine.addCoin(coin);
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine vendingMachine) throws Exception {
    System.out.println("currently vending machine is at Has Money State, moving to product selection state");
    vendingMachine.setVendingMachineState(new SelectionState());
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, int code) throws Exception {
    throw  new Exception("You need to click on the start proudct selection button");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("You cannot get change at has money state");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
    System.out.println("Refund the full amount back to dispenser tray");
    List<Coin> coinList = vendingMachine.getCoinList();
    vendingMachine.setVendingMachineState(new IdleState());
    return coinList;
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int code) throws Exception {
        return null;
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {

    }
}

