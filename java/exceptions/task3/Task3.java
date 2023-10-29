package exceptions.task3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Year;
import java.util.Scanner;
import java.lang.String;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Файлы создаются в папке "out/"
 * Приложение работает в двух режимах:
 * 1) режим отладки (DEBUG = true), в этом случае входные данные берутся
 * из массива TEST_SAMPLES и исключения не вызываются. После завершения
 * приложение выводит статистику по обработке тестовых данных.
 * 2) интерактивный режим (DEBUG = false) - входные данные вводятся
 * пользователем и при некорректном вводе бросаются исключения.
 */

public class Task3 {
    static final String[][] TEST_SAMPLES = {
            {"Иванов Иван Иванович 12.10.2000 79211234567 m", "OK"},
            {"Иванов Иван Иванович 12.10.2001 79211234567 m", "OK"},
            {"Иванов Иван Иванович 12.10.2002 79211234567 m", "OK"},
            {"Иванов Иван Иванович 12.10.2000 Иванович 79211234567 m", "NOK"}, // два отчества
            {"Иванов... Иван Иванович 12.10.2000 79211234567 m", "NOK"}, // некорректные символы в фамилии
            {"Иванов Иван! Иванович 12.10.2000 79211234567 m", "NOK"}, // некорректные символы в имени
            {"Иванов Иван Иванови@ч 12.10.2000 79211234567 m", "NOK"}, // некорректные символы в отчестве
            {"Петрова Анна Валерьевна 11.09.2005 79211256665 f", "OK"}, // OK
            {"Иванова Иванеса 12.10.2000 79211234567 f Захаровна", "OK"}, // OK
            {"Иванова Иванеса 12.10.2000 79211234567 f Петровна", "OK"}, // OK
            {"Сидоров Иван Иванович 11.13.2000 79211234567 m", "NOK"}, // неверный месяц
            {"Сидоров Иван Иванович 41.11.2000 79211234567 m", "NOK"}, // неверный день
            {"Сидоров Иван Иванович 11.11.30000 79211234567 m", "NOK"}, // неверный год
            {"Иванова Иванеса 12.10.2000 79211234567 m", "NOK"}, // нет отчества
            {"Иванов Иван Иванович 12.10.2000 12379211234567 m", "NOK"}, // длинный телефон
            {"Иванова Иванеса Захаровна 12.10.2000 79211234567 q", "NOK"}, // некорректный пол
            {"Петрова Анна Валерьевна 79211256665 f", "NOK"}, // нет даты рождения
            {"Петрова Анна Валерьевна 11.09.2005 f", "NOK"}, // нет телефона
            {"Петрова Анна Валерьевна 11.09.2005 79211256665", "NOK"} // нет пола
    };

    static final boolean DEBUG = false;

    public static void main(String[] args) throws IOException {

        int failedTests = 0;

        System.out.println("Введите данные пользователя в следующем формате:\n" +
                "Фамилия Имя Отчество датарождения номертелефона пол\n\n" +
                "Пример корректных данных:\n" +
                "Иванов Иван Иванович 12.10.2000 79211234567 m\n");

        if (DEBUG) {
            for (int i=0;i<TEST_SAMPLES.length;i++){
                System.out.printf("\n===========================================================\n" +
                                "TEST_SAMPLES[%d] - %s\n\n",
                        i, TEST_SAMPLES[i][0]);
                String res = parseField(TEST_SAMPLES[i][0]);
                if (res.equals(TEST_SAMPLES[i][1])) {
                    if (DEBUG) { System.out.printf("Test %d, result is PASSED\n", i); }
                } else {
                    if (DEBUG) { System.out.printf("Test %d, result is FAILED\n", i); }
                    failedTests++;
                }
            }
            if (failedTests == 0) {
                System.out.print("\nAll tests were PASSED!\n");
            } else {
                System.out.printf("\n%d tests were FAILED!\n", failedTests);
            }
        } else {
            String buffer;
            do {
                buffer = getInput();
                String res = parseField(buffer);
                System.out.printf(res);
            }
            while (buffer.isEmpty());
        }
    }

    private static String parseField(String input) throws IOException {
        String[] parsedString = input.split(" ");
        int nameNum = 0;
        StringBuilder fio = new StringBuilder();
        String birthDate = "";
        String phone = "";
        String sex = "";
        String fileName = "";

        for (int i=0;i<parsedString.length;i++) {
            if (DEBUG) { System.out.printf("%d - %s\n",i, parsedString[i]); }
            switch (detectFieldType(parsedString[i])) {
                case 1:
                    if (nameNum == 0) { fileName = parsedString[i]; }
                    if (DEBUG) { System.out.printf("Name - %d\n", nameNum); }
                    nameNum++;
                    if (nameNum<4) {
                        fio.append(parsedString[i]).append(" ");
                    } else {
                        if (DEBUG) {
                            System.out.print("\nКоличество текстовых элементов больше 3!\n" +
                                    "Допускается только фамилия, имя и отчество!\n" +
                                    "Повторите ввод!\n");
                            return "NOK";
                        } else {
                            throw new IllegalArgumentException("\nКоличество текстовых элементов больше 3!\n" +
                                    "Допускается только фамилия, имя и отчество!\n" +
                                    "Повторите ввод!\n");
                        }
                    }
                    break;
                case 2:
                    if (DEBUG) { System.out.print("Date\n"); }
                    birthDate = parsedString[i];
                    String[] parsedDate = birthDate.split("[.]");
                    if (parsedDate.length != 3) {
                        if (DEBUG) {
                            System.out.print("\nДата рождения в формате dd.mm.yyyy не была введена!\n" +
                                    "Повторите ввод!\n");
                            return "NOK";
                        } else {
                            throw new IllegalArgumentException("\nДата рождения в формате dd.mm.yyyy не была введена!\n" +
                                    "Повторите ввод!\n");
                        }
                    }
                    int step = 0;
                    for (String s : parsedDate) {
                        int temp = Integer.parseInt(s);
                        if (step == 0) { // day
                            if (temp > 31 || temp < 0) {
                                if (DEBUG) {
                                    System.out.print("\nНекорректный день месяца в дате рождения!\n" +
                                            "Повторите ввод!\n");
                                    return "NOK";
                                } else {
                                    throw new IllegalArgumentException("\nНекорректный день месяца в дате рождения!\n" +
                                            "Повторите ввод!\n");
                                }
                            } else {
                                step++;
                                continue;
                            }
                        }

                        if (step == 1) { // month
                            if (temp > 12 || temp < 0) {
                                if (DEBUG) {
                                    System.out.print("\nНекорректный номер месяца в дате рождения!\n" +
                                            "Повторите ввод!\n");
                                    return "NOK";
                                } else {
                                    throw new IllegalArgumentException("\nНекорректный номер месяца в дате рождения!\n" +
                                            "Повторите ввод!\n");
                                }
                            } else {
                                step++;
                                continue;
                            }
                        }

                        if (step == 2) { // year
                            Year thisYear = Year.now();
                            if (temp > thisYear.getValue() || temp < 1900) {
                                if (DEBUG) {
                                    System.out.print("\nНекорректный номер года в дате рождения!\n" +
                                            "Повторите ввод!\n");
                                    return "NOK";
                                } else {
                                    throw new IllegalArgumentException("\nНекорректный номер года в дате рождения!\n" +
                                            "Повторите ввод!\n");
                                }

                            } else {
                                step++;
                                continue;
                            }
                        }

                        if (step > 2) { // extra data
                            if (DEBUG) {
                                System.out.print("\nНекорректные данные в дате рождения!\n" +
                                        "Повторите ввод!\n");
                                return "NOK";
                            } else {
                                throw new IllegalArgumentException("\nНекорректные данные в дате рождения!\n" +
                                        "Повторите ввод!\n");
                            }
                        }
                    }
                    break;
                case 3:
                    if (DEBUG) { System.out.print("Phone\n"); }
                    phone = parsedString[i];
                    if ( phone.length() != 11) {
                        if (DEBUG) {
                            System.out.print("\n11 значный номер телефона в числовом формате не был введен!\n" +
                                    "Повторите ввод!\n");
                            return "NOK";
                        } else {
                            throw new IllegalArgumentException("\n11 значный номер телефона в числовом формате не был введен!\n" +
                                    "Повторите ввод!\n");
                        }
                    }
                    break;
                case 4:
                    if (DEBUG) { System.out.print("Sex\n"); }
                    sex = parsedString[i];
                    if (sex.length() != 1) {
                        if (DEBUG) {
                            System.out.print("\nПол в формате \"f\" или \"m\" не был введен!\n" +
                                "Повторите ввод!\n");
                            return "NOK";
                        } else {
                            throw new IllegalArgumentException("\nПол в формате \"f\" или \"m\" не был введен!\n" +
                                    "Повторите ввод!\n");
                        }
                    }
                    break;
                default:
                    if (DEBUG) { System.out.print("Количество введенных полей данных неверно!\n" +
                            "Повторите ввод!\n");
                        return "NOK";
                    } else {
                        throw new IllegalArgumentException("\nоличество введенных полей данных неверно!\n" +
                                "Повторите ввод!\n");
                    }

            }
        }

        if ( nameNum != 3) {
            if (DEBUG) {
                System.out.print("\nКоличество текстовых элементов меньше 3!\n" +
                        "Необходимо ввести фамилию, имя и отчество!\n" +
                        "Повторите ввод!\n");
                return "NOK";
            } else {
                throw new IllegalArgumentException("\nКоличество текстовых элементов меньше 3!\n" +
                        "Необходимо ввести фамилию, имя и отчество!\n" +
                        "Повторите ввод!\n");
            }
        }

        if (birthDate.isEmpty()) {
            if (DEBUG) {
                System.out.print("\nДата рождения в формате dd.mm.yyyy не была введена!\n" +
                        "Повторите ввод!\n");
                return "NOK";
            } else {
                throw new IllegalArgumentException("\nДата рождения в формате dd.mm.yyyy не была введена!\n" +
                        "Повторите ввод!\n");
            }
        }

        if (phone.isEmpty()) {
            if (DEBUG) {
                System.out.print("\n11 значный номер телефона в числовом формате не был введен!\n" +
                        "Повторите ввод!\n");
                return "NOK";
            } else {
                throw new IllegalArgumentException("\n11 значный номер телефона в числовом формате не был введен!\n" +
                        "Повторите ввод!\n");
            }
        }

        if (sex.isEmpty()) {
            if (DEBUG) {
                System.out.print("\nПол в формате \"f\" или \"m\" не был введен!\n" +
                        "Повторите ввод!\n");
                return "NOK";
            } else {
                throw new IllegalArgumentException("\nПол в формате \"f\" или \"m\" не был введен!\n" +
                        "Повторите ввод!\n");
            }
        }

        if (DEBUG) {
            System.out.printf("\n%s|%s|%s|%s\n", fio, birthDate, phone, sex);
        }

        saveResult(fileName, fio + birthDate + " " + phone + " " + sex);
        return "OK";
    }

    private static void saveResult(String fn, String str) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("out/" + fn, true));
        writer.append(str).append("\n");
        writer.close();
    }

    private static int detectFieldType(String s) {
        Pattern pattern = Pattern.compile("[йцукенгшщзхъфывапролджэячсмитьбю]+",
                Pattern.CASE_INSENSITIVE|Pattern.UNICODE_CASE);
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            for (int i=0;i<s.length();i++) {
                String temp = s.substring(i, i+1);
                pattern = Pattern.compile("[йцукенгшщзхъфывапролджэячсмитьбю]+", Pattern.CASE_INSENSITIVE|Pattern.UNICODE_CASE);
                matcher = pattern.matcher(temp);
                if (!matcher.find()) {
                    if (DEBUG) {
                        System.out.print("\nФИО может содержать только буквы!\n" +
                                "Повторите ввод!\n");
                        return 0;
                    } else {
                        throw new IllegalArgumentException("\nФИО может содержать только буквы!\n" +
                                "Повторите ввод!\n");
                    }
                }
            }
            return 1;
        }

        pattern = Pattern.compile("\\d\\d\\.\\d\\d\\.\\d\\d\\d\\d", Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(s);
        if (matcher.find()) {
            return 2;
        }

        pattern = Pattern.compile("\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d", Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(s);
        if (matcher.find()) {
            return 3;
        }

        pattern = Pattern.compile("[f|m]", Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(s);
        if (matcher.find()) {
            return 4;
        }

        return 0;
    }

    private static String getInput() {
        final Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}