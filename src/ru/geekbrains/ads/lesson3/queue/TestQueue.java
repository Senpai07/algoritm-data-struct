package ru.geekbrains.ads.lesson3.queue;

public class TestQueue {

    public static void main(String[] args) {
        testQueue();
        testPriorityQueue();
        testDeque();
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

    private static void testDeque() {
        System.out.println("testDeque:");
        DeQueue<Integer> deQueue = new DeQueueImpl<>(6);
        insertRight(deQueue, 1);
        insertRight(deQueue, 2);
        insertRight(deQueue, 3);
        insertRight(deQueue, 4);
        insertLeft(deQueue, 5);
        insertLeft(deQueue, 6);

        removeLeft(deQueue);
        removeRight(deQueue);

//        displayRightToLeft(deQueue);
        displayLeftToRight(deQueue);
    }

    private static <E> void displayRightToLeft(DeQueue<E> deQueue) {
        while (!deQueue.isEmpty()) {
            System.out.println(deQueue.removeRight());
        }
    }

    private static <E> void displayLeftToRight(DeQueue<E> deQueue) {
        while (!deQueue.isEmpty()) {
            System.out.println(deQueue.removeLeft());
        }
    }

    private static <E> void removeLeft(DeQueue<E> deQueue) {
        if (!deQueue.isEmpty()) {
            deQueue.removeLeft();
        }
    }

    private static <E> void removeRight(DeQueue<E> deQueue) {
        if (!deQueue.isEmpty()) {
            deQueue.removeRight();
        }
    }

    private static <E> void insertRight(DeQueue<E> deQueue, E value) {
        if (!deQueue.isFull()) {
            deQueue.insertRight(value);
        }
    }

    private static <E> void insertLeft(DeQueue<E> deQueue, E value) {
        if (!deQueue.isFull()) {
            deQueue.insertLeft(value);
        }
    }
}
