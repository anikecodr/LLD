package org.example.atm.atmstates;

import org.example.atm.ATM;
import org.example.atm.Card;

public class HasCardState extends ATMState{

    @Override
    public void authenticatePinOperation(ATM atm, Card card, int pin) {
        System.out.println("Card Authentication is progress");

        if(card.isCorrectPin(pin)) {
      atm.setAtmState(new SelecOperationState());
        } else {
            System.out.println("Invalid pin");
            exit(atm);
        }
    }

    @Override
    public void returnCard() {
    System.out.println("return card");

    }

    @Override
    public void exit(ATM atm) {
    atm.setAtmState(new IdleState());
    System.out.println("Exit happens");
    }
}
