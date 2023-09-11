namespace GB {

    using System;
    using System.IO;

    class Tasks1 {
        private static void Main() {

/*
    Внутри класса Answer напишите метод IsPalindrome, который принимает на вход пятизначное число number
    и проверяет, является ли оно палиндромом.

    Метод должен проверить является ли число пятизначным,
    в противном случае - вывести Число не пятизначное и False в следующей строке.

    Для остальных чисел вернуть True или False.
*/

    static bool IsPalindrome(int number) {
        // Введите свое решение ниже
        string s = number.ToString();
        if (s.Length != 5) {
            System.Console.WriteLine("Число не пятизначное");
            return false;
        }
        for (int i=0;i<3;i++) {
            if (s[i] != s[4-i]) {
                return false;
            }
        }
        return true;
    }

            int number = 50451;

            bool result = IsPalindrome(number);
            System.Console.WriteLine($"{result}");

        }
    }
}
