package com.otoms;

public class Customer {

    private int customerId;
    private String name;
    private String email;
    private String phone;
    private String password;

    public Customer(int customerId, String name, String email, String phone, String password) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public boolean isValidEmail() {
        return email != null && email.contains("@") && email.contains(".");
    }

    public boolean isValidPhone() {
        return phone != null && phone.matches("\\d{10}");
    }

    public boolean isValidPassword() {
        return password != null && password.length() >= 6;
    }

    public boolean isValidCustomer() {
        return name != null && !name.trim().isEmpty()
                && isValidEmail()
                && isValidPhone()
                && isValidPassword();
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}