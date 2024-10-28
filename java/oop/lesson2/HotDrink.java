package oop.lesson2;

public class HotDrink extends Product {

    /**
     * конструктор класса
     * @param name название продукта
     * @param price цена продукта
     * @param volume объем продукта
     * @param temperature температура продукта
     */

    public HotDrink (String name, int price, int volume, int temperature) {
        super(name, price);
        this.temperature = temperature;
        this.volume = volume;
    }

    private final int temperature;
    private final int volume;

    /**
     * получить температуру продукта
     * @return температура продукта как целое число
     */

    public int getTemperature() {
        return temperature;
    }

    /**
     * получить объем продукта
     * @return объем продукта как целое число
     */

    public int getVolume() {
        return volume;
    }

    /**
     * отобразить название и все параметры продукта
     * @return информация о продукте в виде строки
     */

    public String toString() {
        return String.format("name = %s, price = %d, volume = %d, temperature = %d",
                super.getName(), super.getPrice(), volume, temperature);
    }

}
