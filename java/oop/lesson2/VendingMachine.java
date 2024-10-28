package oop.lesson2;

import java.util.List;

public interface VendingMachine {

    /**
     * Взять продукт из вендинговоро автомата
     * @param name название продукта
     */

    void getProduct(String name);

    /**
     * Вывести в консоль список продуктов в вендинковом автомате
     * и общую сумму, оплаченную клиентами за товары
     */

    String toString();

    /**
     * Иницализировать продукты в вендинговом аппарате товарами по умолчанию
     * @return список продуктов в вендинговом автомате
     */

    List<HotDrink> initProduct();

}
