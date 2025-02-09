package com.andrey.lesson.lesson3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(summ(5, 5));
        printSomeText ();
        printMyText ("Java");

        int x = 10;
        if(x == 10) {
            int y = 20;
            System.out.println("x & y: " + x + " " + y);
            x = y * 2;
        }
        System.out.println("x: " + x);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Сколько процентов заряда батареи осталось на вашем смартфоне?");
        int a = scanner.nextInt();
        if (a < 10) {
            System.out.println("Осталось менее 10 процентов, подключите ваш смартфон к зарядному устройству");
        }

        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Сколько процентов заряда батареи осталось на вашем смартфоне?");
        int b = scanner1.nextInt();
        if (b < 10) {
            System.out.println("Осталось менее 10 процентов, подключите ваш смартфон к зарядному устройству");
        } else {
            System.out.println("Заряда вашей батареи достаточно для того, чтобы прочитать статью на JavaRush");
        }

        int s = 3;
        if (s == 1) {
            System.out.println("s = 1");
        } else if (s == 3) {
            System.out.println("s = 3");
        } else {
            System.out.println("Ни одно из условий не сработало");
        }

        int d = 3;
        switch (d) {
            case 1:
                System.out.println("a = 1");
                break;
            case 3:
                System.out.println("a = 3");
                break;
            default:
                System.out.println("Ни один из case не сработал");
        }

        for (int i = 5; i < 5; i++) {
            System.out.println("i = " + i);
        }
        System.out.println("end");

        for (int i = 0, j = 10; i < j; i++, j--) {
            System.out.println("i-j: " + i + "-" + j);
        }

        for (int i = 0; i < 10; i++) {
            if (i > 3) {
                break;
            }
            System.out.println("i = " + i);
        }

        String[] sm = {"A", "B", "C", "D"};
        for (String o : sm) {
            System.out.print(o + " ");
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + i + j );
            }
        }

        int[] arr = new int[5];
        for (int i = 0; i <5; i++) {
            arr[i] = i;
            System.out.println("arr[" + i + "] = " + arr[i]);
        }

        int[] nums = new int[4];
        nums[0] = 5;
        nums[1] = 10;
        nums[2] = 15;
        nums[3] = 15;

        int[] nums1 = { 5, 10, 15, 20};

        String[] arr1 = {"A", "B", "C", "D"};
        System.out.println(Arrays.toString(arr1));

        int[] [] table = new  int[10] [20];


        int counter = 1;
        int[][] table1 = new int[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                table1[i][j] = counter;
                System.out.print(table1[i][j] + " ");
                counter++;
            }
            System.out.println();
        }

        int[] arr3 = {2, 4, 5, 1, 2, 3, 4, 5};
        System.out.println("arr.length: " + arr3.length);

        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + " ");
        }
    }

    public static int summ(int a, int b) {
        return a + b;
    }

    public static void printSomeText() {
        System.out.println("Hello");
    }

    public static void printMyText(String txtToPrint) {
        System.out.println(txtToPrint);
    }
}
