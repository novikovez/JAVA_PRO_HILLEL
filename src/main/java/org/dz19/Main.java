package org.dz19;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] randomArray = new int[20]; // Создаем массив на 20 элементов
        Random random = new Random();

        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt(100); // Генерируем случайное число от 0 до 99
        }

        int[] sortedArray = ArrayUtils.getMergeSorted(randomArray);
        System.out.println("Sorted Array: " + Arrays.toString(sortedArray));
        System.out.println("Search in Array: " + randomArray[3]);
        System.out.println("Index Search Element: " + ArrayUtils.binarySearch(sortedArray, randomArray[3]));
    }
}
