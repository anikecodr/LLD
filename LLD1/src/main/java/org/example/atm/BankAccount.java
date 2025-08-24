package org.example.atm;

public class BankAccount {

    int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void deductBankBalance(int withdrawAmount) {
        balance = balance - withdrawAmount;
    }
}
