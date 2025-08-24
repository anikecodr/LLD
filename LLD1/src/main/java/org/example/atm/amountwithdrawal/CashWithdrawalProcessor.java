package org.example.atm.amountwithdrawal;

import org.example.atm.ATM;

public abstract class CashWithdrawalProcessor {

    CashWithdrawalProcessor next;

    public CashWithdrawalProcessor(CashWithdrawalProcessor next) {
        this.next = next;
    }

    public void withdraw(ATM atm, int withdramount) {

        if(next != null) {
            next.withdraw(atm, withdramount);
        }
    }
}
