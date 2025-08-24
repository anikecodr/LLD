package org.example.atm.amountwithdrawal;

import org.example.atm.ATM;

public class TwoThousandWithdrawalProcessor  extends CashWithdrawalProcessor{

    public TwoThousandWithdrawalProcessor(CashWithdrawalProcessor next) {
        super(next);
    }

    @Override
    public void withdraw(ATM atm, int remainingAmount) {

        int required = remainingAmount / 2000;
        int balance = remainingAmount % 2000;

        if(required <= atm.getNoOfTwoThousandNotes()) {
            atm.deductTwoThousandNotes(required);
        }
        else if(required > atm.getNoOfTwoThousandNotes()) {
            atm.deductTwoThousandNotes(atm.getNoOfTwoThousandNotes());
            balance = balance + (required-atm.getNoOfTwoThousandNotes()) * 2000;
        }

        if(balance != 0){
            super.withdraw(atm, balance);
        }


    }
}
