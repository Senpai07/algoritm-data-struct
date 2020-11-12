package ru.geekbrains.ads.lesson5.homework;

import java.util.ArrayList;

public class Backpack {
    public static int targetWeight = 20;
    public static int[] items = {21, 9, 17, 3, 11};
    public static int startIndex = 0;

    public static void main(String[] args) {
        for (int j : items) {
            System.out.print(j + " ");
        }

        System.out.println();
        System.out.println("---------------------------");


        ArrayList<Integer> resultItems = backpack(targetWeight, startIndex);
        System.out.println("Решение:");
        for (Integer item : resultItems) {
            System.out.print(item + " ");
        }
    }

    public static ArrayList<Integer> backpack(int pack, int startIndex) {
        for (int i = startIndex; i < items.length; i++) {
            int item = items[i];

            if (startIndex == items.length - 1) {
                return new ArrayList<>();
            } else if (item > pack) {
                continue;
            } else if (item == pack) {
                ArrayList<Integer> resultItems = new ArrayList<>();
                resultItems.add(item);
                return resultItems;
            }

            ArrayList<Integer> resultItems = backpack(pack - item, i + 1);
            if (!resultItems.isEmpty()) {
                resultItems.add(item);
                return resultItems;
            }
        }

        return new ArrayList<>();
    }
}