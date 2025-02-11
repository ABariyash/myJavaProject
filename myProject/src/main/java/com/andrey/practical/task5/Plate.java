package com.andrey.practical.task5;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int amount) {
        if (food >= amount) {
            food -= amount;
            return true;
        }
        return false;
    }

    public void addFood(int amount) {
        food += amount;
        System.out.println("В тарелку добавили " + amount + " еды. Теперь в ней " + food + " еды.");
    }

    public void info() {
        System.out.println("В тарелке осталось " + food + " еды.");
    }
}
