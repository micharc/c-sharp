namespace GB {

    using System;
    using System.IO;

    class homeTasks {
        private static void Main() {

/*
	Задача 29: Напишите программу, которая задаёт массив
	из 8 элементов и выводит их на экран.
*/
	    int[] array = new int[8];

	    for (int i=0;i<8;i++) {
                System.Console.Write("Enter integer number [{0}]: ",i);
                array[i] = Convert.ToInt32(Console.ReadLine());
	    }

	    System.Console.Write("\nYour array is: [{0}",array[0]);
	    for (int i=1;i<8;i++) {
                System.Console.Write(", {0}",array[i]);
	    }
	    System.Console.WriteLine("]");

	}
    }
}
