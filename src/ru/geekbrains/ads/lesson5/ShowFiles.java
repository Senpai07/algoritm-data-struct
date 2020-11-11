package ru.geekbrains.ads.lesson5;

import java.io.File;
import java.util.Objects;

public class ShowFiles {

    public static void main(String[] args) {
        File root = new File("c:\\Users\\OKrylov\\Google Диск\\GeekBrains\\Java. Уровень 3\\");
        viewDir("", root);
    }

    private static void viewDir(String prefix, File root) {
        if (root.isFile()) {
            System.out.println(prefix + "File: " + root.getName());
        }
        else {
            System.out.println(prefix + "Dir: " + root.getName());
            for (File file : Objects.requireNonNull(root.listFiles())) {
                viewDir(prefix + "  ", file);
            }
        }
    }
}
