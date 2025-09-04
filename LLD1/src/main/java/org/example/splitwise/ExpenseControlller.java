package org.example.splitwise;

import org.example.splitwise.splitvalidationfactory.ExpenseSplitValidation;
import org.example.splitwise.splitvalidationfactory.SplitValidationFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExpenseControlller {
  List<Expense> expenses = new ArrayList<>();
  BalanceSheetController balanceSheetController;

  public ExpenseControlller(BalanceSheetController balanceSheetController) {
    this.expenses = new ArrayList<>();
    this.balanceSheetController = balanceSheetController;
  }

  // Create a expense
  public Expense createExpenseAndUpdateBalanceSheet(
      String expDes,
      double amount,
      User paidByUser,
      ExpenseSplitType splitType,
      List<Split> splits) {

    // Validate the request;
    ExpenseSplitValidation expenseSplitValidation =
        SplitValidationFactory.getSplitValidationObject(splitType);
    assert expenseSplitValidation != null;
    if (!expenseSplitValidation.validateRequest(amount, splits)) {
      System.out.println("The given splits are incorrect!");
    }

    Expense aniketExpense =
        new Expense("exp1", expDes, 300, paidByUser, ExpenseSplitType.EQUAL, splits);
    expenses.add(aniketExpense);

    updateBalanceSheet(amount, paidByUser, splits);

    return aniketExpense;
  }

  public void updateBalanceSheet(double amount, User paidByUser, List<Split> splits) {
    Map<User, UserBalanceSheet> balanceSheetMap = balanceSheetController.userUserBalanceSheets;

    for (Split split : splits) {

      if (split.user.equals(paidByUser)) {
        UserBalanceSheet userBalanceSheet =
            balanceSheetMap.getOrDefault(split.user, new UserBalanceSheet(0, 0, 0, 0));

        userBalanceSheet.totalExpense = userBalanceSheet.totalExpense + split.amountOwe;
        userBalanceSheet.totalGetBack = userBalanceSheet.totalGetBack + (amount - split.amountOwe);
        userBalanceSheet.totalPayment = userBalanceSheet.totalPayment + amount;
        balanceSheetMap.put(split.user, userBalanceSheet);
      } else {

          UserBalanceSheet userBalanceSheet =
                  balanceSheetMap.getOrDefault(split.user, new UserBalanceSheet(0, 0, 0, 0));
          userBalanceSheet.totalExpense = userBalanceSheet.totalExpense + split.amountOwe;
          userBalanceSheet.totalOwe = userBalanceSheet.totalOwe - split.amountOwe;
          balanceSheetMap.put(split.user, userBalanceSheet);
      }
    }
  }
}
