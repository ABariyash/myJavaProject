package com.andrey.practical.task9;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        long evenCount = numbers.stream().filter(n -> n % 2 == 0).count();
        System.out.println("Количество четных чисел: " + evenCount);

        List<String> collection = Arrays.asList("Highload", "High", "Load", "Highload");
        long highCount = collection.stream().filter("High"::equals).count();
        System.out.println("Количество 'High' в коллекции: " + highCount);

        String firstElement = collection.stream().findFirst().orElse("0");
        System.out.println("Первый элемент коллекции: " + firstElement);

        String lastElement = collection.isEmpty() ? "0" : collection.get(collection.size() - 1);
        System.out.println("Последний элемент коллекции: " + lastElement);

        List<String> elements = Arrays.asList("f10", "f15", "f2", "f4");
        List<String> sortedElements = elements.stream()
                .sorted(Comparator.comparingInt(e -> Integer.parseInt(e.substring(1))))
                .collect(Collectors.toList());
        System.out.println("Отсортированные элементы: " + sortedElements);

        Collection<Student> students = Arrays.asList(
                new Student("Дмитрий", 17, Gender.MAN),
                new Student("Максим", 20, Gender.MAN),
                new Student("Екатерина", 20, Gender.WOMAN),
                new Student("Михаил", 28, Gender.MAN)
        );

        double avgMaleAge = students.stream()
                .filter(s -> s.getGender() == Gender.MAN)
                .mapToInt(Student::getAge)
                .average()
                .orElse(0);
        System.out.println("Средний возраст студентов мужского пола: " + avgMaleAge);

        List<String> conscriptionRisk = students.stream()
                .filter(s -> s.getGender() == Gender.MAN && s.getAge() >= 18 && s.getAge() <= 27)
                .map(Student::getName)
                .collect(Collectors.toList());
        System.out.println("Студенты, которым грозит повестка: " + conscriptionRisk);

        Scanner scanner = new Scanner(System.in);
        List<String> logins = new ArrayList<>();
        System.out.println("Введите логины (пустая строка для завершения):");
        while (true) {
            String input = scanner.nextLine();
            if (input.isEmpty()) break;
            logins.add(input);
        }

        List<String> filteredLogins = logins.stream()
                .filter(login -> login.startsWith("f"))
                .collect(Collectors.toList());
        System.out.println("Логины, начинающиеся на 'f': " + filteredLogins);
    }

    private enum Gender {
        MAN,
        WOMAN
    }

    private static class Student {
        private final String name;
        private final Integer age;
        private final Gender gender;

        public Student(String name, Integer age, Gender gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public String getName() { return name; }
        public Integer getAge() { return age; }
        public Gender getGender() { return gender; }

        @Override
        public String toString() {
            return "{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender=" + gender +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Student)) return false;
            Student student = (Student) o;
            return Objects.equals(name, student.name) &&
                    Objects.equals(age, student.age) &&
                    gender == student.gender;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, gender);
        }
    }
}