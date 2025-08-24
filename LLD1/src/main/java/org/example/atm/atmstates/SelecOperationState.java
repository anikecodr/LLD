package org.example.atm.atmstates;

import org.example.atm.ATM;
import org.example.atm.Card;
import org.example.atm.TransactionType;

public class SelecOperationState extends ATMState{

    @Override
    public void selectionOperation(ATM atm, Card card, TransactionType transactionType) {

        switch (transactionType)  {
            case WITHDRAW:
                atm.setAtmState(new CashWithdrawalState());
                break;
            case CHECK_BALANCE:
                atm.setAtmState(new CheckBalanceState());
                break;
            default: {
          System.out.println("Invalid option");
          exit(atm);
            }
    }
    }

    @Override
    public void exit(ATM atm) {
        atm.setAtmState(new IdleState());
        System.out.println("Exit happens");
    }
}
