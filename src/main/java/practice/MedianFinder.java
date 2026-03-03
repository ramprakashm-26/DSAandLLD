package practice;

import java.util.PriorityQueue;

class MedianFinder {
    private final PriorityQueue<Integer> lowerHeap;
    private final PriorityQueue<Integer> upperHeap;
    public MedianFinder() {
        lowerHeap = new PriorityQueue<>((a, b) -> b - a);
        upperHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        lowerHeap.offer(num);
        upperHeap.offer(lowerHeap.poll());
        if (upperHeap.size() > lowerHeap.size()) {
            lowerHeap.offer(upperHeap.poll());
        }
    }

    public double findMedian() {
        if (lowerHeap.size() > upperHeap.size()) {
            return lowerHeap.peek();
        }
        return (lowerHeap.peek() + upperHeap.peek()) / 2.0;
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(15);
        medianFinder.addNum(3);
        medianFinder.addNum(5);
        System.out.println("Median: " + medianFinder.findMedian());
    }
}
