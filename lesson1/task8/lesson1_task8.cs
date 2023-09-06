namespace GB
{

    using System;
    using System.IO;

    class homeTasks1_8 {
        private static void Main()
        {

        /*
            Задача 8: Напишите программу, которая на вход принимает число (N),
            а на выходе показывает все чётные числа от 1 до N.
            5 -> 2, 4
            8 -> 2, 4, 6, 8
        */

            int n;

            System.Console.Write("Enter positive integer number above 1: ");
            n = Convert.ToInt32(Console.ReadLine());

            if (n < 2) {
                System.Console.WriteLine("Incorrect number!");
                return;
            }

            System.Console.Write("Even numbers from 1 to {0:D}: ",n);

            for (int i = 2;i<=n; i++) {
                if ((i % 2) == 0) {
                    if (i == 2) {
                        System.Console.Write("{0:D}", i);
                    } else {
                        System.Console.Write(", {0:D}", i);
                    }
                }
            }

        }
    }
}
