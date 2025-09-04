package org.example.splitwise.splitvalidationfactory;

import org.example.splitwise.ExpenseSplitType;
import org.example.splitwise.Split;

public class SplitValidationFactory {

    private SplitValidationFactory() {}

    public static ExpenseSplitValidation getSplitValidationObject(ExpenseSplitType splitType) {

        if(splitType.equals(ExpenseSplitType.EQUAL)) {
            return new EqualSplitValidation();
        } else if(splitType.equals(ExpenseSplitType.UNEQUAL)){
            return new UnequalSplitValidation();
        } else if(splitType.equals(ExpenseSplitType.PERCENTAGE)){
            return new PercentageSplitValidation();
        } else return  null;
    }
}
