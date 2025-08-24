package org.example.atm.atmstates;

import org.example.atm.ATM;
import org.example.atm.Card;
import org.example.atm.amountwithdrawal.CashWithdrawalProcessor;
import org.example.atm.amountwithdrawal.FiveHundredWithdrawProcessor;
import org.example.atm.amountwithdrawal.OneHundredWithdrawProcessor;
import org.example.atm.amountwithdrawal.TwoThousandWithdrawalProcessor;

public class CashWithdrawalState extends ATMState {

    @Override
    public void cashWithDrawOperation(ATM atm, Card card, int withdrawAmount) {
        if(atm.getBalance() < withdrawAmount) {
            System.out.println("Insufficient fund");
            exit(atm);
        } else if(card.getBankAccount().getBalance() < withdrawAmount) {
      System.out.println("Insufficient fund in your bank account");
        } else {
            card.getBankAccount().deductBankBalance(withdrawAmount);
            atm.deductATMBalanvce(withdrawAmount);

      // Usinf chain responsiblity for this logic

      CashWithdrawalProcessor withdrawalProcessor =
              new TwoThousandWithdrawalProcessor(
                  new FiveHundredWithdrawProcessor(new OneHundredWithdrawProcessor(null)));
      exit(atm);
        }
    }
}
