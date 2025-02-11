package com.andrey.practical.task5;

public class Cat extends Animal{

    private static int catCount = 0;
    private boolean satiety;
    private int foodRequired;

    public Cat(String name, int foodRequired) {
        super(name, 200, 0);
        catCount++;
        this.satiety = false;
        this.foodRequired = foodRequired;
    }

    public void eat(Plate plate) {
        if (plate.decreaseFood(foodRequired)) {
            satiety = true;
            System.out.println(getName() + " покушал и теперь сыт.");
        } else {
            System.out.println(getName() + " не смог покушать, в тарелке мало еды.");
        }
    }

    public static int getCatCount() {
        return catCount;
    }

    public boolean isSatiety() {
        return satiety;
    }
}
