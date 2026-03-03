package practice.cache;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TTLCache<K, V> {
    static class Node<K, V> {
        K key;
        V value;
        long timeStamp;

        Node(K key, V value, long timeStamp) {
            this.key = key;
            this.value = value;
            this.timeStamp = timeStamp;
        }
    }

    private static final int TTL_SECONDS = 5;
    private final Map<K, Node<K, V>> map;
    private final PriorityQueue<Node<K, V>> heap;

    public TTLCache() {
        this.map = new HashMap<>();
        this.heap = new PriorityQueue<>(Comparator.comparingLong(a -> a.timeStamp));
    }

    public void put(K key, V value, long now) {
        evictExpired(now);
        long expiry = now + TTL_SECONDS;
        Node<K, V> newNode = new Node<>(key, value, expiry);
        map.put(key, newNode);
        heap.offer(newNode);
    }

    public V get(K key, long now) {
        evictExpired(now);
        Node<K, V> current = map.get(key);
        return current == null ? null : current.value;
    }

    private void evictExpired(long now) {
        while (!heap.isEmpty() && heap.peek().timeStamp <= now) {
            Node<K, V> expired = heap.poll();
            Node<K, V> current = map.get(expired.key);
            if (expired == current) {
                map.remove(expired.key);
            }
        }
    }

    public static void main(String[] args) {
        TTLCache<String, Long> ttlCache = new TTLCache<>();
        ttlCache.put("A", 1L, 100);
        ttlCache.put("B", 1L, 100);
        ttlCache.put("A", 1L, 104);

        System.out.println(ttlCache.get("A", 110));
    }
}
