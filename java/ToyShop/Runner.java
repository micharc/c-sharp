package ToyShop;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Необходимо написать проект, для розыгрыша в магазине игрушек. Функционал
 * должен содержать добавление новых игрушек и задания веса для выпадения
 * игрушек.
 */

class ToyShop {
    private final HashMap<String, String> names;
    private final HashMap<String, Float> values;
    private final PriorityQueue<String> ids;

    Boolean DEBUG = false;

    public ToyShop() {
        this.names = new HashMap<>();
        this.values = new HashMap<>();
        this.ids = new PriorityQueue<>();
    }

    public void put(String id, String value, String name) {
        float tempValue;
        try {
            tempValue = Float.parseFloat(value);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number for 'Value' - " + value);
            return;
        }
        ids.add(id);
        names.put(id, name);
        values.put(id, tempValue);
    }

    public String toString() {
        String result = "";
        for (String s : ids) {
            result = result.concat(String.format("id = %s (value = %.1f, name = %s)\n", s, values.get(s), names.get(s)));
        }
        return result;
    }

    public String get() {
        Float totalValue = (float) 0;
        Object[] tempIds = ids.toArray();
        for (Object o : tempIds) {
            String tempId = (String) o;
            totalValue += values.get(tempId);
        }
        Float tempValue = (float) 0;
        tempIds = ids.toArray();
        float randomValue = (float) Math.random() * totalValue;
        for (Object id : tempIds) {
            String tempId = (String) id;
            tempValue += values.get(tempId);
            if (tempValue > randomValue) {
                if (DEBUG) {
                    System.out.printf("randomValue = %.1f, tempValue = %.1f, id = %s\n", randomValue, tempValue, tempId);
                }
                return tempId + "\n";
            }
        }
        System.out.println("Error! Element not found");
        return "Error! Element not found";
    }
}

public class Runner {

    static Boolean DEBUG = false;

    public static void main(String[] args) throws IOException {
        String fileName = "result.txt";
        ToyShop toyShop = new ToyShop();
        toyShop.put("11","20.0","Пикачу");
        toyShop.put("30","10.0","Мяч");
        toyShop.put("99","70.0","Трактор");

        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

        String result = String.valueOf(toyShop);
        if (DEBUG) { System.out.println(result); }

        result = result.concat(toyShop.get());
        result = result.concat(toyShop.get());
        result = result.concat(toyShop.get());
        result = result.concat(toyShop.get());
        result = result.concat(toyShop.get());
        result = result.concat(toyShop.get());
        result = result.concat(toyShop.get());
        result = result.concat(toyShop.get());
        result = result.concat(toyShop.get());
        result = result.concat(toyShop.get());

        writer.write(result);
        writer.close();
    }
}