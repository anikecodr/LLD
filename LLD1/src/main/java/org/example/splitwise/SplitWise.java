package org.example.splitwise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitWise {

  public static void main(String[] args) {

    // create user

    User aniket = new User(1, "Aniket");
    User rahul = new User(2, "Rahul");
    User aman = new User(3, "Aman");

    // Expense :  aniket paid 300: spit equally: UI pass like {aniket, 300, {split: aniket: 100,
    // rahul:100, aman: 100}

    List<Split> splits;
    splits = Arrays.asList(new Split(aniket, 100), new Split(rahul, 100), new Split(rahul, 100));

    // create Expense Controller:

    BalanceSheetController balanceSheetController = new BalanceSheetController();
    ExpenseControlller expenseControlller = new ExpenseControlller(balanceSheetController);
    Expense expense =
        expenseControlller.createExpenseAndUpdateBalanceSheet(
            "Aniket Spend on Biryani", 300, aniket, ExpenseSplitType.EQUAL, splits);

    // update expense in balance sheet controller;

    for (UserBalanceSheet userBalanceSheet :
        balanceSheetController.userUserBalanceSheets.values()) {
      System.out.println(userBalanceSheet.toString());
    }
  }
    }
