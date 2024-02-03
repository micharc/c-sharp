package JavaAPI.lesson3.task3;

import java.util.Arrays;
import java.util.ArrayList;

/**
 * Реализуйте метод, который принимает на вход целочисленный массив arr:
 * - Создаёт список ArrayList, заполненный числами из исходого массива arr.
 * - Сортирует список по возрастанию и выводит на экран.
 * - Находит минимальное значение в списке и выводит на экран - Minimum is {число}
 * - Находит максимальное значение в списке и выводит на экран - Maximum is {число}
 * - Находит среднее арифметическое значений списка и выводит на экран - Average is = {число}
 * .
 * Напишите свой код в методе analyzeNumbers класса Answer.
 * Метод analyzeNumbers принимает на вход один параметр:
 * Integer[] arr - массив целых чисел.
 */

class Answer {
    public static void analyzeNumbers(Integer[] mas) {
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
                break;
            }
        }

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(mas));
        System.out.println(list);

        int min, max;
        double avg = 0, sum = 0;
        min = max = list.get(0);

        for (int i = 0; i < list.size(); i++) {

            if (min > list.get(i))
                min = list.get(i);

            if (max < list.get(i))
                max = list.get(i);

            sum += list.get(i);
        }

        avg = sum/list.size();

        System.out.printf("Minimum is %d\n", min);
        System.out.printf("Maximum is %d\n", max);
        System.out.printf("Average is = %.1f\n", avg);
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer33{
    public static void main(String[] args) {
        Integer[] arr = {};

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            arr = new Integer[]{-2, -1, 0, 1, 2, 3, 4, 5};
        }
        else{
            arr = Arrays.stream(args[0].split(", "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
        }

        Answer ans = new Answer();
        ans.analyzeNumbers(arr);
    }
}