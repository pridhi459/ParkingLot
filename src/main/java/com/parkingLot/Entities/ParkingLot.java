package com.parkingLot.Entities;

import com.parkingLot.Enums.SlotStatus;
import com.parkingLot.Enums.vehicleColor;
import com.parkingLot.Exceptions.SlotNotFoundException;
import com.parkingLot.Exceptions.VehicleNotFoundException;

public class ParkingLot {
    //Parking Lot describes the responsibilities of Parking lot with finite set of slots

    private final Character parkingLotId;
    private final Slot[] Slots;
    static int ticketCount=0;
    static Character parkingLotIdIncrementer ='@';


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
        parkingLotId= ++ parkingLotIdIncrementer;
    }

    public Ticket park(Vehicle vehicle) throws Exception{
        for (Slot slot : Slots) {
            if (slot.getSlotStatus().equals(SlotStatus.FREE)) {
                slot.setVehicle(vehicle);
                return new Ticket(++ticketCount,slot.getSlotNumber(),vehicle.getRegisterNumber(), parkingLotId);
            }
        }
        throw new Exception("Parking lot is full");
    }

    public Vehicle unPark(Ticket ticket) throws VehicleNotFoundException {
        Vehicle unParkVehicle = null;
        boolean slotFound=false;
        for (Slot slot : Slots) {
            if (slot.getSlotStatus().equals(SlotStatus.OCCUPIED) && slot.getSlotNumber()== ticket.getSlotNumber() ) {
                slotFound=true;
                unParkVehicle=slot.getVehicle();
                if(slot.getVehicle().checkRegisterNumber(ticket.getRegistrationNumber())){
                    slot.setVehicle(null);
                    System.out.println("Vehicle is unparked from the parking lot and Given Back.");
                    return unParkVehicle;}
            }
        }
        if(!slotFound){
            throw new SlotNotFoundException("Invalid Ticket, Slot not found in Parking Lot ");
        }
        System.out.println("Vehicle with Register number "+ ticket.getRegistrationNumber()+" is not parked in the parking lot.");
        throw new VehicleNotFoundException("Vehicle not found in parking to be unparked");
    }

    public int getNumberOfCarsByColor(vehicleColor vehicleColor) {
        int count = 0;
        for (Slot slot : Slots) {
            if (slot.getSlotStatus().equals(SlotStatus.OCCUPIED) && slot.getVehicle().checkColor(vehicleColor) ) {
                count++;
            }
        }
        return count;
    }

    public int findVehicleSlotByRegistrationNumber(String registerNo) {
        for (Slot slot : Slots) {
            if (slot.getSlotStatus().equals(SlotStatus.OCCUPIED) && slot.getVehicle().checkRegisterNumber(registerNo)) {
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
            if(slot.getSlotStatus().equals(SlotStatus.FREE)){
                capacity++;
            }
        }
        return capacity;
    }

    public boolean checkEmptySlot(int slotId) throws Exception{
        //Check if the slot is empty or not
        for(Slot slot: Slots){
            if(slot.getSlotNumber()==slotId){
                return slot.getSlotStatus().equals(SlotStatus.FREE) || slot.getVehicle() == null;
            }
        }
        throw new Exception("Slot not found");
    }

    public Character getParkingLotId() {
        return parkingLotId;
    }
}
