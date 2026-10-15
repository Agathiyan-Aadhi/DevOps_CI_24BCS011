package com.otoms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MeasurementTest {

    @Test
    void validMeasurementShouldBeAccepted() {
        Measurement measurement = new Measurement(
                40, 36, 18, 24, 40
        );

        assertTrue(measurement.isValidMeasurement());
    }

    @Test
    void negativeMeasurementShouldBeRejected() {
        Measurement measurement = new Measurement(
                -1, 36, 18, 24, 40
        );

        assertFalse(measurement.isValidMeasurement());
    }

    @Test
    void zeroMeasurementShouldBeRejected() {
        Measurement measurement = new Measurement(
                0, 36, 18, 24, 40
        );

        assertFalse(measurement.isValidMeasurement());
    }

    @Test
    void standardMeasurementShouldBeWithinRange() {
        Measurement measurement = new Measurement(
                40, 36, 18, 24, 40
        );

        assertTrue(measurement.isWithinStandardRange());
    }

    @Test
     void measurementAtStandardUpperLimitsShouldBeWithinRange() {
        Measurement measurement = new Measurement(
                60, 60, 30, 40, 60
        );

        assertTrue(measurement.isWithinStandardRange());
    }

    
    @Test
    void measurementAboveStandardUpperLimitShouldBeOutsideRange() {
        Measurement measurement = new Measurement(
                61, 60, 30, 40, 60
        );

        assertFalse(measurement.isWithinStandardRange());
    }


}
