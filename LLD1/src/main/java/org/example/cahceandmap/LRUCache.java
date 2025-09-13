package org.example.cahceandmap;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    private static class Node<K,V> {
        K key;
        V value;
        Node<K,V> prev, next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    private static class LinkedList<K, V> {

        Node<K, V> head;
        Node<K, V> tail;
        int size;
        LinkedList() {
            head = new Node<>(null, null);
            tail = new Node<>(null, null);
            head.next = tail;
            tail.prev = head;
            this.size = 0;
        }

        public void remove(Node node) {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            size--;
        }

        public Node removeLast() {
            Node last = tail.prev;
            last.prev.next = tail;
            tail.prev = last.prev;
            size--;
            return  last;
        }

        public void addFirst(Node node) {
            Node next = head.next;
            head.next = node;
            node.prev = head;
            node.next = next;
            next.prev = node;
            size++;
        }

        public Node getLast() {
            return tail.prev;
        }

        public int size() {
            return size;
        }
    }
    LinkedList<Integer, Integer> list;
    Map<Integer, Node<Integer, Integer>> map;
    int capacity;
    public LRUCache(int capacity) {
        this.list = new LinkedList<>();
        this.map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {

        if(map.containsKey(key)) {
            Node node = map.get(key);
            list.remove(node);
            list.addFirst(node);
            return (int)node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {

        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            list.remove(node);
            list.addFirst(node);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            list.addFirst(node);
        }

        if(list.size() > capacity) {
            Node node = list.removeLast();
            map.remove(node.key);
        }

    }

    public static void main(String[] args){
    System.out.println("Hi");
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
