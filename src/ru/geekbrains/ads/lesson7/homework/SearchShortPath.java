package ru.geekbrains.ads.lesson7.homework;

import ru.geekbrains.ads.lesson7.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SearchShortPath {
    public static void main(String[] args) {

        Graph graph = new Graph(10);
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Рязань");
        graph.addVertex("Калуга");
        graph.addVertex("Липецк");
        graph.addVertex("Тамбов");
        graph.addVertex("Орел");
        graph.addVertex("Саратов");
        graph.addVertex("Курск");
        graph.addVertex("Воронеж");

        graph.addEdges("Москва", "Тула", "Рязань", "Калуга");
        graph.addEdges("Тула", "Липецк");
        graph.addEdges("Рязань", "Тамбов");
        graph.addEdges("Калуга", "Орел");
        graph.addEdges("Тамбов", "Саратов");
        graph.addEdges("Воронеж", "Липецк", "Саратов", "Курск");

        graph.searchPath("Москва", "Воронеж");
        graph.searchPath("Москва", "Тамбов");
        graph.searchPath("Тула", "Курск");
    }




}
