package ru.geekbrains.ads.lesson5;

import ru.geekbrains.ads.lesson2.Array;

public class TestRecSortedArray {

    public static void main(String[] args) {
        testDynamicArray();
    }
    private static void testDynamicArray() {
        Array<Integer> data = new RecSortedArrayImpl<>(4);
        data.add(5);
        data.add(4);
        data.add(3);
        data.add(2);
        data.add(1);

        data.display();

        System.out.println("data[1] = " + data.get(1));
        System.out.println("Find 2: " + data.contains(2));
        System.out.println("Find 222: " + data.contains(222));
    }

}
