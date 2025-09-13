package org.example.cahceandmap;

public class MyHashMap<K, V> {

    private final Entry<K,V>[] map;
    int size;
    private static class Entry<K, V> {
        K key;
        V value;


        Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public MyHashMap(int size) {
        this.size = size;
        this.map = new Entry[size];
    }

    private V get(K key) {

        int index = key.hashCode() % size;

        if(map[index] == null) return null;

        Entry curr = map[index];

        while(curr != null) {
            if(curr.key.equals(key)) return (V)curr.value;
            else curr = curr.next;
        }

        return null;
    }


    private void put(K key, V value) {

        int index = key.hashCode() % size;

        if(map[index] == null) {
            map[index] = new Entry<>(key, value);
        } else {
            Entry curr = map[index];

            while(curr != null) {
                if(curr.key == key) {
                    curr.value = value;
                    break;
                } else if(curr.next == null) {
                    curr.next = new Entry(key, value);
                    break;
                } else {
                    curr = curr.next;
                }
            }
        }
    }




}
