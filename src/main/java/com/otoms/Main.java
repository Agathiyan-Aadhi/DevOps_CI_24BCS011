
package com.otoms;

public class Main {

    public static void main(String[] args) {

        TailoringOrderService service = new TailoringOrderService();

        TailoringOrder order1 = new TailoringOrder(
                101, "Arun", "Shirt", "Stitching", 500
        );

        TailoringOrder order2 = new TailoringOrder(
                102, "Priya", "Dress", "Custom Stitching", 1200
        );

        service.createOrder(order1);
        service.createOrder(order2);

        System.out.println("ONLINE TAILORING ORDER MANAGEMENT SYSTEM");
        System.out.println("-----------------------------------------");

        System.out.println("\nAll Tailoring Orders:");

        for (TailoringOrder order : service.getAllOrders()) {
            System.out.println(
                    "Order ID: " + order.getOrderId()
                    + " | Customer: " + order.getCustomerName()
                    + " | Garment: " + order.getGarmentType()
                    + " | Service: " + order.getServiceType()
                    + " | Price: Rs. " + order.getPrice()
                    + " | Status: " + order.getStatus()
            );
        }

        order1.updateStatus("IN_PROGRESS");

        System.out.println("\nUpdated Order 101 Status: "
                + order1.getStatus());

        System.out.println("\nTotal Orders: "
                + service.getOrderCount());
    }
}
