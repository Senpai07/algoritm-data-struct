package ru.geekbrains.ads.lesson5;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class Anagram {

    private final char[] chars;
    private String word;
    private Set<String> anagramms = new LinkedHashSet<>();

    public Anagram(String word) {
        this.word = word;
        this.chars = word.toCharArray();
    }

    public static void main(String[] args) {
        Anagram anagramApp = new Anagram("mouse");
        Collection<String> words = anagramApp.getAnagram();
        System.out.println(words.size());
        for (String word : words) {
            System.out.println(word);
        }

    }

    private Collection<String> getAnagram() {
        anagramms.clear();
        processAnagram(word.length());
        return anagramms;
    }

    private void processAnagram(int length) {
        if (length == 1) {
            return;
        }

        for (int i = 0; i < length; i++) {
            processAnagram(length - 1);
            anagramms.add(String.valueOf(chars));
            rotate(length);
        }
    }

    private void rotate(int length) {
        int pos = word.length() - length;
        char temp = chars[pos];
        for (int i = pos + 1; i < chars.length; i++) {
            chars[i - 1] = chars[i];
        }
        chars[chars.length - 1] = temp;
    }
}
