package ru.geekbrains.ads.lesson3.homework;

import ru.geekbrains.ads.lesson3.stack.Stack;
import ru.geekbrains.ads.lesson3.stack.StackImpl;

import java.util.Scanner;

public class ReverseOutput {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter words: ");
        String lineText = scanner.nextLine();

        Stack<Character> stack = new StackImpl<>(lineText.length() + 1);
        for (int i = 0; i < lineText.length(); i++) {
            stack.push(lineText.charAt(i));
        }
        System.out.print("Result: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
