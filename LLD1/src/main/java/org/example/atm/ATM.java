package org.example.atm;

import org.example.atm.atmstates.ATMState;
import org.example.atm.atmstates.IdleState;

public class ATM {

    private static ATM atmObject = new ATM();

    ATMState atmState;

    int balance;

    int noOfTwoThousandNotes;
    int noOfFiveHundredNotes;
    int noOfOneHundredNotes;

    private ATM() {}

//    public ATM(ATMState atmState, int balance, int noOfTwoThousandNotes, int noOfFiveHundredNotes, int noOfOneHundredNotes) {
//        this.atmState = atmState;
//        this.balance = balance;
//        this.noOfTwoThousandNotes = noOfTwoThousandNotes;
//        this.noOfFiveHundredNotes = noOfFiveHundredNotes;
//        this.noOfOneHundredNotes = noOfOneHundredNotes;
//    }

    public static ATM getATMObject() {
        atmObject.setAtmState(new IdleState());
        return atmObject;
    }

    public void setAtmState(ATMState atmState) {
        this.atmState = atmState;
    }

    public ATMState getAtmState() {

        return atmState;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setBalance(int balance, int noOfTwoThousandNotes, int noOfFiveHundredNotes, int noOfOneHundredNotes) {
        this.balance = balance;
        this.noOfTwoThousandNotes = noOfTwoThousandNotes;
        this.noOfFiveHundredNotes = noOfFiveHundredNotes;
        this.noOfOneHundredNotes = noOfOneHundredNotes;
    }

    public int getNoOfTwoThousandNotes() {
        return noOfTwoThousandNotes;
    }

    public void setNoOfTwoThousandNotes(int noOfTwoThousandNotes) {
        this.noOfTwoThousandNotes = noOfTwoThousandNotes;
    }

    public int getNoOfFiveHundredNotes() {
        return noOfFiveHundredNotes;
    }

    public void setNoOfFiveHundredNotes(int noOfFiveHundredNotes) {
        this.noOfFiveHundredNotes = noOfFiveHundredNotes;
    }

    public int getNoOfOneHundredNotes() {
        return noOfOneHundredNotes;
    }

    public void setNoOfOneHundredNotes(int noOfOneHundredNotes) {
        this.noOfOneHundredNotes = noOfOneHundredNotes;
    }

    public void deductTwoThousandNotes(int required) {
        this.noOfTwoThousandNotes = this.noOfTwoThousandNotes - required;
    }

    public void deductFiveHundredNotes(int required) {
        this.noOfFiveHundredNotes = this.noOfFiveHundredNotes - required;
    }


    public void deductOneHundredNotes(int required) {
        noOfOneHundredNotes = noOfOneHundredNotes - required;
    }

    public void printCurrentATMStatus(){
        System.out.println("Balance: " + balance);
        System.out.println("2kNotes: " + noOfTwoThousandNotes);
        System.out.println("500Notes: " + noOfFiveHundredNotes);
        System.out.println("100Notes: " + noOfOneHundredNotes);

    }


    public void deductATMBalanvce(int withdrawAmount) {
        atmObject.balance = atmObject.balance - withdrawAmount;
    }
}
