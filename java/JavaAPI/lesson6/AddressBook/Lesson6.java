package JavaAPI.lesson6.AddressBook;

import java.util.*;

class AddressBook {
    private HashMap<String, String> names;

    public AddressBook() {
        this.names = new HashMap<>();
    }

    public void addName(String name, String phone) {
        if (!names.containsKey(name)) {
            names.put(name,phone);
        } else {
            names.put(name,names.get(name) + ", " + phone);
        }
    }

    public String toString() {
        List<String> sortedList = new ArrayList<>();
        names.forEach((key, value) -> {
            String[] sTemp = value.split(" ");
            Integer numbersQuantity = sTemp.length;
            sortedList.add(String.format("%03d",numbersQuantity) + "=" + key);
        });
        Collections.sort(sortedList);
        Collections.reverse(sortedList);

        String result = "[\n";
        for (String s : sortedList) {
            String[] temp = s.split("=");
            result = result.concat(" ").concat(temp[1]).concat(" = ").
                    concat(names.get(temp[1])).concat("\n");
        }

        result = result.concat("]");

        return result;
    }

}

public class Lesson6 {
    public static void main(String[] args) {
        AddressBook book = new AddressBook();
        book.addName("Petr", "12345");
        book.addName("Semen", "00329349");
        book.addName("Petr", "456343");
        book.addName("Petr", "198494");
        book.addName("Semen", "12");
        book.addName("Alisa", "345");
        book.addName("Alisa", "32424");
        book.addName("Alisa", "4565");
        book.addName("Alisa", "45346");
        book.addName("Semen", "23");
        book.addName("Misha", "99");
        book.addName("Semen", "34");
        System.out.println(book);
    }
}
