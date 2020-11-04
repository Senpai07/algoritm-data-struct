package ru.geekbrains.ads.lesson4;

import java.util.Iterator;
import java.util.Optional;

public class SimpleLinkedListImpl<E> implements LinkedList<E> {

    protected int size;

    protected Node<E> firstElement;

    private class SimpleLinkedListIterator<E> implements Iterator<E> {

        private Node<E> current;

        @Override
        public boolean hasNext() {
            if(current == null){
                current = (Node<E>) firstElement;
                return Optional.ofNullable(current).isPresent();
            }else{
                current = current.next;
                return Optional.ofNullable(current).isPresent();
            }
        }

        @Override
        public E next() {
            return current.item;
        }
    }

    public Iterator<E> iterator() {
        return new SimpleLinkedListIterator();
    }

    @Override
    public void insertFirst(E value) {
        firstElement = new Node<>(value, firstElement);
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<E> removedNode = firstElement;
        E data = removedNode.item;

        firstElement = firstElement.next;
        removedNode.next = null;
        removedNode.item = null;

        size--;
        return data;
    }

    @Override
    public boolean remove(E value) {
        Node<E> current = firstElement;
        Node<E> previous = null;
        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        }
        if (current == firstElement) {
            firstElement = firstElement.next;
        } else {
            previous.next = current.next;
        }
        current.next = null;
        current.item = null;
        size--;
        return true;
    }

    @Override
    public boolean contains(E value) {
        Node<E> current = firstElement;
        while (current != null) {
            if (current.item.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void display() {
        System.out.println("-------------");
        Node<E> current = firstElement;
        while (current != null) {
            System.out.println(current.item);
            current = current.next;
        }
        System.out.println("-------------");
    }

    @Override
    public E getFirst() {
        return firstElement.item;
    }
}
