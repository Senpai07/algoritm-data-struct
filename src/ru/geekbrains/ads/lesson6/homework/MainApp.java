package ru.geekbrains.ads.lesson6.homework;

import ru.geekbrains.ads.lesson6.Node;
import ru.geekbrains.ads.lesson6.Tree;
import ru.geekbrains.ads.lesson6.TreeImpl;

import java.util.Random;

public class MainApp {

    public static void main(String[] args) {
        Random random = new Random();
        int balancedCnt = 0;
        int treeCount = 20;
        int maxLevel = 4;
        int nodeCount = (int) (Math.pow(2, maxLevel) - 1);

        int maxValue = 25;

        for (int i = 0; i < treeCount; i++) {
            Tree<Integer> theTree = new TreeImpl<>(maxLevel);
            fillTree(random, nodeCount, maxValue, theTree);
            if (theTree.isBalanced()) {
                balancedCnt++;
                theTree.display();
            }
        }


        System.out.println("Balanced: " + balancedCnt);
        System.out.println("Balanced: " + (balancedCnt / (treeCount * 1.0)) * 100 + "%");

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

    private static void fillTree(Random rand, int nodeCount, int maxValue, Tree<Integer> theTree) {
        for (int j = 0; j < nodeCount; j++) {
            theTree.add(rand.nextInt(maxValue * 2 + 1) - maxValue);// [-25; 25]
        }
    }
}
