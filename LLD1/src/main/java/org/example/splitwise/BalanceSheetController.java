package org.example.splitwise;

import java.util.HashMap;
import java.util.Map;

public class BalanceSheetController {
    public  Map<User, UserBalanceSheet> userUserBalanceSheets;

    public BalanceSheetController() {
        userUserBalanceSheets = new HashMap<>();
    }

    public  UserBalanceSheet getUserBalanceSheet(User user) {
        return userUserBalanceSheets.get(user);
    }


}
