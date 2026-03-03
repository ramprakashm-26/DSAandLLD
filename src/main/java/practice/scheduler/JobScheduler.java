package practice.scheduler;

import java.util.Comparator;
import java.util.PriorityQueue;

public class JobScheduler {

    static class Job {
        long executionTime;
        Runnable task;

        Job(long executionTime, Runnable task) {
            this.executionTime = executionTime;
            this.task = task;
        }
    }

    private final PriorityQueue<Job> minHeap = new PriorityQueue<>
            (Comparator.comparingLong(a -> a.executionTime));

    public JobScheduler() {
        Thread thread = new Thread(this::runWorker);
        thread.setDaemon(true);
        thread.start();
    }

    public synchronized void schedule(long now, Runnable task) {
        long executionTime = System.currentTimeMillis() + now * 1000;
        minHeap.offer(new Job(executionTime, task));
        notify();
    }

    private void runWorker() {
        while (true) {
            synchronized (this) {
                try {
                    while (minHeap.isEmpty()) {
                        wait();
                    }
                    long now = System.currentTimeMillis();
                    Job job = minHeap.peek();
                    long waitTime = job.executionTime - now;
                    if (waitTime > 0) {
                        wait(waitTime);
                    } else {
                        minHeap.poll();
                        job.task.run();
                    }
                } catch (InterruptedException ignored) {}
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        JobScheduler scheduler = new JobScheduler();
        System.out.println("Start time: " + System.currentTimeMillis());

        scheduler.schedule(2, () ->
                System.out.println("Task A executed at: " + System.currentTimeMillis()));

        scheduler.schedule(1, () ->
                System.out.println("Task B executed at: " + System.currentTimeMillis()));

        scheduler.schedule(3, () ->
                System.out.println("Task C executed at: " + System.currentTimeMillis()));

        Thread.sleep(5000);
    }
}
