package exceptions.task3;

import java.util.Scanner;
import java.lang.String;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * mcharkov, 2023-10-23
 * Console tool for parsing DE48 for MasterCard. (1)
 * <p>
 * - Parses simple and complex fields. (2)
 * - Separates tag names and length data.
 * - Format output with spaces for easy-reading.
 * - Generates output as Java code for using in tests.
 * - Adds tag names as comment (not all names of tags are supported)
 */

public class Task3 {
    static String[][] DATA_EXAMPLES = {
            {"Иванов Иван Иванович 12.10.2000 79211234567 m", "OK"},
            {"Петрова Анна Валерьевна 11.09.2005 79211256665 f", "OK"}, // OK
            {"Иванова Иванесса 12.10.2000 79211234567 f Захаровна", "OK"}, // OK
            {"Сидоров Иван Иванович 11.13.2000 79211234567 m", "NOK"}, // неверный месяц
            {"Иванова Иванесса 12.10.2000 79211234567 m", "NOK"}, // нет отчества
            {"Иванов Иван Иванович 12.10.2000 12379211234567 m", "NOK"}, // длинный телефон
            {"Иванова Иванесса Захаровна 12.10.2000 79211234567 q", "NOK"}, // некорректный пол
            {"Петрова Анна Валерьевна 79211256665 f", "NOK"}, // нет даты рождения
            {"Петрова Анна Валерьевна 11.09.2005 f", "NOK"}, // нет телефона
            {"Петрова Анна Валерьевна 11.09.2005 79211256665", "NOK"} // нет пола
    };

    static int INIT_TAB = 4;

    public static void main(String[] args) {
        System.out.println("""
                Введите данные пользователя в следующем формате
                Фамилия Имя Отчество датарождения номертелефона пол
                """);
        for (int i=0;i<DATA_EXAMPLES.length;i++){
            System.out.printf("%d - %s\n", i, DATA_EXAMPLES[i][0]);
        }
//        while (parseField());
    }

    private static boolean parseField() {
        String buffer_hex = getInput();
//        String buffer_hex = DATA_EXAMPLE;

        return true;
    }

    private static String getInput() {
        final Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}