package dz.lesson2;

/*
1. Создать массив большого размера (100000 элементов).
2. Заполнить массив случайными числами.
3. Написать методы, реализующие рассмотренные виды сортировок, и проверить скорость выполнения каждой.
* */

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[100];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }

        System.out.println("Исходный массив:");
        System.out.println(Arrays.toString(arr) + "\n");

        long before = System.nanoTime();
        bubbleSort(arr);
        long after = System.nanoTime();
        System.out.println("Время исполнения (bubbleSort) = " + (after - before) + " мс.\n");

        before = System.nanoTime();
        selectionSort(arr);
        after = System.nanoTime();
        System.out.println("Время исполнения (selectionSort) = " + (after - before) + " мс.\n");

        before = System.nanoTime();
        insertionSort(arr);
        after = System.nanoTime();
        System.out.println("Время исполнения (insertionSort) = " + (after - before) + " мс.\n");
    }

    public static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minInd = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minInd])
                    minInd = j;
            }
            int tmp = arr[i];
            arr[i] = arr[minInd];
            arr[minInd] = tmp;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int val = arr[i];
            int ind = i;

            while (ind > 0 && val < arr[ind - 1]) {
                arr[ind] = arr[ind - 1];
                ind--;
            }

            arr[ind] = val;
        }

        System.out.println(Arrays.toString(arr));
    }
}
