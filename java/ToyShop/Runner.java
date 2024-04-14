package ToyShop;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Необходимо написать проект, для розыгрыша в магазине игрушек. Функционал
 * должен содержать добавление новых игрушек и задания веса для выпадения
 * игрушек.
 */

class ToyShop {
    private final HashMap<Integer, String> names;
    private final HashMap<Integer, Integer> values;
    private final PriorityQueue<Integer> ids;

    public ToyShop() {
        this.names = new HashMap<>();
        this.values = new HashMap<>();
        this.ids = new PriorityQueue<>();
    }

    public void addItem (Integer id, Integer value, String name) {
        ids.add(id);
        names.put(id, name);
        values.put(id, value);
    }

    public String toString() {
        return ids.toString() + '\n' + values + '\n' + names;
    }
}

public class Runner {
    public static void main(String[] args) {
        ToyShop toyShop = new ToyShop();
        toyShop.addItem(1,2,"Test");
        toyShop.addItem(2,5,"Test2");
        toyShop.addItem(3,10,"Test3");
        System.out.println(toyShop);
    }
}