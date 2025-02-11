package com.andrey.practical.task5;

abstract class ColorShape implements Shape {

    private String fillColor;
    private String borderColor;

    public ColorShape(String fillColor, String borderColor) {
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public void printColors() {
        System.out.println("Цвет заливки: " + fillColor);
        System.out.println("Цвет границы: " + borderColor);
    }
}
