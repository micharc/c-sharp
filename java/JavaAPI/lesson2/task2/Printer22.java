/**
 * Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой
 * итерации запишите в лог-файл.
 * Напишите свой код в методе sort класса BubbleSort. Метод sort принимает на вход
 * один параметр:
 * int[] arr - числовой массив
 * После каждого прохода по массиву ваш код должен делать запись в лог-файл 'log.txt'
 * в формате год-месяц-день час:минуты {массив на данной итерации}.
 * Для логирования использовать логгер logger класса BubbleSort.
 *
 * Пример
 * arr = new int[]{9, 4, 8, 3, 1};
 * sort(arr)
 *
 * // При чтении лог-файла получим:
 * 2023-05-19 07:53 [4, 8, 3, 1, 9]
 * 2023-05-19 07:53 [4, 3, 1, 8, 9]
 * 2023-05-19 07:53 [3, 1, 4, 8, 9]
 * 2023-05-19 07:53 [1, 3, 4, 8, 9]
 * 2023-05-19 07:53 [1, 3, 4, 8, 9]
 */

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

import java.text.SimpleDateFormat;
import java.util.Date;

class BubbleSort {
    private static File log;
    private static FileWriter fileWriter;

    public static void sort(int[] mas) {
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
            logger(mas);
            if ( !changes ) {
                break;
            }
        }
    }

    public BubbleSort () {
        File file = new File("log.txt");
        if ( file.exists() && !file.delete()) {
            System.out.println("Can not delete file \"log.txt\"");
        }
    }

    private static void logger (int[] data) {
        String line = "[";

        for (int i=0; i<data.length-1; i++) {
            line = line.concat(Integer.toString(data[i])).concat(", ");
        }
        line = line.concat(Integer.toString(data[data.length-1])).concat("]");

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm ");
        Date date = new Date();
        String buffer = formatter.format(date);
        buffer = buffer.concat(line).concat("\n");
        try {
            FileWriter fileWriter = new FileWriter("log.txt", true);
            fileWriter.append(buffer);
            fileWriter.close();
        }
        catch (Exception e) {
            e.getStackTrace();
        }
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer22 {
    public static void main(String[] args) {
        int[] arr = {};

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            arr = new int[] {9, 3, 4, 8, 2, 5, 7, 1, 6, 10};
        }
        else{
            arr = Arrays.stream(args[0].split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        BubbleSort ans = new BubbleSort();
        ans.sort(arr);

        try (BufferedReader br = new BufferedReader(new FileReader("log.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}