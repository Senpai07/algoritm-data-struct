package ru.geekbrains.ads.lesson2;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class TestArray {

    public static final int INITIAL_CAPACITY = 100_000;

    public static void main(String[] args) throws InterruptedException {
//        testDynamicArray();
        testBigArray();
        testBigArrayInThreads();
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
        data.sortBubble();
        data.sortSelect();
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
//        System.arraycopy(data.toArray(), 0, data1.toArray(), 0, data.size());
//        System.arraycopy(data.toArray(), 0, data2.toArray(), 0, data.size());
//        System.arraycopy(data.toArray(), 0, data3.toArray(), 0, data.size());
        for (int i = 0; i < data.size(); i++) {
            data1.add(data.get(i));
            data2.add(data.get(i));
            data3.add(data.get(i));
        }
//        printArrays(data1, data2, data3);

        long before = System.currentTimeMillis();
        data1.sortBubble();
        long after = System.currentTimeMillis();
        System.out.println("Время исполнения сортировки пузырьком = " + (after - before) + " мс.");
//        printArrays(data1, data2, data3);
        before = System.currentTimeMillis();
        data3.sortSelect();
        after = System.currentTimeMillis();
        System.out.println("Время исполнения сортировки выбором = " + (after - before) + " мс.");
//        printArrays(data1, data2, data3);
        before = System.currentTimeMillis();
        data2.sortInsert();
        after = System.currentTimeMillis();
        System.out.println("Время исполнения сортировки вставками = " + (after - before) + " мс.");
//        printArrays(data1, data2, data3);
    }

    @SafeVarargs
    private static void printArrays(Array<Integer>... arrays) {
        int numbArray = 0;
        for (Array<Integer> array : arrays) {
            System.out.println("data" + ++numbArray + ": " + Arrays.toString(array.toArray()));
        }
    }


    private static void testBigArrayInThreads() throws InterruptedException {
        Supplier<Array<Integer>> constructor = ArrayImpl::new;
//        Supplier<Array<Integer>> constructor = SortedArrayImpl::new;

        Array<Integer> data1 = createArray(constructor);
        Array<Integer> data2 = createArray(constructor);
        Array<Integer> data3 = createArray(constructor);

        randomInitialize(data1, data2, data3);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Runnable> tasks = List.of(
                measureTime(data3::sortInsert, "Sort Insert"),
                measureTime(data2::sortSelect, "Sort Select"),
                measureTime(data1::sortBubble, "Sort Bubble")
        );

        tasks.forEach(executorService::execute);

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);

//        System.out.println("Bubble: " + Arrays.toString(data1.toArray()));
    }

    private static Runnable measureTime(Runnable action, String actionName) {
        return () -> {
            long startTime = System.nanoTime();
            action.run();
            long finishTime = System.nanoTime();
            long duration = finishTime - startTime;
            System.out.printf("%s took time: %d micros.%n", actionName, TimeUnit.NANOSECONDS.toMillis(duration));
        };
    }

    private static Array<Integer> createArray(Supplier<Array<Integer>> factory) {
        return factory.get();
    }

    @SafeVarargs
    private static void randomInitialize(Array<Integer>... arrays) {
        Random random = new Random();
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            int value = random.nextInt(INITIAL_CAPACITY);
            for (Array<Integer> array : arrays) {
                array.add(value);
            }
        }
    }
}
