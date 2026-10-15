
package com.otoms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TailoringOrderServiceTest {

    private TailoringOrderService service;

    @BeforeEach
    void setUp() {
        service = new TailoringOrderService();
    }

    @Test
    void serviceShouldStartWithNoOrders() {
        assertEquals(0, service.getOrderCount());
        assertTrue(service.getAllOrders().isEmpty());
    }

    @Test
    void creatingNullOrderShouldThrowException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> service.createOrder(null)
        );
    }

    @Test
    void shouldCreateAndCountOrder() {
        TailoringOrder order = new TailoringOrder(
                101, "Arun", "Shirt", "Stitching", 500
        );

        TailoringOrder created = service.createOrder(order);

        assertSame(order, created);
        assertEquals(1, service.getOrderCount());
    }

    @Test
    void shouldRetrieveOrderById() {
        TailoringOrder order = new TailoringOrder(
                102, "Kumar", "Trousers", "Alteration", 300
        );
        service.createOrder(order);

        Optional<TailoringOrder> result = service.getOrderById(102);

        assertTrue(result.isPresent());
        assertEquals(102, result.get().getOrderId());
    }

    @Test
    void shouldReturnEmptyWhenOrderDoesNotExist() {
        assertTrue(service.getOrderById(999).isEmpty());
    }

    @Test
    void shouldReturnAllOrders() {
        service.createOrder(new TailoringOrder(
                103, "Ravi", "Shirt", "Stitching", 450
        ));
        service.createOrder(new TailoringOrder(
                104, "Priya", "Dress", "Custom Stitching", 1200
        ));

        List<TailoringOrder> orders = service.getAllOrders();

        assertEquals(2, orders.size());
    }

    @Test
    void shouldDeleteExistingOrder() {
        service.createOrder(new TailoringOrder(
                105, "Mani", "Shirt", "Stitching", 500
        ));

        assertTrue(service.deleteOrder(105));
        assertEquals(0, service.getOrderCount());
        assertTrue(service.getOrderById(105).isEmpty());
    }

    @Test
    void shouldReturnFalseWhenDeletingMissingOrder() {
        assertFalse(service.deleteOrder(999));
    }
}
