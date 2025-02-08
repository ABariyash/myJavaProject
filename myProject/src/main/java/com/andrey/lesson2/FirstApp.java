package com.andrey.lesson2;

/**
 * First JAVA program.
 */

public class FirstApp {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        final int t = 20;
        float u;
        u = 2.25f;

        float radius = 2.0f, height = 10.0f;
        float volume = 3.1416f * radius * radius * height;
        System.out.println("Объем цилиндра равен " + volume);

        int x,y,z;
        x = y = z = 10;
        float d = 2.2f, e = 7.2f;

        int q  = 10;
        int w = 20;
        int r = (q + w - 5) * 2;
        System.out.println("r = " + r);

        int a = 10;
        a++;
        a--;
        a += 10;
        a *= 2;
        a /= 4;
        int b = a + 4;
        System.out.println("b = " + b);

        int c;
        int f;
        c = 128;
        System.out.println("c = " + c);
        f = c / 2;
        System.out.println("f = c / 2 = " + f);
    }
}
