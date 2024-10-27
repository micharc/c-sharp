package OOP.lesson2;

//import OOP.lesson2.VendingMachineHotDrinks;

public class Main {
    VendingMachineHotDrinks apparat1 = new VendingMachineHotDrinks();
    HotDrink item1 = apparat1.getProduct("кофе");
    System.out.println(item1.getTemperature());

}
