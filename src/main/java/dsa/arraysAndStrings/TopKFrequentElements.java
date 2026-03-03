package dsa.arraysAndStrings;

import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println("Top K Frequent Elements : " + Arrays.toString(topKFrequent(nums, k)));
        System.out.println("Top K Frequent Elements by heap : " + Arrays.toString(topKFrequentByMinHeap(nums, k)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] result = map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(k).map(Map.Entry::getKey).mapToInt(Integer::intValue).toArray();
        return result;
    }

    public static int[] topKFrequentByMinHeap(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums)
            freq.put(num, freq.getOrDefault(num, 0) + 1);

        PriorityQueue<Map.Entry<Integer, Integer>> heap =
                new PriorityQueue<>(Map.Entry.comparingByValue());

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            heap.offer(entry);
            if (heap.size() > k)
                heap.poll();
        }

        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = heap.poll().getKey();
        }
        return res;
    }

}
