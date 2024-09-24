package dto;

import Enums.vehicleColor;
import Enums.vehicleType;

public class Vehicle {
    private final int registerNumber;
    private final vehicleType type;
    private final vehicleColor color;
    private int parkingSlot = -1;

    public Vehicle(int registerNumber, vehicleType type, vehicleColor color) {
        this.registerNumber = registerNumber;
        this.type = type;
        this.color = color;
    }

    public void setParkingSlot(int slot) {
        this.parkingSlot = slot;
    }

    public int getParkingSlot() {
        return parkingSlot;
    }

    public boolean checkColor(vehicleColor colour) {
        return this.color == colour;
    }

    public boolean checkRegisterNumber(int RegNo) {
        return RegNo == this.registerNumber;
    }
}
