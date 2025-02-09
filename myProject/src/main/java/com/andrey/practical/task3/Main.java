package com.andrey.practical.task3;

public class Main {
    public static void main(String[] args) {

        System.out.println(isSumInRange(5, 10));
        checkNumberSign(5);
        checkNumberSign(-3);
        System.out.println(isNegative(-10));
        repeatString("Hello", 3);
        System.out.println(isLeapYear(2024));
        replaceZeros();
        fillArray();
        modifyArray();
        createDiagonalMatrix(5);
        int[] arr = createArray(5, 7);
        for (int num : arr) System.out.print(num + " ");
    }

    public static boolean isSumInRange(int a, int b) {
        int sum = a + b;
        if (sum >= 10 && sum <= 20) {
            return true;
        } else {
            return false;
        }
    }

    public static void checkNumberSign(int number) {
        if (number >= 0) {
            System.out.println("Число " + number + " является положительным.");
        } else {
            System.out.println("Число " + number + " является отрицательным.");
        }
    }

    public static boolean isNegative(int number) {
        if (number < 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void repeatString(String str, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }
    }

    public static boolean isLeapYear(int year) {
        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
            return true;
        } else {
            return false;
        }
    }

    public static void replaceZeros() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0};
        for (int i : arr) {
            if (arr[i] == 0) {
                arr[i] = 1;
            }
        }
    }

    public static void fillArray() {
        int[] arr = new int[100];
        for (int i : arr) {
            arr[i] = i + 1;
        }
    }

    public static void modifyArray() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i : arr) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
    }

    public static void createDiagonalMatrix(int size) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i][i] = 1;
            matrix[i][size - i - 1] = 1;
        }
    }

    // 10. Создание массива заданной длины и заполнение initialValue
    public static int[] createArray(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i : arr) {
            arr[i] = initialValue;
        }
        return arr;
    }
}

