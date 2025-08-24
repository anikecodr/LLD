package org.example.vendingmachine;

import org.example.vendingmachine.vendingstates.State;

import java.util.List;

public class VendingMachine {
    VendingInventory vendingInventory;
    State vendingMachineState;

    List<Coin> coinList;

    public VendingInventory getVendingInventory() {
        return vendingInventory;
    }

    public void setVendingMachineState(State vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }

    public void setCoinList(List<Coin> coinList) {
        this.coinList = coinList;
    }

    public void addCoin(Coin coin) {
        this.coinList.add(coin);
    }

    public State getVendingMachineState() {
        return vendingMachineState;
    }

    public List<Coin> getCoinList() {
        return coinList;
    }
}
