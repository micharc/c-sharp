namespace GB {

    using System;
    using System.IO;

    class homeTasks {

        private static void PrintTaskDescription () {
            System.Console.WriteLine("\n" +
            "Задача 54: Задайте двумерный массив. Напишите программу, которая упорядочит по убыванию\n" +
            "элементы каждой строки двумерного массива.\n" +
            "\n" +
            "Например, задан массив:\n" +
            "1 4 7 2\n" +
            "5 9 2 3\n" +
            "8 4 2 4\n" +
            "\n" +
            "В итоге получается вот такой массив:\n" +
            "7 4 2 1\n" +
            "9 5 3 2\n" +
            "8 4 4 2\n" +
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

        private static int[,] SortArray (int[,] arr) {
            int temp;

            for (int i_c=0; i_c<arr.GetLength(0); i_c++) {
                for (int i_r=0; i_r<arr.GetLength(1); i_r++) {
                    for (int i_t=0; i_t<(arr.GetLength(1))-1; i_t++) {
                        if (arr[i_c,i_t] < arr[i_c,i_t+1]) {
                            temp = arr[i_c,i_t];
                            arr[i_c,i_t] = arr[i_c,i_t+1];
                            arr[i_c,i_t+1] = temp;
                        }
                    }
                }
            }

            return arr;
        }

        private static void PrintIntArray (string message, int[,] arr) {
            System.Console.WriteLine(message);
            for (int i_c=0; i_c<arr.GetLength(0); i_c++) {
                for (int i_r=0; i_r<arr.GetLength(1); i_r++) {
                    System.Console.Write("{0}\t",arr[i_c,i_r]);
                }
                System.Console.WriteLine();
            }
            System.Console.WriteLine();
        }

        private static void Main() {

            const int ARRAY_SIZE_ROWS = 5;
            const int ARRAY_SIZE_COLUMNS = 7;
            const int MIN_VALUE = 0;
            const int MAX_VALUE = 10;
            int[,] array = new int[ARRAY_SIZE_COLUMNS, ARRAY_SIZE_ROWS];

            PrintTaskDescription();

            array = FillArray(ARRAY_SIZE_COLUMNS, ARRAY_SIZE_ROWS, MIN_VALUE, MAX_VALUE);

            PrintIntArray("Initial array:",array);

            array = SortArray(array);

            PrintIntArray("Sorted array:",array);
        }
    }
}
