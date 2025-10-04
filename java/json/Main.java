package json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class Main {
    public static void main(String[] arg) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        AddressBook ab_write = new AddressBook()
                .addRecord(new Record("Иван", "Петров"))
                .addRecord(new Record("Ирина", "Ульянова"))
                .addRecord(new Record("Филипп", "Сидоров"));
        System.out.println("gson.toJson(ab_write) = " + gson.toJson(ab_write));

        try (Writer writer = new FileWriter("book.json")) {
            gson.toJson(ab_write, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (Reader reader = new FileReader("bookr.json")) {

            // convert the JSON data to a Java object
            AddressBook ab_read = gson.fromJson(reader, AddressBook.class);
            System.out.println("gson.toJson(ab_read) = " + gson.toJson(ab_read));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
