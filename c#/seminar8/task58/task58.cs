namespace GB {

    using System;
    using System.IO;

    class homeTasks {

        private static bool debug = true;

        private static void PrintTaskDescription () {
            System.Console.WriteLine("\n" +
            "Задача 58: Задайте две матрицы. Напишите программу, которая будет находить произведение двух матриц.\n" +
            "Например, даны 2 матрицы:\n" +
            "2 4 | 3 4\n" +
            "3 2 | 3 3\n" +
            "Результирующая матрица будет:\n" +
            "18 20\n" +
            "15 18\n" +
            "====================================================================================\n");
        }

        private static int[,] FillArray (int columns, int rows, int min, int max) {
            int[,] arr = new int[rows,columns];
            Random rnd = new Random();

            for (int i_r=0; i_r<rows; i_r++) {
                for (int i_c=0; i_c<columns; i_c++) {
                    arr[i_r,i_c] = rnd.Next(min,max);
                }
            }

            return arr;
        }

        private static int[,] MultiplyMatrixes (int[,] a, int[,] b) {
            int [,] c = new int[a.GetLength(0),b.GetLength(1)];

            for (int i_row1=0; i_row1<a.GetLength(0); i_row1++) {
                for (int i_column2=0; i_column2<b.GetLength(1); i_column2++) {
                    int temp = 0;
                    if ( debug ) { System.Console.Write($"c[{i_row1+1},{i_column2+1}] = "); }
                    for (int i_column1=0; i_column1<a.GetLength(1); i_column1++) {
                        temp += a[i_row1,i_column1] * b[i_column1,i_column2];
                        if ( debug ) {
                            System.Console.Write($"a[{i_row1+1},{i_column1+1}] ({a[i_row1,i_column1],4}) * b[{i_column1+1},{i_column2+1}] ({b[i_column1,i_column2],4})");
                            if (i_column1 < (a.GetLength(1)-1) ) {
                                System.Console.Write(" + ");
                            }
                        }
                    }
                    c[i_row1,i_column2] = temp;
                    if ( debug ) { System.Console.WriteLine($" = {temp,4}"); }
                }
            }

            System.Console.WriteLine();
            return c;
        }

        private static void PrintIntArray (string message, int[,] arr) {
            System.Console.WriteLine(message + ". Size [{0} * {1}]", arr.GetLength(0), arr.GetLength(1));
            for (int i_c = 0; i_c < arr.GetLength(0); i_c++) {
                for (int i_r = 0; i_r < arr.GetLength(1); i_r++) {
                    System.Console.Write("{0,4} ",arr[i_c,i_r]);
                }
                System.Console.WriteLine();
            }
            System.Console.WriteLine();
        }

        private static void Main() {

            const int MATRIX1_SIZE_ROWS = 3;
            const int MATRIX1_SIZE_COLUMNS = 2;
            const int MATRIX2_SIZE_ROWS = 2;
            const int MATRIX2_SIZE_COLUMNS = 3;
            const int MIN_VALUE = -10;
            const int MAX_VALUE = 10;

            int[,] a = new int[MATRIX1_SIZE_ROWS, MATRIX1_SIZE_COLUMNS];
            int[,] b = new int[MATRIX2_SIZE_ROWS, MATRIX2_SIZE_COLUMNS];
            int[,] c = new int[MATRIX1_SIZE_ROWS, MATRIX2_SIZE_COLUMNS];

            PrintTaskDescription();

            if (MATRIX1_SIZE_COLUMNS != MATRIX2_SIZE_ROWS) {
                System.Console.WriteLine($"Incorrect matrix A & B sizes!\n" +
                    "Number of columns ({0}) in first matrix A should be equal " +
                    "to number of rows ({1}) in second matrix B.\n" +
                    "Please check initial parameters and rerun program.",MATRIX1_SIZE_COLUMNS,MATRIX2_SIZE_ROWS);
                return;
            }

            a = FillArray(MATRIX1_SIZE_ROWS, MATRIX1_SIZE_COLUMNS, MIN_VALUE, MAX_VALUE);
            b = FillArray(MATRIX2_SIZE_ROWS, MATRIX2_SIZE_COLUMNS, MIN_VALUE, MAX_VALUE);

// example from https://ru.onlinemschool.com/math/library/matrix/multiply/

//            a[0,0] = 2; a[0,1] = 1;
//            a[1,0] = -3; a[1,1] = 0;
//            a[2,0] = 4; a[2,1] = -1;
//
//            b[0,0] = 5;  b[0,1] = -1; b[0,2] = 6;
//            b[1,0] = -3; b[1,1] = 0; b[1,2] = 7;

            PrintIntArray("Matrix A", a);
            PrintIntArray("Matrix B", b);

            c = MultiplyMatrixes(a, b);

            PrintIntArray("Result matrix C:", c);
        }
    }
}
