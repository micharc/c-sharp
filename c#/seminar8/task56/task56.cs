namespace GB {

    using System;
    using System.IO;

    class homeTasks {

        private static void PrintTaskDescription () {
            System.Console.WriteLine("\n" +
            "Задача 56: Задайте прямоугольный двумерный массив. Напишите программу,\n" +
            "которая будет находить строку с наименьшей суммой элементов.\n" +
            "\n" +
            "Например, задан массив:\n" +
            "1 4 7 2\n" +
            "5 9 2 3\n" +
            "8 4 2 4\n" +
            "5 2 6 7\n" +
            "Программа считает сумму элементов в каждой строке и выдаёт номер строки с наименьшей суммой элементов:\n" +
            "1 строка\n" +
            "====================================================================================\n");
        }

        private static int[,] FillArray (int columns, int rows, int min, int max) {
            int[,] arr = new int[columns,rows];
            Random rnd = new Random();

            for (int i_c=0; i_c<columns; i_c++) {
                for (int i_r=0; i_r<rows; i_r++) {
                    arr[i_c,i_r] = rnd.Next(min,max);
                }
            }

            return arr;
        }

        private static int FindLineNumberWithSmallestSum (int[,] arr) {
            int temp_sum, min_sum, min_sum_line_number;

            temp_sum = 0;
            for (int i_r=0; i_r<arr.GetLength(1); i_r++) {
                temp_sum += arr[0,i_r];
            }
            min_sum = temp_sum;
            min_sum_line_number = 0;

            for (int i_c=1; i_c<arr.GetLength(0); i_c++) {
                temp_sum = 0;
                for (int i_r=0; i_r<arr.GetLength(1); i_r++) {
                    temp_sum += arr[i_c,i_r];
                }
                if (temp_sum <  min_sum) {
                    min_sum = temp_sum;
                    min_sum_line_number = i_c;
                }
            }

            return min_sum_line_number+1; // converting index number into line number
        }

        private static void PrintIntArray (string message, int[,] arr) {
            System.Console.WriteLine(message);
            for (int i_c=0; i_c<arr.GetLength(0); i_c++) {
                for (int i_r=0; i_r<arr.GetLength(1); i_r++) {
                    System.Console.Write("{0} ",arr[i_c,i_r]);
                }
                System.Console.WriteLine();
            }
            System.Console.WriteLine();
        }

        private static void Main() {

            const int ARRAY_SIZE_ROWS = 5;
            const int ARRAY_SIZE_COLUMNS = 4;
            const int MIN_VALUE = 0;
            const int MAX_VALUE = 10;
            int[,] array = new int[ARRAY_SIZE_COLUMNS, ARRAY_SIZE_ROWS];

            PrintTaskDescription();

            array = FillArray(ARRAY_SIZE_COLUMNS, ARRAY_SIZE_ROWS, MIN_VALUE, MAX_VALUE);

            PrintIntArray("Generated array:",array);

            System.Console.WriteLine("Line with the smallest sum of elements: {0}",FindLineNumberWithSmallestSum(array));
        }
    }
}
