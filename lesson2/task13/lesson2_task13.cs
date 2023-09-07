namespace GB {

    using System;
    using System.IO;
    using System.Collections.Generic;
    using System.Linq;
    using System.Text;
    using System.Text.RegularExpressions;

    class homeTasks2_13 {
        private static void Main() {

/*
    Задача 13: Напишите программу, которая выводит третью цифру заданного числа или
    сообщает, что третьей цифры нет.

    645 -> 5
    78 -> третьей цифры нет
    32679 -> 6
    123456789 -> 3
*/

            Regex r = new Regex(@"^\d*$");

            System.Console.Write("Enter integer number: ");
            string s = Console.ReadLine();

            if (String.IsNullOrEmpty(s) || s.Length < 3) {
                System.Console.WriteLine("\nLength of number is less than 3. Third digit can not be found");
                return;
            }

            if (!r.IsMatch(s)) {
                System.Console.WriteLine("\nEntered number is not valid. Please use digits only");
                return;
            }

            System.Console.WriteLine("\nThird digit of number {0} is: {1}",s,s[2]);

        }
    }
}
