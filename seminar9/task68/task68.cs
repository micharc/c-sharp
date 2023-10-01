namespace GB {

    using System;
    using System.IO;

    class homeTasks {

        private static void PrintTaskDescription () {
            System.Console.WriteLine("\n" +
            "Задача 68: Напишите программу вычисления функции Аккермана с помощью рекурсии.\n" +
            "Даны два неотрицательных числа m и n.\n" +
            "m = 2, n = 3 -> A(m,n) = 9\n" +
            "m = 3, n = 2 -> A(m,n) = 29\n" +
            "====================================================================================\n");
        }

        private static int Akkerman (int m, int n) {
            if (m == 0) {
                return n + 1;
            } else if (m > 0 && n == 0) {
                return Akkerman(m - 1, 1);
            } else if (m > 0 && n > 0) {
                return Akkerman(m - 1, Akkerman(m, n - 1));
            }
            return -1;
        }

        private static void Main() {

            PrintTaskDescription();

            System.Console.Write("Input positive integer number m: ");
            int m = Convert.ToInt32(Console.ReadLine());
            System.Console.Write("Input positive integer number n: ");
            int n = Convert.ToInt32(Console.ReadLine());

            if (m < 0 || n < 0) {
                System.Console.WriteLine("Numbers should be > 0. Rerun program again...");
                return;
            }

            System.Console.WriteLine("A(m,n) = {0}", Akkerman(m, n));

        }
    }
}
