namespace GB {

    using System;
    using System.IO;

    class homeTasks2_15 {
        private static void Main() {

/*
  Задача 15: Напишите программу, которая принимает на вход цифру,
  обозначающую день недели, и проверяет, является ли этот день выходным.
  6 -> да
  7 -> да
  1 -> нет
*/

            System.Console.Write("Enter day of week number (1-7): ");
            int n = Convert.ToInt32(Console.ReadLine());

            if (n < 1 || n > 7) {
                System.Console.WriteLine("Wrong day of week number! ({0})",n);
                return;
            }

            if (n >= 1 && n <= 5) {
                System.Console.WriteLine("No, this is not a weekend...");
                return;
            } else {
                System.Console.WriteLine("Yes, this is a weekend! Hurra! :)");
                return;
            }

        }
    }
}
