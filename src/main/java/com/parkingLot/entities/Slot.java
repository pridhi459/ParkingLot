package com.parkingLot.entities;

import com.parkingLot.enums.SlotStatus;
import com.parkingLot.enums.vehicleColor;

import com.parkingLot.exceptions.VehicleNotFoundException;

public class Slot {
    // Slot class is used to represent a parking slot in a parking lot

    private final int slotNumber;
    private SlotStatus slotStatus;
    private Vehicle vehicle=null;
    private Ticket assignedTicket=null;

    public Slot(int slotNumber) {
        this.slotNumber = slotNumber;
        slotStatus = SlotStatus.FREE;
    }

    public Ticket park(Vehicle vehicle, Character parkingLotId) {
        if (this.slotStatus.equals(SlotStatus.FREE)) {
            this.occupySlot(vehicle);
            assignedTicket= new Ticket(this.slotNumber,vehicle.getRegisterNumber(), parkingLotId);
            return assignedTicket;
        }
        return null;
    }

    public Vehicle unPark(Ticket ticket){
        Vehicle unParkVehicle = null;
        System.out.println( this.assignedTicket.equals(ticket)+" hh");
        if (this.slotStatus.equals(SlotStatus.OCCUPIED) &&  this.assignedTicket.equals(ticket) ) {
            unParkVehicle=this.vehicle;
            this.freeSlot();
            System.out.println("Vehicle is unparked from the parking lot and Given Back.");
            return unParkVehicle;

        }
        return null;
    }

    public boolean checkIsSlotFree(SlotStatus slotStatus) {
        return this.slotStatus.equals(slotStatus) ;
    }

    public boolean checkVehicleColor(vehicleColor vehicleColor) {
        return this.vehicle.checkColor(vehicleColor);
    }

    public void freeSlot() {
        this.slotStatus = SlotStatus.FREE;
        this.vehicle=null;
    }

    public void occupySlot(Vehicle vehicle) {
        this.vehicle = vehicle;
        if(vehicle!=null){
            this.slotStatus=SlotStatus.OCCUPIED;}
        else {
            throw new VehicleNotFoundException("Vehicle cannot be null");
        }
    }
    public boolean hasRegisterNumber(String registerNumber){
        return this.vehicle.checkRegisterNumber(registerNumber);
    }

    public boolean checkVehicleAvailability() {
        return vehicle !=null ;
    }
    public boolean hasTicket(Ticket ticket){
        return this.assignedTicket.equals(ticket);
    }

    @Override
    public boolean equals(Object o){
        if (o == this) {
            return true;
        }
        if (!(o instanceof Slot)) {
            return false;
        }
        Slot otherSlot = (Slot) o;
        return this.slotNumber == otherSlot.slotNumber && this.vehicle.equals(otherSlot.vehicle) && this.assignedTicket.equals(otherSlot.assignedTicket);

    }


    public int findVehicle(String registerNo) {
        if(this.vehicle.checkRegisterNumber(registerNo)){
            return this.slotNumber;
        }
        return -1;
    }
}
