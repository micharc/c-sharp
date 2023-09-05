namespace GB
{

    using System;
    using System.IO;

    class homeTasks1_4 {
        private static void Main()
        {

        /*
            Задача 4: Напишите программу, которая принимает на вход три числа и
            выдаёт максимальное из этих чисел.
            2, 3, 7 -> 7
            44 5 78 -> 78
            22 3 9 -> 22
        */

            int n2, n3, max;

            System.Console.Write("First number [n1]: ");
            max = Convert.ToInt32(Console.ReadLine());

            System.Console.Write("Second number [n2]: ");
            n2 = Convert.ToInt32(Console.ReadLine());
            if (n2 > max) { max = n2; }

            System.Console.Write("Third number [n3]: ");
            n3 = Convert.ToInt32(Console.ReadLine());
            if (n3 > max) { max = n3; }

            System.Console.WriteLine("The biggest number is ({0:D})",max);

        }
    }
}
