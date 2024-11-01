package oop.lesson4;

import java.util.ArrayList;
import java.util.List;

public class Market implements MarketBehaviour, QueueBehaviour {

    private final List<Actor> queue;
    private int iterationNumber;

    public Market() {
        queue = new ArrayList<>();
        iterationNumber = 0;
    }

    /**
     * Покупатель пришёл в магазин, добавляем его в очередь
     * @param actor покупатель
     */
    @Override
    public void acceptToMarket(Actor actor) {
        System.out.printf("Market.acceptToMarket: покупатель %s вошёл в магазин\n", actor.getName());
        actor.setMakeOrder(false);
        actor.setTakeOrder(false);
        takeInQueue(actor);
    }

    /**
     * Добавление покупателя в очередь
     * @param actor покупатель
     */
    @Override
    public void takeInQueue(Actor actor) {
        queue.add(actor);
        System.out.printf("Market.takeInQueue: покупатель %s встал в очередь\n", actor.getName());
    }

    /**
     * Проверить покупателей в очереди, проставить флаг готовности заказа, если его ещё нет
     */
    @Override
    public void takeOrders() {
        for (Actor a : queue) {
            if (!a.isMakeOrder()) {
                a.setMakeOrder(true);
                System.out.printf("Market.takeOrders: покупатель %s сделал заказ\n", a.getName());
            }
        }
    }

    /**
     * Выдать заказы покупателям в очереди, у которых уже есть готовый заказ
     */
    @Override
    public void giveOrders() {
        for (Actor a : queue) {
            if (a.isMakeOrder()) {
                a.setTakeOrder(true);
                System.out.printf("Market.giveOrders: покупатель %s забрал заказ\n", a.getName());
            }
        }
    }

    /**
     * Создать список покупателей, которые готовы выходить из магазина
     */
    @Override
    public void releaseFromQueue() {
        List <Actor> actorList = new ArrayList<>();
        for (Actor a : queue) {
            if (a.isMakeOrder() && a.isTakeOrder()) {
                actorList.add(a);
                System.out.printf("Market.releaseFromQueue: покупатель %s выходит из магазина\n", a.getName());
            }
        }
        releaseFromMarket(actorList);
    }

    /**
     * Удаляем покупателей из магазина
     * @param actorList список покупателей
     */
    @Override
    public void releaseFromMarket(List<Actor> actorList) {
        for (Actor a : actorList) {
            queue.remove(a);
            System.out.printf("Market.releaseFromMarket: покупатель %s вышел из магазина\n", a.getName());
        }
    }

    /**
     * Обновить статусы в очереди
     */
    @Override
    public void update() {
        if (actorsInMarket()) {
            System.out.printf("\nMarket.update: итерация номер %d\n", iterationNumber);
            takeOrders();
            giveOrders();
            releaseFromQueue();
        } else {
            System.out.printf("\nMarket.update: итерация номер %d, в магазине нет покупателей\n", iterationNumber);
        }
        iterationNumber += 1;
    }

    /**
     * Проверка наличия покупателей в магазине
     * @return true - покупатели ещё есть
     */
    public boolean actorsInMarket() {
        return !queue.isEmpty();
    }

}
