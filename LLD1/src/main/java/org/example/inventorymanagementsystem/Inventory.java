package org.example.inventorymanagementsystem;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Inventory {

    private final Map<String, Integer> stock = new ConcurrentHashMap<>();

    public void addItem(String item, int quantity) {
       int oldQuantity = stock.getOrDefault(item, 0);
       stock.put(item, oldQuantity+ quantity);
    }

    public boolean removeItem(String item, int quantity) {
        return true;
    }
}
