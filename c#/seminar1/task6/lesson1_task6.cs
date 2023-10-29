namespace GB
{

    using System;
    using System.IO;

    class homeTasks1_6 {
        private static void Main()
        {

        /*
            Задача 6: Напишите программу, которая на вход принимает число и выдаёт,
            является ли число чётным (делится ли оно на два без остатка).
            4 -> да
            -3 -> нет
            7 -> нет
        */

            int n;

            System.Console.Write("Проверка четности числа\n\nВведите целое число: ");
            n = Convert.ToInt32(Console.ReadLine());

            if (Math.Abs(n) % 2 == 1) {
                System.Console.WriteLine("нет (число нечетное)");
            } else {
                System.Console.WriteLine("да (число четное)");
            }

        }
    }
}
