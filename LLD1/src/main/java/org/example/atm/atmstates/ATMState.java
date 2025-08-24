package org.example.atm.atmstates;

import org.example.atm.ATM;
import org.example.atm.Card;
import org.example.atm.TransactionType;

public abstract class ATMState {

    public void insertCardOperation(ATM atm, Card card) {
    System.out.println("Error: Incorrect Operation for the current state");
    }

    public void authenticatePinOperation(ATM atm, Card card, int pin) {
        System.out.println("Error: Incorrect Operation for the current state");

    }

    public void selectionOperation(ATM atm, Card card, TransactionType transactionType) {
        System.out.println("Error: Incorrect Operation for the current state");
    }

    public void cashWithDrawOperation(ATM atm, Card card, int withdrawAmount) {
        System.out.println("Error: Incorrect Operation for the current state");
    }

    public void checkBalanceOperation(ATM atm, Card card) {
        System.out.println("Error: Incorrect Operation for the current state");
    }

    public void returnCard() {
        System.out.println("Error: Incorrect Operation for the current state");
    }

    public void exit(ATM atm) {
        System.out.println("Error: Incorrect Operation for the current state");
    }
}
