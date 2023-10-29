namespace GB {

    using System;
    using System.IO;

    class homeTasks {
        private static void Main() {

/*
	Задача 41: Пользователь вводит с клавиатуры M чисел. 
	Посчитайте, сколько чисел больше 0 ввёл пользователь.

	0, 7, 8, -2, -2 -> 2
	1, -7, 567, 89, 223-> 3
*/
	    const int MAX_ARRAY_SIZE = 100;
	    int[] array = new int[MAX_ARRAY_SIZE];
	    int aboveZeroNumCount = 0, array_size = 0;

	    System.Console.Write("Enter array size M (max={0}): ",MAX_ARRAY_SIZE);
	    array_size = Convert.ToInt32(Console.ReadLine());

	    if (array_size < 1 || array_size > 100) {
	 	System.Console.Write("Incorrect array size. It should be > 0 and < {0} !",MAX_ARRAY_SIZE);
		return;
	    }

	    for (int i=0;i<array_size;i++) {
                System.Console.Write("Enter integer number [{0}]: ", i);
                array[i] = Convert.ToInt32(Console.ReadLine());
		if ( array[i] > 0 ) aboveZeroNumCount++;
	    }

	    System.Console.Write("\nYour array is: [{0}", array[0]);
	    for (int i=1;i<array_size;i++) {
                System.Console.Write(", {0}", array[i]);
	    }
	    System.Console.WriteLine($"] -> {aboveZeroNumCount:D}");

	}
    }
}
