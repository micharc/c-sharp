namespace GB {

    using System;
    using System.IO;

    class homeTasks {

	private static void printTaskDescription () {
	    System.Console.WriteLine("\n" +
	    "Задача 34: Задайте массив заполненный случайными положительными трёхзначными числами.\n" +
	    "Напишите программу, которая покажет количество чётных чисел в массиве.\n" +
	    "\n" +
	    "Пример выполнения: [345, 897, 568, 234] -> 2\n" +
	    "====================================================================================\n");
	}

	private static int[] fillArray (int size, int min, int max) {
	    int[] arr = new int[size];
	    Random rnd = new Random();

	    for (int i=0;i<size;i++) {
                arr[i] = rnd.Next(min,max);
	    }

	    return arr;
	}

	private static int evenElementsCount (int[] arr) {
	    int evenNumbersCount = 0;
	    for (int i=0;i<arr.Length;i++) {
		if (arr[i] % 2 == 0) {
		    evenNumbersCount++;
		}
	    }
	    return evenNumbersCount;
	}

	private static void printIntArray (int[] arr) {
	    System.Console.WriteLine("Array size is {0}\n",arr.Length);
	    System.Console.Write("Your array is: [{0}",arr[0]);
	    for (int i=1;i<arr.Length;i++) {
                System.Console.Write(", {0}",arr[i]);
	    }
	    System.Console.WriteLine("]");
	}

        private static void Main() {

	    printTaskDescription();

	    const int ARRAY_SIZE = 10;
	    int[] array = new int[ARRAY_SIZE];

	    array = fillArray(ARRAY_SIZE, 100, 1000);

	    printIntArray(array);	    

	    System.Console.WriteLine("-> {0}",evenElementsCount(array));

	}
    }
}
