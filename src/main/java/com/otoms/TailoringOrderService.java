
package com.otoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TailoringOrderService {

    private final List<TailoringOrder> orders = new ArrayList<>();

    public TailoringOrder createOrder(TailoringOrder order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }

        orders.add(order);
        return order;
    }

    public List<TailoringOrder> getAllOrders() {
        return new ArrayList<>(orders);
    }

    public Optional<TailoringOrder> getOrderById(int orderId) {
        return orders.stream()
                .filter(order -> order.getOrderId() == orderId)
                .findFirst();
    }

    public boolean deleteOrder(int orderId) {
        return orders.removeIf(order -> order.getOrderId() == orderId);
    }

    public int getOrderCount() {
        return orders.size();
    }
}
