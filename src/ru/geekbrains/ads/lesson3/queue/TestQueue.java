package ru.geekbrains.ads.lesson3.queue;

public class TestQueue {

    public static void main(String[] args) {
        testQueue();
        testPriorityQueue();
    }

    private static void testQueue() {
        Queue<Integer> queue = new QueueImpl<>(5);
        System.out.println("testQueue:");
        testBody(queue);
    }

    private static void testBody(Queue<Integer> queue) {
        System.out.println(queue.insert(5));
        System.out.println(queue.insert(1));
        System.out.println(queue.insert(3));
        System.out.println(queue.insert(6));
        System.out.println(queue.insert(2));
        System.out.println(queue.insert(4));

        System.out.println("Queue size = " + queue.size());
        System.out.println("Queue peek = " + queue.peekHead());
        System.out.println("Queue is full = " + queue.isFull());

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }

    private static void testPriorityQueue() {
        Queue<Integer> queue = new PriorityQueue<>(5);
        System.out.println("testPriorityQueue:");
        testBody(queue);
    }
}
