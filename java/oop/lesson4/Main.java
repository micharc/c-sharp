package oop.lesson4;

/**
 * Чарков Михаил, номер группы мне неизвестен :)
 */

public class Main {

    public static void main(String[] args) {

        Human a1 = new Human("Вася");
        Human a2 = new Human("Петя");
        Human a3 = new Human("Борис");
        Human a4 = new Human("Вова");

        Market magnit = new Market();

        magnit.acceptToMarket(a1);
        magnit.update();

        magnit.acceptToMarket(a2);
        magnit.acceptToMarket(a3);
        magnit.update();
        magnit.update();

        magnit.acceptToMarket(a1);
        magnit.acceptToMarket(a4);
        magnit.acceptToMarket(a2);
        magnit.update();

        magnit.update();
        magnit.update();
    }
}
