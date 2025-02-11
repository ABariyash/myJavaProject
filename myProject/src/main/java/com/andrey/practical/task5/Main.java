package com.andrey.practical.task5;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Бобик");
        Cat cat1 = new Cat("Барсик", 8);
        Cat cat2 = new Cat("Мурзик", 10);
        Cat cat3 = new Cat("Снежок", 11);

        dog.run(150);
        dog.swim(5);

        cat1.run(100);
        cat1.swim(5);

        Plate plate = new Plate(25);

        Cat[] cats = {cat1, cat2, cat3};
        for (Cat cat : cats) {
            cat.eat(plate);
        }

        for (Cat cat : cats) {
            System.out.println(cat.getName() + " сыт: " + cat.isSatiety());
        }
        plate.info();
        plate.addFood(30);

        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Всего собак: " + Dog.getDogCount());
        System.out.println("Всего котов: " + Cat.getCatCount());

        ColorShape circle = new Circle(5, "Красный", "Черный");
        ColorShape rectangle = new Rectangle(4, 6, "Голубой", "Зеленый");
        ColorShape triangle = new Triangle(3, 4, 5, "Желтый", "Коричневый");

        System.out.println("Круг:");
        circle.printColors();
        circle.printDetails();


        System.out.println("Прямоугольник:");
        rectangle.printColors();
        rectangle.printDetails();


        System.out.println("Треугольник:");
        triangle.printColors();
        triangle.printDetails();
    }
}
