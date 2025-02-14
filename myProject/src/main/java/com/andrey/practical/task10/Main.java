package com.andrey.practical.task10;

public class Main {

    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());

        System.out.println("Вес коробки с яблоками: " + appleBox.getWeight());
        System.out.println("Вес коробки с апельсинами: " + orangeBox.getWeight());
        System.out.println("Коробки равны по весу? " + appleBox.compare(orangeBox));

        Box<Apple> anotherAppleBox = new Box<>();
        appleBox.transferFruitsTo(anotherAppleBox);
        System.out.println("Вес новой коробки с яблоками: " + anotherAppleBox.getWeight());
        System.out.println("Вес старой коробки с яблоками после пересыпки: " + appleBox.getWeight());
    }
}
