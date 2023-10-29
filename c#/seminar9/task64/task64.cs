namespace GB {

    using System;
    using System.IO;

    class homeTasks {

        private static void PrintTaskDescription () {
            System.Console.WriteLine("\n" +
            "Задача 64: Задайте значение N. Напишите программу, которая выведет все натуральные \n" +
            "числа в промежутке от N до 1. Выполнить с помощью рекурсии.\n" +
            "N = 5 -> \"5, 4, 3, 2, 1\"\n" +
            "N = 8 -> \"8, 7, 6, 5, 4, 3, 2, 1\"\n" +
            "====================================================================================\n");
        }

        private static void PrintNextNaturalNumbers (int number) {
            System.Console.Write("{0}", number);
            if (number > 1) {
                System.Console.Write(", ");
                PrintNextNaturalNumbers(--number);
            }
        }

        private static void Main() {

            PrintTaskDescription();

            System.Console.Write("Input natural number N: ");
            int N = Convert.ToInt32(Console.ReadLine());

            if (N < 1) {
                System.Console.WriteLine("Natural numbers > 0. Rerun program again...");
                return;
            }

            PrintNextNaturalNumbers(N);

        }
    }
}
