package org.example.service;

import io.restassured.response.Response;
import org.example.service.uritemplate.UriTemplate;

public class StoreOrderService extends CommonService {
    private static StoreOrderService instance;

    public static StoreOrderService getInstance() {
        if (instance == null) {
            instance = new StoreOrderService();
        }
        return instance;
    }

    private StoreOrderService() {
    }

    private static final UriTemplate STORE_ORDER = new UriTemplate("store/order");
    private static final UriTemplate STORE_ORDER_BY_ID = new UriTemplate("store/order/%s");

    public Response getOrderById(long id) {
        return super.getRequest(STORE_ORDER_BY_ID.getUri(id));
    }

    public Response createOrder(Object body) {
        return super.postRequest(STORE_ORDER.getUri(), body);
    }

    public void deleteOrderById(long id) {
        super.deleteRequest(STORE_ORDER_BY_ID.getUri(id));
    }
}
