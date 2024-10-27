package OOP.lesson2;

public class HotDrink extends Product {

    public HotDrink (String name, int price) {
        super(name, price);
        temperature = 0;
        volume = 200;
    }

    public HotDrink (String name, int price, int volume) {
        super(name, price);
        temperature = 0;
        this.volume = volume;
    }

    public HotDrink (String name, int price, int volume, int temperature) {
        super(name, price);
        this.temperature = temperature;
        this.volume = volume;
    }

    private int temperature;
    private int volume;

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    public String toString() {
        System.out.println
    }

}
