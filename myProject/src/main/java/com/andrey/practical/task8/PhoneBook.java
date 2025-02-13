package com.andrey.practical.task8;

import java.util.*;

class PhoneBook {

    private final Map<String, Set<String>> phoneBook;

    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    public void add(String surname, String phoneNumber) {
        phoneBook.computeIfAbsent(surname, k -> new HashSet<>()).add(phoneNumber);
    }

    public Set<String> get(String surname) {
        return phoneBook.getOrDefault(surname, Collections.emptySet());
    }
}
