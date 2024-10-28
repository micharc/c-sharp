package oop.lesson2;

public abstract class Product {

    /**
     * инициализация продукта
     * @param name название продукта
     * @param price цена
     */

    public Product(String name, int price) {
    this.name = name;
    this.price = price;
}

    private String name;
    private final int price;

    /**
     * получить название продукта
     * @return название в виде строки
     */

    public String getName() {
        return name;
    }

    /**
     * изменить название продукта
     * @param name новое название продукта
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * получить цену продукта
     * @return цена в виде целого числа
     */

    public int getPrice() {
        return price;
    }

}
