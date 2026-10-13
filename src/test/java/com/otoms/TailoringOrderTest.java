package com.otoms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TailoringOrderTest {

    @Test
    void validOrderShouldBeAccepted() {
        TailoringOrder order = new TailoringOrder(
                1,
                "Agathiyan",
                "Shirt",
                "Stitching",
                500
        );

        assertTrue(order.isValidOrder());
    }

    @Test
    void invalidOrderIdShouldBeRejected() {
        TailoringOrder order = new TailoringOrder(
                0,
                "Agathiyan",
                "Shirt",
                "Stitching",
                500
        );

        assertFalse(order.isValidOrder());
    }

    @Test
    void invalidPriceShouldBeRejected() {
        TailoringOrder order = new TailoringOrder(
                2,
                "Agathiyan",
                "Shirt",
                "Stitching",
                0
        );

        assertFalse(order.isValidOrder());
    }

    @Test
    void validStatusShouldBeUpdated() {
        TailoringOrder order = new TailoringOrder(
                3,
                "Agathiyan",
                "Shirt",
                "Stitching",
                500
        );

        assertTrue(order.updateStatus("IN_PROGRESS"));
        assertEquals("IN_PROGRESS", order.getStatus());
    }

    @Test
    void invalidStatusShouldBeRejected() {
        TailoringOrder order = new TailoringOrder(
                4,
                "Agathiyan",
                "Shirt",
                "Stitching",
                500
        );

        assertFalse(order.updateStatus("INVALID_STATUS"));
        assertEquals("PLACED", order.getStatus());
    }

    @Test
    void deliveredOrderShouldBeCompleted() {
        TailoringOrder order = new TailoringOrder(
                5,
                "Agathiyan",
                "Shirt",
                "Stitching",
                500
        );

        order.updateStatus("DELIVERED");

        assertTrue(order.isCompleted());
    }
}