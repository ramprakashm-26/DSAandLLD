package practice.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LRUCache {
    static class Node {
        int key;
        int value;
        Node next;
        Node previous;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final Lock lock = new ReentrantLock();
    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.previous = head;
    }

    public int get(int key) {
        lock.lock();
        try {
            if (!map.containsKey(key)) {
                return -1;
            }
            Node current = map.get(key);
            moveAfterHead(current);
            return current.value;
        } finally {
            lock.unlock();
        }
    }

    public void put(int key, int value) {
        lock.lock();
        try {
            if (capacity == 0) return;
            if (map.containsKey(key)) {
                Node current = map.get(key);
                current.value = value;
                removeNode(current);
                moveAfterHead(current);
                return;
            }
            if (map.size() == capacity) {
                Node lru = tail.previous;
                removeNode(lru);
                map.remove(lru.key);
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            moveAfterHead(newNode);
        } finally {
            lock.unlock();
        }
    }

    private void removeNode(Node current) {
        current.previous.next = current.next;
        current.next.previous = current.previous;
        current.next = null;
        current.previous = null;
    }

    private void moveAfterHead(Node current) {
        current.next = head.next;
        current.previous = head;
        head.next.previous = current;
        head.next = current;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
    }
}
