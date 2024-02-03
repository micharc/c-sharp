package JavaAPI.lesson3.task1;

import java.util.Arrays;

/**
 * Внутри класса MergeSort напишите метод mergeSort,
 * который принимает массив целых чисел, реализует
 * алгоритм сортировки слиянием.
 * Метод должен возвращать отсортированный массив.
 */

class MergeSort {
    public static int[] mergeSort(int[] mas) {
        // Напишите свое решение ниже
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
                    break;
                }
            }
        return mas;
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer31{
    public static void main (String[] args) {
        int[] a;

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            a = new int[] {15, 1, 9, 20, 3, 14};
        } else {
            a = Arrays.stream(args[0].split(", ")).mapToInt(Integer::parseInt).toArray();
        }

        MergeSort answer = new MergeSort();
        String itresume_res = Arrays.toString(answer.mergeSort(a));
        System.out.println(itresume_res);
    }
}