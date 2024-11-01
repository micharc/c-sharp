package oop.lesson4;

public interface ActorBehaviour {
    /**
     * Создание нового заказа
     * @param makeOrder статус заказа - создан или нет?
     */
    void setMakeOrder(boolean makeOrder);

    /**
     * Установка статуса получения заказа покупателем
     * @param takeOrder забрал покупатель заказ или нет?
     */
    void setTakeOrder(boolean takeOrder);

    /**
     * Статус заказа
     * @return создан заказ или нет?
     */
    boolean isMakeOrder();

    /**
     * Статус получения заказа
     * @return забрал покупатель заказ или нет?
     */
    boolean isTakeOrder();
}
