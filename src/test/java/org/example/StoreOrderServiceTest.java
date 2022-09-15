package org.example;

import org.example.entities.StoreOrder;
import org.example.steps.StoreOrderServiceSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.Random;

public class StoreOrderServiceTest {

    @Test
    public void createOrderTest() {
        // given
        StoreOrder expectedOrder = createOrder();
        // when
        StoreOrder createdOrder = StoreOrderServiceSteps.createOrder(expectedOrder);
        // then
        Assert.assertEquals(createdOrder, expectedOrder.setId(createdOrder.getId()), "Expected order does not match created one");
    }

    private StoreOrder createOrder() {
        Random random = new Random();
        return new StoreOrder()
                .setPetId(random.nextInt())
                .setQuantity(1)
                .setShipDate(new Date())
                .setStatus(StoreOrder.Status.delivered)
                .setComplete(true);
    }

    @Test
    public void getOrderByIdTest() {
        // given
        StoreOrder createdOrder = StoreOrderServiceSteps.createOrder(createOrder());
        // when
        StoreOrder actualOrder = StoreOrderServiceSteps.getOrderById(createdOrder.getId());
        // then
        Assert.assertEquals(actualOrder, createdOrder, "Expected order does not match created one");
    }

    @Test(expectedExceptions = AssertionError.class)
    public void deleteOrderByIdTest() {
        // given
        StoreOrder createdOrder = StoreOrderServiceSteps.createOrder(createOrder());
        // when
        StoreOrderServiceSteps.deleteUserById(createdOrder.getId());
        // then
        StoreOrderServiceSteps.getOrderById(createdOrder.getId());
    }
}
