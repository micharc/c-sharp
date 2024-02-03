/**
 * Дана строка sql-запроса:
 * "select * from students where"
 * Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные (параметры) для фильтрации приведены в виде json-строки в примере ниже. Если значение null, то параметр не должен попадать в запрос.
 * Напишите свой код в методе answer класса Answer. Метод answer принимает на вход два параметра:
 * String QUERY - начало SQL-запроса String PARAMS - JSON с параметрами
 * Пример: Строка sql-запроса:
 * select * from students where
 * Параметры для фильтрации:
 *  {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
 * Результат:
 * select * from students where name='Ivanov' and country='Russia' and city='Moscow'
 */

class Answer {
    public static StringBuilder answer(String QUERY, String PARAMS){
        // Напишите свое решение ниже
        StringBuilder sb = new StringBuilder(QUERY);

        int step = 0, i = 0;
        String parameterName = "";
        String parameterValue = "";
        boolean firstCondition = true;

        for (i=0; i<PARAMS.length(); i++) {

            if ( step == 0 && PARAMS.charAt(i) == '{' ) {
                step = 1;

            } else if ( step == 1 && PARAMS.charAt(i) == '\"' ) {
                step = 2;
                parameterName = "";
                int j = i+1;

                for (; j<PARAMS.length() && PARAMS.charAt(j) != '\"'; j++) {
                    parameterName = parameterName.concat(PARAMS.substring(j,j+1));
                }

                if ( PARAMS.charAt(j) == '\"' ) {
                    i = j;
                } else
                    return new StringBuilder("Can not find closing \" on step 2");

            } else if ( step == 2 && PARAMS.charAt(i) == ':' ) {
                step = 3;

            } else if ( step == 3 && PARAMS.charAt(i) == '\"' ) {
                step = 4;
                parameterValue = "";
                int j = i+1;

                for (; j<PARAMS.length() && PARAMS.charAt(j) != '\"'; j++) {
                    parameterValue = parameterValue.concat(PARAMS.substring(j,j+1));
                }

                if ( PARAMS.charAt(j) == '\"' ) {
                    i = j;
                } else
                    return new StringBuilder("Can not find closing \" on step 4");

            } else if ( step == 4 && ( PARAMS.charAt(i) == ',' || PARAMS.charAt(i) == '}' ) ) {
                step = 1;
                if ( !parameterValue.equals("null") ) {
                    if ( firstCondition ) {
                        firstCondition = false;
                    } else {
                        sb.append(" and ");
                    }
                    sb.append(parameterName).append("='").append(parameterValue).append("'");
                }
            }

        }

        return sb;
    }
}


// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer {
    public static void main(String[] args) {
        String QUERY = "";
        String PARAMS = "";

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            QUERY = "select * from students where ";
//            PARAMS = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"} ";
            PARAMS = "{\"name\":\"Ivanov\", \"country\"        :\"null\",     \"city\"   :     \"null\", " +
                    "  " +
                    "  " +
                    "\"age\":          \"null\"         }         ";
        }
        else {
            QUERY = args[0];
            PARAMS = args[1];
        }

        Answer ans = new Answer();
        System.out.println(ans.answer(QUERY, PARAMS));
    }
}