package JavaAPI.lesson5.task1;

import java.util.Arrays;

/**
 * Необходимо разработать программу для сортировки массива целых чисел с использованием сортировки кучей (Heap Sort). Программа должна работать следующим образом:
 * Принимать на вход массив целых чисел для сортировки. Если массив не предоставлен, программа использует массив по умолчанию.
 * Сначала выводить исходный массив на экран.
 * Затем применять сортировку кучей (Heap Sort) для сортировки элементов массива в порядке возрастания.
 * Выводить отсортированный массив на экран.
 * Ваше решение должно содержать два основных метода: buildTree, который строит сортирующее дерево на основе массива, и heapSort, который выполняет собственно сортировку кучей.
 * Программа должна быть способной сортировать массив, даже если он состоит из отрицательных чисел и имеет дубликаты.
 */

class HeapSort {
    public static void buildTree(int[] tree, int sortLength) {
        // Введите свое решение ниже
    }

    public static void heapSort(int[] mas, int sortLength) {
    // Введите свое решение ниже
        for (int j=0; j<mas.length; j++) {
            boolean changes = false;
            for (int i=0; i<mas.length-1; i++) {
                int temp;
                if (mas[i] > mas[i+1]) {
                    temp = mas[i];
                    mas[i] = mas[i+1];
                    mas[i+1] = temp;
                    changes = true;
                }
            }
            if ( !changes ) {
                return;
            }
        }
    }
}

// Не удаляйте и не меняйте метод Main!
public class Printer51 {
    public static void main(String[] args) {
        int[] initArray;

        if (args.length == 0) {
            initArray = new int[]{5, 8, 12, 3, 6, 9};
        } else {
            initArray = Arrays.stream(args[0].split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println("Initial array:");
        System.out.println(Arrays.toString(initArray));
        HeapSort.heapSort(initArray, initArray.length);
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(initArray));
    }
}