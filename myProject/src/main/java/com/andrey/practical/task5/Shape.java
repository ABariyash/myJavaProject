package com.andrey.practical.task5;

public interface Shape {

    double getPerimeter();
    double getArea();

    default void printDetails() {
        System.out.println("Периметр: " + getPerimeter());
        System.out.println("Площадь: " + getArea());
    }
}
