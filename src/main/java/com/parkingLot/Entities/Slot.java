package com.parkingLot.Entities;

public class Slot {

    // Slot class is used to represent a parking slot in a parking lot
    private final int slotNumber;
    private boolean isOccupied=false;
    private Vehicle vehicle=null;

    public Slot(int slotNumber) {

        this.slotNumber = slotNumber;

    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
