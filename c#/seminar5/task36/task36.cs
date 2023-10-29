namespace GB {

    using System;
    using System.IO;

    class homeTasks {

	private static void printTaskDescription () {
	    System.Console.WriteLine("\n" +
	    "Задача 36: Задайте одномерный массив, заполненный случайными числами.\n" +
	    "Найдите сумму элементов, стоящих на нечётных позициях.\n" +
	    "\n" +
	    "Примеры выполнения:\n" +
	    "[3, 7, 23, 12] -> 19\n" +
	    "[-4, -6, 89, 6] -> 0\n" +
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

	private static int oddElementsSum (int[] arr) {
	    int sum = 0;
	    for (int i=1;i<arr.Length;i+=2) {
		sum += arr[i];
	    }
	    return sum;
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

	    array = fillArray(ARRAY_SIZE, 0, 10);

	    printIntArray(array);

	    System.Console.WriteLine("-> {0}",oddElementsSum(array));

	}
    }
}
