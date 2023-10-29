namespace GB {

    using System;
    using System.IO;

    class homeTasks2 {
        private static void Main() {

/*
Внутри класса Answer напишите метод DistanceBetweenPoints, 
который принимает на вход координаты двух точек pointA и pointB 
в виде массива целых чисел, и возвращает расстояние между ними в 3D пространстве.

A (3,6,8); B (2,1,-7) -> 15.84
A (7,-5, 0); B (1,-1,9) -> 11.53

*/

using System;

public class Answer
{
    private static double Length(int[] pointA, int[] pointB)
    {
      // Введите свое решение ниже
      return Math.Sqrt(
        Math.Pow(pointA[0]-pointB[0],2)
        +Math.Pow(pointA[1]-pointB[1],2)
        +Math.Pow(pointA[2]-pointB[2],2)
        );
    }

  // Не удаляйте и не меняйте метод Main! 
    public static void Main(string[] args) {
        int x1, x2, x3, y1, y2, y3;

        if (args.Length >= 6) {
            x1 = int.Parse(args[0]);
            x2 = int.Parse(args[1]);
            x3 = int.Parse(args[2]);
            y1 = int.Parse(args[3]);
            y2 = int.Parse(args[4]);
            y3 = int.Parse(args[5]);
        } else {
           // Здесь вы можете поменять значения для отправки кода на Выполнение
            x1 = 7;
            x2 = -5;
            x3 = 0;
            y1 = 1;
            y2 = -1;
            y3 = 9;
        }

        // Не удаляйте строки ниже
        double result = Length(new int[]{x1, x2, x3}, new int[]{y1, y2, y3});
        Console.WriteLine($"{result:F2}");
    }
}
        }
    }
}
