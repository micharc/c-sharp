namespace GB {

    using System;
    using System.IO;

    class homeTasks {

	private static void printTaskDescription () {
	    System.Console.WriteLine("\n" +
	    "Задача 38: Задайте массив вещественных чисел.\n" +
	    "Найдите разницу между максимальным и минимальным элементов массива.\n" +
	    "\n" +
	    "Пример выполнения:\n" +
	    "[3.22, 4.2, 1.15, 77.15, 65.2] => 77.15 - 1.15 = 76\n" +
	    "====================================================================================\n");
	}

	private static double[] fillArrayDouble (int size, double min, double max) {
	    double[] arr = new double[size];
	    Random rnd = new Random();

	    for (int i=0;i<size;i++) {
                arr[i] = rnd.NextDouble();
	    }
	    return arr;
	}

	private static double findMinElement (double[] arr) {
	    double min = arr[0];
	    for (int i=1;i<arr.Length;i++) {
		if ( arr[i] < min ) {
		    min = arr[i];
		}
	    }
	    return min;
	}

	private static double findMaxElement (double[] arr) {
	    double max = arr[0];
	    for (int i=1;i<arr.Length;i++) {
		if ( arr[i] > max ) {
		    max = arr[i];
		}
	    }
	    return max;
	}

	private static void printArrayDouble (double[] arr) {
	    System.Console.WriteLine("Array size is {0}\n",arr.Length);
	    System.Console.Write("Your array is: [{0:F}",arr[0]);
	    for (int i=1;i<arr.Length;i++) {
                System.Console.Write(", {0:F}",arr[i]);
	    }
	    System.Console.WriteLine("]");
	}

        private static void Main() {

	    printTaskDescription();

	    const int ARRAY_SIZE = 10;
	    double[] array = new double[ARRAY_SIZE];
	    double minElement, maxElement;

	    array = fillArrayDouble(ARRAY_SIZE, 0, 1);

	    printArrayDouble(array);

	    System.Console.WriteLine("-> {0:F} - {1:F} = {2:F}",
		maxElement = findMaxElement(array),minElement = findMinElement(array),maxElement-minElement);
	    System.Console.WriteLine("Notice: possible error in calculations due to rounding is 0.01");
	}
    }
}
