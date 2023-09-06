namespace GB {

    using System;
    using System.IO;

    class homeTasks1_4 {
        private static void Main() {

/*
    Задача 2: Напишите программу, которая на вход принимает два числа и выдаёт,
    какое число большее, а какое меньшее.
    a = 5; b = 7 -> max = 7
    a = 2 b = 10 -> max = 10
    a = -9 b = -3 -> max = -3
*/

            int n1, n2;

            System.Console.Write("Enter first integer number [n1]: ");
            n1 = Convert.ToInt32(Console.ReadLine());

            System.Console.Write("Enter second integer number [n2]: ");
            n2 = Convert.ToInt32(Console.ReadLine());

            if (n1 > n2) {
                System.Console.WriteLine("Max - n1 ({0:D}), Min - n2 ({1:D})",n1,n2);
            } else if (n2 > n1) {
                System.Console.WriteLine("Max - n2 ({0:D}), Min - n1 ({1:D})",n2,n1);
            } else {
                System.Console.WriteLine("n1 ({0:D}) == n2 ({1:D})",n1,n2);
            }

        }
    }
}
