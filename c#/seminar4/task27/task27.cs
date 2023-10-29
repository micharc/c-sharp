namespace GB {

    using System;
    using System.IO;

    class homeTasks {
        private static void Main() {

/*
	Задача 27: Напишите программу, которая принимает на
	вход число и выдаёт сумму цифр в числе.
*/

            System.Console.Write("Enter integer number: ");
            int number = Convert.ToInt32(Console.ReadLine());

	    string s = number.ToString();
	    int result = 0;
	    for (int i=0;i<s.Length;i++) {
                result += Convert.ToInt32(s[i]-'0');
 	    }

            Console.WriteLine("Summ of all digits for number {0} is {1}",number,result);
	}
    }
}
