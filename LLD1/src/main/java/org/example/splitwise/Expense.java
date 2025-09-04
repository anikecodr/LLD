package org.example.splitwise;

import java.util.ArrayList;
import java.util.List;

public class Expense {

    String expenseId;
    String expenseDescription;

    double expAmount;

    User paidByUser;

    ExpenseSplitType splitType;

    List<Split> splitDetails = new ArrayList<>();

    public Expense(String expenseId, String expenseDescription, double expAmount, User paidByUser, ExpenseSplitType splitType, List<Split> splitDetails) {
        this.expenseId = expenseId;
        this.expenseDescription = expenseDescription;
        this.expAmount = expAmount;
        this.paidByUser = paidByUser;
        this.splitType = splitType;
        this.splitDetails = splitDetails;
    }
}
