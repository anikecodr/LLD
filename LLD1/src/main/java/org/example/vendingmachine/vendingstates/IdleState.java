package org.example.vendingmachine.vendingstates;

import org.example.vendingmachine.Coin;
import org.example.vendingmachine.Item;
import org.example.vendingmachine.VendingMachine;
import org.example.vendingmachine.VendingStates;

import java.util.ArrayList;
import java.util.List;

public class IdleState implements State {

    public IdleState() {
    System.out.println("Currently vending machine is in idle state");
    }

    public IdleState(VendingMachine vendingMachine) {
    System.out.println("Currently vending machine is in idle state");
    vendingMachine.setCoinList(new ArrayList<>());
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception {
        System.out.println("---State changed to insert coin from idle state :: Now you can insert coin");
        vendingMachine.setVendingMachineState(new HasMoneyState());
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
     throw new Exception("Current State is Idle, you can perform this operation directly from this state");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Current State is Idle, you can perform this operation directly from this state");
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, int code) throws Exception {
        throw new Exception("Current State is Idle, you can perform this operation directly from this state");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("Current State is Idle, you can perform this operation directly from this state");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Current State is Idle, you can perform this operation directly from this state");
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int code) throws Exception {
        throw new Exception("Current State is Idle, you can perform this operation directly from this state");
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
        throw new Exception("Current State is Idle, you can perform this operation directly from this state");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
