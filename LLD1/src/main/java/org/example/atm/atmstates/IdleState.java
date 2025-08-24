package org.example.atm.atmstates;

import org.example.atm.ATM;
import org.example.atm.Card;

public class IdleState extends ATMState {


    @Override
    public void insertCardOperation(ATM atm, Card card) {
    System.out.println("Card is inserted");
    atm.setAtmState(new HasCardState());
    }

}
