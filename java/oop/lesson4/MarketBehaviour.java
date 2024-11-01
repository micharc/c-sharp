package oop.lesson4;

import java.util.List;

public interface MarketBehaviour {

    /**
     * Пригласить покупателя в магазин
     * @param actor покупатель
     */
    void acceptToMarket(Actor actor);

    /**
     * Вывести покупателей из магазина
     * @param actorList список покупателей
     */
    void releaseFromMarket(List<Actor> actorList);

    void update();
}
