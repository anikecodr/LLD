package org.example.inventorymanagementsystem;

import java.util.*;
import java.util.concurrent.*;

// Inventory class
class Inventory {
    private final Map<String, Integer> stock = new ConcurrentHashMap<>();

    public void addItem(String item, int quantity) {
        stock.merge(item, quantity, Integer::sum);
        System.out.println("Added " + quantity + " " + item + ". Current stock: " + stock.get(item));
    }

    public boolean removeItem(String item, int quantity) {
        return stock.compute(item, (k, v) -> {
            if (v == null || v < quantity) return v; // not enough stock
            return v - quantity;
        }) != null;
    }

    public int getStock(String item) {
        return stock.getOrDefault(item, 0);
    }
}

// Request class
class InventoryRequest {
    enum Type { ADD, REMOVE }
    public final Type type;
    public final String item;
    public final int quantity;

    public InventoryRequest(Type type, String item, int quantity) {
        this.type = type;
        this.item = item;
        this.quantity = quantity;
    }
}

// Inventory Manager with queue
class InventoryManager {
    private final Inventory inventory = new Inventory();
    private final BlockingQueue<InventoryRequest> queue = new LinkedBlockingQueue<>();
    private final Thread worker;

    public InventoryManager() {
        worker = new Thread(this::processRequests);
        worker.start();
    }

    public void submitRequest(InventoryRequest request) throws InterruptedException {
        queue.put(request);
    }

    private void processRequests() {
        try {
            while (true) {
                InventoryRequest request = queue.take(); // waits if queue is empty
                switch (request.type) {
                    case ADD -> inventory.addItem(request.item, request.quantity);
                    case REMOVE -> {
                        boolean success = inventory.removeItem(request.item, request.quantity);
                        if (success)
                            System.out.println("Removed " + request.quantity + " " + request.item);
                        else
                            System.out.println("Failed to remove " + request.quantity + " " + request.item + " (insufficient stock)");
                    }
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Inventory manager stopped.");
        }
    }

    public void shutdown() {
        worker.interrupt();
    }
}

// Demo
public class Main {
    public static void main(String[] args) throws InterruptedException {
        InventoryManager manager = new InventoryManager();

        manager.submitRequest(new InventoryRequest(InventoryRequest.Type.ADD, "Apple", 50));
        manager.submitRequest(new InventoryRequest(InventoryRequest.Type.REMOVE, "Apple", 20));
        manager.submitRequest(new InventoryRequest(InventoryRequest.Type.REMOVE, "Apple", 40));
        manager.submitRequest(new InventoryRequest(InventoryRequest.Type.ADD, "Banana", 30));

        // Give some time to process
        Thread.sleep(2000);

        manager.shutdown();
    }
}
