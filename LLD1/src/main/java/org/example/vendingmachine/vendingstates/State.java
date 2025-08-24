package org.example.vendingmachine.vendingstates;

import org.example.vendingmachine.*;

import java.util.Collections;
import java.util.List;

public interface State {

    public void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception;
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception;

    public void clickOnStartProductSelectionButton(VendingMachine vendingMachine) throws Exception;
    public void selectProduct(VendingMachine vendingMachine, int code) throws Exception;

    public int getChange(int returnChangeMoney) throws Exception;
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception;

    public Item dispenseProduct(VendingMachine vendingMachine, int code) throws Exception;

    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception;

}
