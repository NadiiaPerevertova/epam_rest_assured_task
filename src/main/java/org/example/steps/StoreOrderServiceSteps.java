package org.example.steps;

import org.example.entities.StoreOrder;
import org.example.service.StoreOrderService;

public class StoreOrderServiceSteps {
    private static final StoreOrderService STORE_ORDER_SERVICE = StoreOrderService.getInstance();

    private StoreOrderServiceSteps() {
    }

    public static StoreOrder getOrderById(long id) {
        return STORE_ORDER_SERVICE.getOrderById(id).as(StoreOrder.class);
    }

    public static StoreOrder createOrder(StoreOrder order) {
        return STORE_ORDER_SERVICE.createOrder(order).as(StoreOrder.class);
    }

    public static void deleteUserById(long id) {
        STORE_ORDER_SERVICE.deleteOrderById(id);
    }
}
