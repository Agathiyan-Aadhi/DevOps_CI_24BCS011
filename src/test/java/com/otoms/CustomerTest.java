package com.otoms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    @Test
    void validCustomerShouldBeAccepted() {
        Customer customer = new Customer(
                1,
                "Agathiyan",
                "agathiyan@gmail.com",
                "9876543210",
                "password123"
        );

        assertTrue(customer.isValidCustomer());
    }

    @Test
    void invalidEmailShouldBeRejected() {
        Customer customer = new Customer(
                2,
                "Agathiyan",
                "agathiyan",
                "9876543210",
                "password123"
        );

        assertFalse(customer.isValidEmail());
    }

    @Test
    void invalidPhoneShouldBeRejected() {
        Customer customer = new Customer(
                3,
                "Agathiyan",
                "agathiyan@gmail.com",
                "12345",
                "password123"
        );

        assertFalse(customer.isValidPhone());
    }

    @Test
    void shortPasswordShouldBeRejected() {
        Customer customer = new Customer(
                4,
                "Agathiyan",
                "agathiyan@gmail.com",
                "9876543210",
                "123"
        );

        assertFalse(customer.isValidPassword());
    }
}