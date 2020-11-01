package ru.geekbrains.ads.lesson3.queue;

public interface DeQueue<E> extends Queue<E> {
    boolean insertRight(E value);

    E removeLeft();
}
