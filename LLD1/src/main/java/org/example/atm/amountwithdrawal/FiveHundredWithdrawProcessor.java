package org.example.atm.amountwithdrawal;


import org.example.atm.ATM;

public class FiveHundredWithdrawProcessor extends CashWithdrawalProcessor{

    public FiveHundredWithdrawProcessor(CashWithdrawalProcessor nextCashWithdrawProcessor){
        super(nextCashWithdrawProcessor);
    }

    public void withdraw(ATM atm, int remainingAmount){

        int required =  remainingAmount/500;
        int balance = remainingAmount%500;

        if(required <= atm.getNoOfFiveHundredNotes()) {
            atm.deductFiveHundredNotes(required);
        }
        else if(required > atm.getNoOfFiveHundredNotes()) {
            atm.deductFiveHundredNotes(atm.getNoOfFiveHundredNotes());
            balance = balance + (required-atm.getNoOfFiveHundredNotes()) * 500;
        }

        if(balance != 0){
            super.withdraw(atm, balance);
        }
    }
}
