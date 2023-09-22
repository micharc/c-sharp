namespace GB {

    using System;
    using System.IO;

    class homeTasks {
        private static void Main() {

/*
	Задача 43: Напишите программу, которая найдёт точку пересечения двух прямых, 
	заданных уравнениями y = k1 * x + b1, y = k2 * x + b2; 
	значения b1, k1, b2 и k2 задаются пользователем.

	b1 = 2, k1 = 5, b2 = 4, k2 = 9 -> (-0,5; -0,5)
*/
	double k1, k2, b1, b2, x, y;

        System.Console.Write("k1: ");
        k1 = Convert.ToDouble(Console.ReadLine());

        System.Console.Write("k2: ");
        k2 = Convert.ToDouble(Console.ReadLine());

        System.Console.Write("b1: ");
        b1 = Convert.ToDouble(Console.ReadLine());

        System.Console.Write("b2: ");
        b2 = Convert.ToDouble(Console.ReadLine());

        x = (b2-b1)/(k1-k2);
	y = k1*x+b1;

	System.Console.WriteLine($"\nb1 = {b1:F}, k1 = {k1:F}, b2 = {b2:F}, k2 = {k2:F} -> ({x:F}, {y:F})");
	}
    }
}

