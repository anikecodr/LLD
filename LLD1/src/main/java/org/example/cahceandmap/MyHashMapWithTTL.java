package org.example.cahceandmap;

public class MyHashMapWithTTL<K, V> {

    private final Entry<K, V>[] map;
    private final int size;

    // Inner class for Entry
    private static class Entry<K, V> {
        K key;
        V value;
        long expiryTime; // when the key should expire
        Entry<K, V> next;

        public Entry(K key, V value, long ttlMillis) {
            this.key = key;
            this.value = value;
            this.expiryTime = System.currentTimeMillis() + ttlMillis;
            this.next = null;
        }

        boolean isExpired() {
            return System.currentTimeMillis() > expiryTime;
        }
    }

    public MyHashMapWithTTL(int size) {
        this.size = size;
        this.map = new Entry[size];
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % size;
    }

    // ✅ PUT with TTL
    public void put(K key, V value, long ttlMillis) {
        int index = getIndex(key);
        Entry<K, V> newEntry = new Entry<>(key, value, ttlMillis);

        if (map[index] == null) {
            map[index] = newEntry;
            return;
        }

        Entry<K, V> curr = map[index];
        while (true) {
            if (curr.key.equals(key)) {
                curr.value = value;
                curr.expiryTime = System.currentTimeMillis() + ttlMillis;
                return;
            }
            if (curr.next == null) {
                curr.next = newEntry;
                return;
            }
            curr = curr.next;
        }
    }

    // ✅ GET with expiration check
    public V get(K key) {
        int index = getIndex(key);
        Entry<K, V> curr = map[index];

        while (curr != null) {
            if (curr.key.equals(key)) {
                if (curr.isExpired()) {
                    remove(key);
                    return null;
                }
                return curr.value;
            }
            curr = curr.next;
        }
        return null;
    }

    // ✅ REMOVE
    public void remove(K key) {
        int index = getIndex(key);
        Entry<K, V> curr = map[index];
        Entry<K, V> prev = null;

        while (curr != null) {
            if (curr.key.equals(key)) {
                if (prev == null) map[index] = curr.next;
                else prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    // Simple test
    public static void main(String[] args) throws InterruptedException {
        MyHashMapWithTTL<String, String> cache = new MyHashMapWithTTL<>(5);

        cache.put("user1", "Aniket", 3000); // expires in 3s
        System.out.println("user1 -> " + cache.get("user1"));

        Thread.sleep(4000); // wait 4s
        System.out.println("user1 after 4 sec -> " + cache.get("user1"));

        cache.put("user2", "Priya", 2000);
        System.out.println("user2 -> " + cache.get("user2"));
    }
}
