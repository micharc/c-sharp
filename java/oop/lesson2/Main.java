package oop.lesson2;

/**
 * Чарков Михаил, номер группы мне неизвестен :)
 */

public class Main {

    public static void main(String[] args) {
        VendingMachineHotDrinks myVending1 = new VendingMachineHotDrinks("г. Москва, Энтузиастов 121");
        myVending1.addProduct("капучино", 155, 500, 90);

        myVending1.getProduct("кофе");
        myVending1.getProduct("кофе", 200, 90);
        myVending1.getProduct("кофе", 250, 90);
        myVending1.getProduct("горячая вода", 200, 80);
        myVending1.getProduct("горячая вода");
        myVending1.getProduct("чай");
        myVending1.getProduct("эспрессо");
        myVending1.getProduct("капучино");

        System.out.print(myVending1);

        VendingMachineHotDrinks myVending2 = new VendingMachineHotDrinks("г. Тверь, Каштановая 42");
        myVending2.addProduct("латте", 455, 200, 89);

        myVending2.getProduct("кофе");
        myVending2.getProduct("кофе", 200, 90);
        myVending2.getProduct("кофе", 250, 90);
        myVending2.getProduct("горячая вода", 200, 80);
        myVending2.getProduct("горячая вода", 100, 80);
        myVending2.getProduct("горячая вода");
        myVending2.getProduct("чай");
        myVending2.getProduct("американа");
        myVending2.getProduct("латте");

        System.out.print(myVending2);

    }
}
