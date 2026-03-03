import java.util.Comparator;
import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Test medianFinder = new Test();
        medianFinder.addNum(1);
        medianFinder.addNum(15);
        medianFinder.addNum(3);
        medianFinder.addNum(5);
        medianFinder.addNum(7);
        System.out.println("Median: " + medianFinder.findMedian());
    }

    PriorityQueue<Integer> lowerHeap = new PriorityQueue<>(Comparator.reverseOrder());
    PriorityQueue<Integer> upperHeap = new PriorityQueue<>();

    private void addNum(int num) {
        lowerHeap.offer(num);
        upperHeap.offer(lowerHeap.poll());
        if (lowerHeap.size() < upperHeap.size()) {
            lowerHeap.offer(upperHeap.poll());
        }
    }

    private double findMedian() {
        if (lowerHeap.size() > upperHeap.size()) {
            return lowerHeap.peek();
        }
        return (lowerHeap.peek() + upperHeap.peek()) / 2.0;
    }

}
