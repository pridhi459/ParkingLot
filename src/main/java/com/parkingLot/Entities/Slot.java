package com.parkingLot.Entities;

import com.parkingLot.Enums.SlotStatus;

public class Slot {
    // Slot class is used to represent a parking slot in a parking lot

    private final int slotNumber;
    private SlotStatus slotStatus;
    private Vehicle vehicle=null;

    public Slot(int slotNumber) {
        this.slotNumber = slotNumber;
        slotStatus = SlotStatus.FREE;

    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public SlotStatus getSlotStatus() {
        return slotStatus;
    }

    public void freeSlot() {
        this.slotStatus = SlotStatus.FREE;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        if(vehicle!=null){
            this.slotStatus=SlotStatus.OCCUPIED;}
        else {
            this.slotStatus=SlotStatus.FREE;
        }
    }

}
