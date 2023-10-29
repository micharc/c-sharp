namespace GB {

    using System;
    using System.IO;

    class homeTasks {

        private static void PrintTaskDescription () {
            System.Console.WriteLine("\n" +
            "Задача 66: Задайте значения M и N. Напишите программу, которая найдёт\n" +
            "сумму натуральных элементов в промежутке от M до N.\n" +
            "M = 1; N = 15 -> 120\n" +
            "M = 4; N = 8. -> 30\n" +
            "====================================================================================\n");
        }

        private static int SumNaturalNumbers (int sum, int number, int max) {
            if (number < max) {
                return SumNaturalNumbers(sum+number, ++number, max);
            } else {
                return sum+number;
            }
        }

        private static void Main() {

            PrintTaskDescription();

            System.Console.Write("Input first natural number M: ");
            int M = Convert.ToInt32(Console.ReadLine());
            System.Console.Write("Input second natural number N: ");
            int N = Convert.ToInt32(Console.ReadLine());

            if (N < 1 || M < 1) {
                System.Console.WriteLine("Natural numbers > 0. Rerun program again...");
                return;
            }

            if (M > N) {
                System.Console.WriteLine("M should be less or equal N. Rerun program again...");
                return;
            }

            System.Console.WriteLine("-> {0}", SumNaturalNumbers(0, M, N));

        }
    }
}
