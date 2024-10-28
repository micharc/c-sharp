package oop.lesson2;

public class Main {

    public static void main(String[] args) {
        VendingMachineHotDrinks myVending = new VendingMachineHotDrinks();
        myVending.addProduct("капучино", 155, 500, 25);

        myVending.getProduct("кофе");
        myVending.getProduct("кофе", 200, 90);
        myVending.getProduct("кофе", 250, 90);
        myVending.getProduct("горячая вода", 200, 80);
        myVending.getProduct("горячая вода");
        myVending.getProduct("чай");
        myVending.getProduct("эспрессо");
        myVending.getProduct("капучино");

        System.out.print(myVending);
    }
}
