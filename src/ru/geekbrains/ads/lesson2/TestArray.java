package ru.geekbrains.ads.lesson2;

public class TestArray {

    public static final int INITIAL_CAPACITY = 100000;

    public static void main(String[] args) {
//        testDynamicArray();
        testBigArray();
    }

    private static void testDynamicArray() {
        Array<Integer> data = new ArrayImpl<>(4);
//        Array<Integer> data = new SortedArrayImpl<>(4);
        data.add(5);
        data.add(4);
        data.add(3);
        data.add(2);
        data.add(1);

        data.display();
//        data.sortBubble();
//        data.sortSelect();
        data.sortInsert();
        data.display();

//        data.remove(Integer.valueOf(3));
        data.remove(2);
        data.insert(3, 2);
        data.display();

        System.out.println("data[1] = " + data.get(1));
        System.out.println("Find 2: " + data.contains(2));
        System.out.println("Find 222: " + data.contains(222));
    }

    private static void testBigArray() {
        Array<Integer> data = new ArrayImpl<>(INITIAL_CAPACITY);
        Array<Integer> data1 = new ArrayImpl<>(INITIAL_CAPACITY);
        Array<Integer> data2 = new ArrayImpl<>(INITIAL_CAPACITY);
        Array<Integer> data3 = new ArrayImpl<>(INITIAL_CAPACITY);
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            data.add((int) (Math.random() * 100000));
        }

//        System.out.println(Arrays.toString(((ArrayImpl<Integer>) data).data));
//        System.arraycopy(((ArrayImpl<Integer>) data).data, 0, ((ArrayImpl<Integer>) data1).data, 0, data.size());
        for (int i = 0; i < data.size(); i++) {
            data1.add(data.get(i));
        }
        for (int i = 0; i < data.size(); i++) {
            data2.add(data.get(i));
        }
        for (int i = 0; i < data.size(); i++) {
            data3.add(data.get(i));
        }

        long before = System.currentTimeMillis();
        data1.sortBubble();
        long after = System.currentTimeMillis();
        System.out.println("Время исполнения сортировки пузырьком = " + (after - before) + " мс.");
        before = System.currentTimeMillis();
        data2.sortInsert();
        after = System.currentTimeMillis();
        System.out.println("Время исполнения сортировки вставками = " + (after - before) + " мс.");
        before = System.currentTimeMillis();
        data3.sortSelect();
        after = System.currentTimeMillis();
        System.out.println("Время исполнения сортировки выбором = " + (after - before) + " мс.");

    }
}
