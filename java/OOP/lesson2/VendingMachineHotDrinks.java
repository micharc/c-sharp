package OOP.lesson2;

import java.util.ArrayList;
import java.util.List;

public class VendingMachineHotDrinks implements VendingMachine {

    private final List<HotDrink> productlist;
    private int money;
    List<HotDrink> productList;

    public VendingMachineHotDrinks() {
        this.productlist = initProduct();
        money = 0;
    }

    @Override
    public HotDrink getProduct(String name) {
        for (HotDrink product : productlist) {
            if (product.getName().equals(name)) {
                money += product.getPrice();
                return product;
            }
        }
        return null;
    }

    public int getMoney() {
        return money;
    }

    public List<HotDrink> initProduct() {
        List<HotDrink> products = new ArrayList<>();
        products.add(new HotDrink("кофе", 100, 200));
        products.add(new HotDrink("чай", 70, 250, 95));
        products.add(new HotDrink("вода", 20, 200, 20));
        return products;
    }

}
