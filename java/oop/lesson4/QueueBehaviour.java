package oop.lesson4;

public interface QueueBehaviour {

    /**
     * Пригласить покупателя из очереди
     * @param actor покупатель
     */
    void takeInQueue(Actor actor);

    /**
     * забрать заказы
     */
    void takeOrders();

    /**
     * Отдать заказы
     */
    void giveOrders();

    /**
     * Выйти из очереди
     */
    void releaseFromQueue();
}
