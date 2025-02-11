package com.andrey.practical.task4;

class Person {
    private String fullName;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Person(String fullName, String position, String email, String phone, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void displayInfo() {
        System.out.println("ФИО: " + fullName + ", Должность: " + position + ", Email: " + email + ", Телефон: " + phone + ", Зарплата: " + salary + ", Возраст: " + age);
    }

    public int getAge() {
        return age;
    }
}
