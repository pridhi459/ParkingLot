package com.parkingLot.Entities;

import com.parkingLot.Enums.vehicleColor;
import com.parkingLot.Exceptions.VehicleNotFoundException;

public class ParkingLot {
    //Parking Lot describles the responsibilities of Parking lot with finite set of slots

    static String parkingLotId="A";
    private final Slot[] Slots;
    static int ticketCount=0;


    public ParkingLot(int numberOfSlots) throws Exception{

        if (numberOfSlots>0){
            Slots = new Slot[numberOfSlots];
            for (int i = 0; i < numberOfSlots; i++) {
                Slots[i] = new Slot(i);
            }
        }
        else{
            throw new Exception("Parking lot cannot be created with 0 or negative slots");
        }
    }

    public Ticket park(Vehicle vehicle) throws Exception{
        for (Slot slot : Slots) {
            if (!slot.isOccupied()) {
                slot.setOccupied(true);
                slot.setVehicle(vehicle);
                return new Ticket(++ticketCount,slot.getSlotNumber(),vehicle.getRegisterNumber(),parkingLotId);
            }
        }
        throw new Exception("Parking lot is full");
    }

    public Vehicle unPark(Ticket ticket) throws VehicleNotFoundException {
        Vehicle unParkVehicle = null;
        for (Slot slot : Slots) {
            if (slot.isOccupied() && slot.getSlotNumber()== ticket.getSlotNumber()) {
                unParkVehicle=slot.getVehicle();
                slot.setOccupied(false);
                slot.setVehicle(null);
                System.out.println("Vehicle is unparked from the parking lot and Given Back.");
                return unParkVehicle;
            }
        }
        System.out.println("A Vehicle is not parked in the parking lot.");
        throw new VehicleNotFoundException("Vehicle not found in parking to be unparked");
    }

    public int getNumberOfCarsOfColor(vehicleColor vehicleColor) {
        int count = 0;
        for (Slot slot : Slots) {
            if (slot.isOccupied() && slot.getVehicle().checkColor(vehicleColor) ) {
                count++;
            }
        }
        return count;
    }

    public int findVehicleSlotByRegistrationNumber(String registerNo) {
        for (Slot slot : Slots) {
            if (slot.isOccupied() && slot.getVehicle().checkRegisterNumber(registerNo)) {
                return slot.getSlotNumber();
            }
        }

        System.out.println("A Vehicle with Register No. "+ registerNo+" is not parked in the parking lot.");
        throw new VehicleNotFoundException("Vehicle not found");
    }

    public int getVacantSlots() {
        //Returns the number of vacant slots in the parking lot
        int capacity=0;
        for(Slot slot: Slots){
            if(!slot.isOccupied()){
                capacity++;
            }
        }
        return capacity;
    }

    public boolean checkEmptySlot(int slotId) throws Exception{
        //Check if the slot is empty or not
        for(Slot slot: Slots){
            if(slot.getSlotNumber()==slotId){
                return !slot.isOccupied() || slot.getVehicle() == null;
            }
        }
        throw new Exception("Slot not found");
    }

    public String getParkingLotId() {
        return parkingLotId;
    }
}
