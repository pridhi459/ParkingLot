package com.parkingLot.Entities;

import com.parkingLot.Enums.vehicleColor;
import com.parkingLot.Enums.vehicleType;

public class Vehicle {
    // Vehicle class represents the vehicle entity with the following attributes

    private final String registerNumber;
    private final vehicleType type;
    private final vehicleColor color;


    public Vehicle(String registerNumber, vehicleType type, vehicleColor color) {
        this.registerNumber = registerNumber;
        this.type = type;
        this.color = color;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public boolean checkColor(vehicleColor colour) {
        return this.color == colour;
    }

    public boolean checkRegisterNumber(String RegNo) {
        return RegNo.equals(this.registerNumber);
    }
}
