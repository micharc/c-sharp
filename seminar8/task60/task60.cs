namespace GB {

    using System;
    using System.IO;

    class homeTasks {

        private static void PrintTaskDescription () {
            System.Console.WriteLine("\n" +
            "Задача 60. Сформируйте трёхмерный массив из неповторяющихся двузначных чисел.\n" +
            "Напишите программу, которая будет построчно выводить массив, добавляя индексы каждого элемента.\n" +
            "Массив размером 2 x 2 x 2\n" +
            "66(0,0,0) 25(0,1,0)\n" +
            "34(1,0,0) 41(1,1,0)\n" +
            "27(0,0,1) 90(0,1,1)\n" +
            "26(1,0,1) 55(1,1,1)\n" +
            "====================================================================================\n");
        }

        private static int[,,] FillArray (int columns, int rows, int deep, int min, int max) {
            int[,,] arr = new int[rows,columns,deep];
            string temp_string = "|";
            Random rnd = new Random();

            for (int i_r=0; i_r<rows; i_r++) {
                for (int i_c=0; i_c<columns; i_c++) {
                    for (int i_d=0; i_d<deep; i_d++) {
                        int next_element = rnd.Next(min,max);
                        // check for already existent elements
                        while (temp_string.IndexOf("|"+next_element.ToString()+"|", 0, temp_string.Length) != -1) {
                            next_element = rnd.Next(min,max);
                        }
                        arr[i_r,i_c,i_d] = next_element;
                        temp_string += next_element.ToString() + "|";
                    }
                }
            }

            return arr;
        }

        private static void PrintIntArray (string message, int[,,] arr) {
            System.Console.WriteLine(message + ". Size [{0} * {1} * {2}]", arr.GetLength(0), arr.GetLength(1), arr.GetLength(2));
            for (int i_c = 0; i_c<arr.GetLength(0); i_c++) {
                for (int i_r = 0; i_r<arr.GetLength(1); i_r++) {
                    for (int i_d=0; i_d<arr.GetLength(2); i_d++) {
                        System.Console.Write("{0,4} ({1},{2},{3})",arr[i_c,i_r,i_d], i_c, i_r, i_d);
                    }
                    System.Console.WriteLine();
                }
            }
            System.Console.WriteLine();
        }

        private static void Main() {

            const int MATRIX_SIZE_ROWS = 2;
            const int MATRIX_SIZE_COLUMNS = 2;
            const int MATRIX_SIZE_DEEP = 2;
            const int MIN_VALUE = 10;
            const int MAX_VALUE = 20;

            int[,,] array = new int[MATRIX_SIZE_ROWS, MATRIX_SIZE_COLUMNS, MATRIX_SIZE_DEEP];

            PrintTaskDescription();

            array = FillArray(MATRIX_SIZE_ROWS, MATRIX_SIZE_COLUMNS, MATRIX_SIZE_DEEP, MIN_VALUE, MAX_VALUE);

            PrintIntArray("Matrix:", array);
        }
    }
}
