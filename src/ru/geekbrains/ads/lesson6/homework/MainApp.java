package ru.geekbrains.ads.lesson6.homework;

import ru.geekbrains.ads.lesson6.Node;
import ru.geekbrains.ads.lesson6.TreeImpl;

import java.util.concurrent.ThreadLocalRandom;

public class MainApp {

    public static void main(String[] args) {
        int balancedCnt = 0;
        int unbalancedCnt = 0;

        for (int i = 1000; i > 0; i--) {
            TreeImpl<Integer> tree = new TreeImpl<>();
            fillTree(tree);
            tree.display();
            if (isBalanced(tree.getRoot())) {
                balancedCnt++;
            } else {
                unbalancedCnt++;
            }
        }
        System.out.println("Not balanced: " + unbalancedCnt);
        System.out.println("Balanced: " + balancedCnt);

    }

    public static boolean isBalanced(Node node) {
        return (node == null) ||
                isBalanced(node.getLeftChild()) &&
                        isBalanced(node.getRightChild()) &&
                        Math.abs(height(node.getLeftChild()) - height(node.getRightChild())) <= 1;
    }

    private static int height(Node node) {
        return node == null ? 0 : 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }

    private static void fillTree(TreeImpl<Integer> tree) {
        while (tree.size() <= 15) {
            tree.add(ThreadLocalRandom.current().nextInt(-25, 25));
        }
    }
}
