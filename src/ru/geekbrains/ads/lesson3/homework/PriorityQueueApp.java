package ru.geekbrains.ads.lesson3.homework;

import ru.geekbrains.ads.lesson3.queue.PriorityQueue;
import ru.geekbrains.ads.lesson3.queue.Queue;
import ru.geekbrains.ads.lesson3.queue.QueueImpl;

import java.util.Scanner;

public class PriorityQueueApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter words: ");
        String lineText = scanner.nextLine();

        Queue<Character> queue = new PriorityQueue<>(lineText.length() + 1);
        for (int i = 0; i < lineText.length(); i++) {
            queue.insert(lineText.charAt(i));
        }
        System.out.print("Result: ");
        while (!queue.isEmpty()) {
            System.out.print(queue.remove()+" ");
        }
    }
}
