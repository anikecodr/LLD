package org.example.atm;

import java.util.PrimitiveIterator;

public class Card {

    private int cardNumber;
    private int cvv;

    private String holderName;

    private BankAccount bankAccount;

    static final  int PIN_NUM = 1212;

    public boolean isCorrectPin(int num ) {
        return num == PIN_NUM;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
}
