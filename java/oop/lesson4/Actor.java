package oop.lesson4;

public abstract class Actor implements ActorBehaviour {
    /**
     * Статус получения заказа - забран клиентом или нет?
     */
    protected boolean isTakeOrder;

    /**
     * Статус заказа - создан или нет?
     */
    protected boolean isMakeOrder;

    /**
     * Имя клиента
     */
    protected final String name;

    public Actor(String name) {
        this.name = name;
    }

    public abstract String getName();

}
