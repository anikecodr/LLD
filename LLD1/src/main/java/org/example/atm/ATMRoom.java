package org.example.atm;

import org.example.moviebookingsystem.Payment;

public class ATMRoom {

    User user;
    ATM atm;

    public static void main(String[] args){

        ATMRoom atmRoom = new ATMRoom();

        atmRoom.initialize();

        atmRoom.atm.printCurrentATMStatus();
        atmRoom.atm.getAtmState().insertCardOperation(atmRoom.atm, atmRoom.user.card);
        atmRoom.atm.getAtmState().authenticatePinOperation(atmRoom.atm, atmRoom.user.card, 1212);
        atmRoom.atm.getAtmState().selectionOperation(atmRoom.atm, atmRoom.user.card, TransactionType.WITHDRAW);
        atmRoom.atm.getAtmState().cashWithDrawOperation(atmRoom.atm, atmRoom.user.card, 2700);
        atmRoom.atm.printCurrentATMStatus();
    }

    private void  initialize() {

        //create a ATM

        atm = ATM.getATMObject();
        atm.setBalance(3500, 1, 2, 5);

        //create user

        this.user = createUser();


    }

    private User createUser() {
        User user = new User();
        user.setCard(createCard());
        return user;
    }

    private Card createCard() {
        Card card = new Card();
        card.setBankAccount(createBankAccount());
        return card;
    }

    private BankAccount createBankAccount() {
        BankAccount bankAccount = new BankAccount(3000);
        return bankAccount;
    }

}
