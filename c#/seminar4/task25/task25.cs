namespace GB {

    using System;
    using System.IO;

    class homeTasks {
        private static void Main() {

/*
	Задача 25: Напишите цикл, который принимает на вход
	два числа (A и B) и возводит число A в натуральную
	степень B.
*/

            System.Console.Write("Enter integer number A: ");
            int A = Convert.ToInt32(Console.ReadLine());

            System.Console.Write("Enter integer number B: ");
            int B = Convert.ToInt32(Console.ReadLine());

	    int result = (int)Math.Pow(A,B);
            Console.WriteLine("A^B = {0}",result);
	}
    }
}
