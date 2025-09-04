package org.example.splitwise.splitvalidationfactory;

import org.example.splitwise.ExpenseSplitType;
import org.example.splitwise.Split;

import java.util.List;

public interface ExpenseSplitValidation {
    public boolean validateRequest(double amount, List<Split> splits);
}
