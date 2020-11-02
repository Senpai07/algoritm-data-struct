package ru.geekbrains.ads.lesson3.queue;

public interface DeQueue<E> extends Queue<E> {
    boolean insertRight(E value);
    boolean insertLeft(E value);

    E removeLeft();
    E removeRight();
}
