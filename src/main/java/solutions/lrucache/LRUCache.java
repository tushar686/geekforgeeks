package solutions.lrucache;

import java.util.*;

public class LRUCache {
    class Node {
        int key;
        int val;
        Node next;
        Node prev;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node head;
    Node end;
    Map<Integer, Node> maps = new HashMap<>();
    int capacity;

    LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public void set(int key, int val) {
        if (maps.containsKey(key)) {
            Node node = maps.get(key);
            moveFirst(node);
            node.val = val;
            return;
        } 

        if (this.maps.size() >= this.capacity) {
            int lastNodeKey = this.end.key;
            this.removeLast();
            this.maps.remove(lastNodeKey);
        }

        Node node = new Node(key, val);
        insertIntoQueue(node);        
        maps.put(key, node);
    }

    private void moveFirst(Node node) {
        remove(node);
        insertIntoQueue(node);
    }

    private void removeLast() {
        this.remove(this.end);
    }

    private void remove(Node node) {
        if (this.head == null || node == null) {
            return;
        }
        if (this.head == this.end && this.head == node) {
            this.head = null;
            this.end = null;
            return;
        }

        if (this.head == node) {
            this.head.next.prev = null;
            this.head = this.head.next;
            return;
        }  
        if (this.end == node) {
            this.end.prev.next = null;
            this.end = this.end.prev;
            return;
        } 
        
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertIntoQueue(Node node) {
        node.next = null;
        node.prev = null;
        if (this.head == null) {
            this.head = node;
            this.end = node;
            return;
        } 
            this.head.prev = node;
            node.next = this.head;
            this.head = node;
    }
    
    public int get(int key) {
        if (maps.containsKey(key)) {
            Node node = maps.get(key);
            moveFirst(node);
            return node.val;
        }
        return -1;
    }
    
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(7);
        lruCache.set(1, 2);
        lruCache.set(2, 3);
        lruCache.set(3, 5);
        lruCache.set(4, 5);
        lruCache.set(6, 7);
        lruCache.set(5, 8);
        lruCache.set(92, 1);
        lruCache.set(95, 1);
        lruCache.set(42, 1);
        lruCache.set(72, 1);

        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(1));
    }
}