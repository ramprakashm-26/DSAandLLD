package org.dsa.slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class SlidingWindowAverage {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, -1, -3, 5, 3, 6, 7);
        int window = 3;
        System.out.println("Normal Sliding Window: " + averageSlidingWindow(list, window));
        System.out.println("Streams Sliding Window: " + averageSlidingWindowUsingStreams(list, window));
    }

    //sliding window
    private static List<Double> averageSlidingWindow(List<Integer> list, int window) {
        final List<Double> result = new ArrayList<>(list.size() / window);
        int sum = 0;
        for (int left = 0, right = 0; right < list.size(); right++) {
            sum += list.get(right);
            if (right - left + 1 >= window) {
                result.add((double) sum / window);
                sum -= list.get(left++);
            }
        }
        return result;
    }

    private static List<Double> averageSlidingWindowUsingStreams(List<Integer> list, int window) {
        return IntStream.range(0, list.size() - (window - 1)).mapToObj(i -> list.subList(i, i + window))
                .peek(l -> System.out.println(l))
                .map(s -> s.stream().mapToInt(Integer::intValue).average().orElse(0.0))
                .toList();
    }
}
