package com.andrey.practical.task8;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String[] words = {"apple", "banana", "orange", "apple", "grape", "banana", "melon", "grape", "apple", "orange"};

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        System.out.println("Уникальные слова и их количество:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "123-456-789");
        phoneBook.add("Петров", "987-654-321");
        phoneBook.add("Иванов", "555-123-456");

        System.out.println("\nТелефоны Иванова: " + phoneBook.get("Иванов"));
        System.out.println("Телефоны Петрова: " + phoneBook.get("Петров"));
    }
}
