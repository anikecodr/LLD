package org.example.splitwise;

import java.util.Map;

public class UserBalanceSheet {

   // Balance friendBalances;

    double totalPayment;
    double totalExpense;

    double totalGetBack;
    double totalOwe;

    public UserBalanceSheet(double totalPayment, double totalExpense, double totalGetBack, double totalOwe) {
        this.totalPayment = totalPayment;
        this.totalExpense = totalExpense;
        this.totalGetBack = totalGetBack;
        this.totalOwe = totalOwe;
    }

    @Override
    public String toString() {
        return "UserBalanceSheet{" +
                "totalPayment=" + totalPayment +
                ", totalExpense=" + totalExpense +
                ", totalGetBack=" + totalGetBack +
                ", totalOwe=" + totalOwe +
                '}';
    }
}
