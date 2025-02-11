package com.andrey.practical.task4;

public class Main {
    public static void main(String[] args) {
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Иванов Иван", "Инженер", "ivanov@mail.com", "89231231234", 50000, 45);
        persArray[1] = new Person("Петров Петр", "Менеджер", "petrov@mail.com", "89235678900", 60000, 30);
        persArray[2] = new Person("Сидорова Анна", "Директор", "sidorova@mail.com", "89239876543", 90000, 50);
        persArray[3] = new Person("Кузнецов Олег", "Программист", "kuznetsov@mail.com", "89236754321", 80000, 28);
        persArray[4] = new Person("Морозова Елена", "Бухгалтер", "morozova@mail.com", "89234561234", 55000, 42);

        for (Person emp : persArray) {
            if (emp.getAge() > 40) {
                emp.displayInfo();
            }
        }
    }
}