package ru.geekbrains.ads.lesson8;

public class LinkedHashTableImpl<K, V> implements HashTable<K, V> {

    private final int maxSize;

    static class Node<K, V> implements Entry<K, V> {

        private final K key;
        private V value;
        private Node<K, V> next;

        Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        public Node<K, V> getNext() {
            return next;
        }

        public void setNext(Node<K, V> node) {
            this.next = node;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private final Node<K, V>[] data;
    private int size;

    public LinkedHashTableImpl(int maxSize) {
        this.maxSize = maxSize;
        this.data = new Node[this.maxSize * 2];
    }

    @Override
    public boolean put(K key, V value) {
        int index = hash(key);

        if (size == maxSize) {
            return false;
        }

        if (data[index] != null) {
            Node<K, V> node = data[index];
            if (node.key.equals(key)) {
                node.setValue(value);
                return true;
            }
            while (node.getNext() != null) {
                node = node.getNext();
                if (node.key.equals(key)) {
                    node.setValue(value);
                    return true;
                }
            }
            Node<K, V> newNode = new Node<>(key, value, null);
            node.setNext(newNode);
            return true;
        }

        data[index] = new Node<>(key, value, null);
        size++;

        return true;
    }

    private int hash(K key) {
        return key.hashCode() % data.length;
    }

    @Override
    public V get(K key) {
        return valueOf(key);
    }

    private V valueOf(K key) {
        int index = hash(key);

        if (data[index] != null) {
            Node<K, V> node = data[index];
            if (node.key.equals(key)) {
                return node.getValue();
            }
            while (node.getNext() != null) {
                node = node.getNext();
                if (node.key.equals(key)) {
                    return node.getValue();
                }
            }
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int index = hash(key);

        if (data[index] != null) {
            Node<K, V> node = data[index];
            if (node.key.equals(key)) {
                data[index] = node.getNext();
                return node.getValue();
            }
            while (node.getNext() != null) {
                Node<K, V> parentNode = node;
                node = node.getNext();
                if (node.key.equals(key)) {
                    parentNode.setNext(node.getNext());
                    return node.getValue();
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println("----------");
        for (int i = 0; i < data.length; i++) {
            Node<K, V> node = data[i];
            System.out.printf("%d = [%s]", i, node);
            if (node != null) {
                while (node.getNext() != null) {
                    node = node.getNext();
                    System.out.printf(", [%s]", node);
                }
            }
            System.out.println();
        }
        System.out.println("----------");
    }
}
