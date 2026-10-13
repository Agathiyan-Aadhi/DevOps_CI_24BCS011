package com.otoms;

public class TailoringOrder {

    private int orderId;
    private String customerName;
    private String garmentType;
    private String serviceType;
    private double price;
    private String status;

    public TailoringOrder(int orderId, String customerName,
                          String garmentType, String serviceType,
                          double price) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.garmentType = garmentType;
        this.serviceType = serviceType;
        this.price = price;
        this.status = "PLACED";
    }

    public boolean isValidOrder() {
        return orderId > 0
                && customerName != null && !customerName.trim().isEmpty()
                && garmentType != null && !garmentType.trim().isEmpty()
                && serviceType != null && !serviceType.trim().isEmpty()
                && price > 0;
    }

    public boolean updateStatus(String newStatus) {
        if (newStatus == null || newStatus.trim().isEmpty()) {
            return false;
        }

        if (newStatus.equals("PLACED")
                || newStatus.equals("CONFIRMED")
                || newStatus.equals("IN_PROGRESS")
                || newStatus.equals("READY")
                || newStatus.equals("DELIVERED")
                || newStatus.equals("CANCELLED")) {

            this.status = newStatus;
            return true;
        }

        return false;
    }

    public boolean isCompleted() {
        return status.equals("DELIVERED");
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getGarmentType() {
        return garmentType;
    }

    public String getServiceType() {
        return serviceType;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }
}