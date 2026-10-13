package com.otoms;

public class Measurement {

    private double chest;
    private double waist;
    private double shoulder;
    private double sleeve;
    private double length;

    public Measurement(double chest, double waist, double shoulder,
                       double sleeve, double length) {
        this.chest = chest;
        this.waist = waist;
        this.shoulder = shoulder;
        this.sleeve = sleeve;
        this.length = length;
    }

    public boolean isValidMeasurement() {
        return chest > 0
                && waist > 0
                && shoulder > 0
                && sleeve > 0
                && length > 0;
    }

    public boolean isWithinStandardRange() {
        return chest >= 20 && chest <= 60
                && waist >= 20 && waist <= 60
                && shoulder >= 10 && shoulder <= 30
                && sleeve >= 10 && sleeve <= 40
                && length >= 20 && length <= 60;
    }

    public double getChest() {
        return chest;
    }

    public double getWaist() {
        return waist;
    }

    public double getShoulder() {
        return shoulder;
    }

    public double getSleeve() {
        return sleeve;
    }

    public double getLength() {
        return length;
    }
}