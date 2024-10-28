package oop.lesson2;

import java.util.ArrayList;
import java.util.List;

public class VendingMachineHotDrinks implements VendingMachine {

    private final List<HotDrink> productList;
    private int money;

    /**
     * основной конструктор
     */
    public VendingMachineHotDrinks() {
        this.productList = initProduct();
        money = 0;
        System.out.print(this);
    }

    /**
     * выдать продукт из аппарата по названию
     * @param name название продукта
     */
    @Override
    public void getProduct(String name) {
        for (HotDrink product : productList) {
            if (product.getName().equals(name)) {
                money += product.getPrice();
                System.out.print("Выдан продукт: " + product + "\n");
                return;
            }
        }
        System.out.printf("Продукта '%s' в аппарате не Найдено!\n", name);
    }

    /**
     * выдать продукт из аппарата по названию, объему и температуре
     * @param name название
     * @param volume объем
     * @param temperature температура
     */
    public void getProduct(String name, int volume, int temperature) {
        for (HotDrink product : productList) {
            if (product.getName().equals(name) && product.getVolume() == volume && product.getTemperature() == temperature) {
                money += product.getPrice();
                System.out.print("Выдан продукт: " + product + "\n");
                return;
            }
        }
        System.out.printf("Продукта '%s', объёмом %d и температурой %d в аппарате не Найдено!\n",
                name, volume, temperature);
    }

    /**
     * инициализировать список товаров позициями по умолчанию
     * @return список товаров
     */
    public List<HotDrink> initProduct() {
        List<HotDrink> products = new ArrayList<>();
        products.add(new HotDrink("кофе", 100, 200, 90));
        products.add(new HotDrink("чай", 70, 250, 95));
        products.add(new HotDrink("горячая вода", 20, 200, 80));
        return products;
    }

    /**
     * сформировать отчёт о состоянии аппарата - сумму накомленных денег и список товаров
     * @return отчёт о состоянии
     */
    @Override
    public String toString() {
        String result = String.format("\nОтчёт по вендингу с горячими напитками\nНакопленная сумма = %d руб.\nСписок напитков:\n", money);
        for (HotDrink product : productList) {
            result = result.concat(product.toString()).concat("\n");
        }
        return result + "\n";
    }

    /**
     * добавить новый напиток в аппарат
     * @param name название напитка
     * @param price цена
     * @param volume объем
     * @param temperature температура
     */
    public void addProduct(String name, int price, int volume, int temperature) {
        this.productList.add(new HotDrink(name, price, volume, temperature));
    }

}
