package org.example.splitwise.splitvalidationfactory;

import org.example.splitwise.ExpenseSplitType;
import org.example.splitwise.Split;

import java.util.List;

public class PercentageSplitValidation implements ExpenseSplitValidation{
    @Override
    public boolean validateRequest(double amount, List<Split> splits) {
        return false;
    }
}
