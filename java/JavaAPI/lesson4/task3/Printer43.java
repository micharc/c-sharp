package JavaAPI.lesson4.task3;

class Calculator {
    private double previousResult = -1, result = -1;
    public double calculate(char op, int a, int b) {
        // Напишите свое решение ниже
        if (op == '+') {
            previousResult = result;
            return result = a + b;
        } else if (op == '-') {
            previousResult = result;
            return result = a - b;
        } else if (op == '*') {
            previousResult = result;
            return result = a * b;
        } else if (op == '/') {
            previousResult = result;
            return result = (double)a / (double)b;
        } else if (op == '<') {
            return previousResult;
        } else {
            return -1;
        }
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer43 {
    public static void main(String[] args) {
        int a, b, c, d;
        char op, op2, undo;

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            a = 3;
            op = '+';
            b = 7;
            c = 4;
            op2 = '+';
            d = 7;
            undo = '<';
        } else {
            a = Integer.parseInt(args[0]);
            op = args[1].charAt(0);
            b = Integer.parseInt(args[2]);
            c = Integer.parseInt(args[3]);
            op2 = args[4].charAt(0);
            d = Integer.parseInt(args[5]);
            undo = args[6].charAt(0);
        }

        Calculator calculator = new Calculator();
//        double result = calculator.calculate(op, a, b);
//        System.out.println(result);
//        double result2 = calculator.calculate(op2, c, d);
//        System.out.println(result2);
//        double prevResult = calculator.calculate(undo, 0, 0);
//        System.out.println(prevResult);
        System.out.println(calculator.calculate('*',3,2));
        System.out.println(calculator.calculate('-',7,4));
        System.out.println(calculator.calculate('<',1,4));
    }
}