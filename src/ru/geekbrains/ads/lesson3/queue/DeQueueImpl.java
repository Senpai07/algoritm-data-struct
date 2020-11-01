package ru.geekbrains.ads.lesson3.queue;

public class DeQueueImpl<E> extends QueueImpl<E> implements DeQueue<E> {
    public DeQueueImpl(int maxSize) {
        super(maxSize);
    }

    @Override
    public boolean insertRight(E value) {
        if (isFull()) {
            return false;
        }
        if (head == DEFAULT_HEAD) {
            head = data.length;
        }

        data[--head] = value;
        size++;
        return true;
    }

    @Override
    public E removeLeft() {
        if (isEmpty()) {
            return null;
        }
        if (tail == DEFAULT_TAIL) {
            tail = data.length - 1;
        }

        E removedValue = data[tail--];
        size--;
        return removedValue;
    }
}
