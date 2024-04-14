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

    public Integer get() {
        int totalValue = 0;
        Integer[] tempIds = new Integer[ids.size()];
        tempIds = (Integer)ids.toArray();
        while (tempIds.peek() != null) {
            Integer temp = tempIds.poll();
            totalValue += values.get(temp);
        }
        int tempValue = 0;
        tempIds = ids;
        int randomValue = (int)(Math.random()*totalValue);
        while (tempIds.peek() != null) {
            Integer temp = tempIds.poll();
            tempValue += values.get(temp);
            if ( tempValue > randomValue ) {
                return temp;
            }
        }
        System.out.println("Element not found");
        return -1;
    }
}

public class Runner {
    public static void main(String[] args) {
        ToyShop toyShop = new ToyShop();
        toyShop.addItem(1,25,"Пикачу");
        toyShop.addItem(2,40,"Мяч");
        toyShop.addItem(3,35,"Трактор");
        System.out.println(toyShop);
        System.out.println(toyShop.get());
        System.out.println(toyShop.get());
        System.out.println(toyShop.get());
        System.out.println(toyShop.get());
        System.out.println(toyShop.get());
        System.out.println(toyShop.get());
        System.out.println(toyShop.get());
        System.out.println(toyShop.get());
        System.out.println(toyShop.get());
        System.out.println(toyShop.get());
    }
}