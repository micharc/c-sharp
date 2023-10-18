namespace GB {

    using System;
    using System.IO;

    class homeTasks {

        private static void PrintTaskDescription () {
            System.Console.WriteLine("\n" +
            "Задача: Написать программу, которая из имеющегося массива строк\n" +
            "формирует новый массив из строк, длина которых меньше, либо равна 3 символам.\n" +
            "Первоначальный массив можно ввести с клавиатуры, либо задать на старте выполнения алгоритма.\n" +
            "При решении не рекомендуется пользоваться коллекциями, лучше обойтись исключительно массивами.\n" +
            "Примеры:\n" +
            "[“Hello”, “2”, “world”, “:-)”] → [“2”, “:-)”]\n" +
            "[“1234”, “1567”, “-2”, “computer science”] → [“-2”]\n" +
            "[“Russia”, “Denmark”, “Kazan”] → []\n" +
            "====================================================================================\n");
        }

        private static void PrintStringArray (String[] arr, int Size) {
            bool first = true;
            System.Console.Write("\n=> [");

            for (int i=0; i<Size; i++) {

                if (CheckElement(arr[i])) {
                    if (first) {
                        System.Console.Write("“{0}“",arr[i]);
                        first = false;
                    } else {
                        System.Console.Write(", “{0}“",arr[i]);
                    }
                }
            }

            System.Console.WriteLine("]");
        }

        private static bool CheckElement (String S) {
            if (S != null && S.Length < 4) {
                return true;
            } else {
                return false;
            }
        }

        private static void Main() {

            PrintTaskDescription();

            String[] Array = new String[10];

            System.Console.Write("Enter number of elements: ");
            int ArraySize = Convert.ToInt32(Console.ReadLine());

            if (ArraySize > 10 || ArraySize < 1) {
                System.Console.WriteLine("Number of elements can't be > 10.");
                return;
            }

            System.Console.WriteLine("Enter elements of string array:\n");
            for (int i=0; i<ArraySize; i++) {
                System.Console.Write($"[{i+1}]: ");
                Array[i] = Console.ReadLine();
            }

            PrintStringArray(Array, ArraySize);

        }
    }
}
