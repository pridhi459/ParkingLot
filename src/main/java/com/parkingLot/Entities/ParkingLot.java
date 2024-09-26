package com.parkingLot.Entities;

import com.parkingLot.Enums.SlotStatus;
import com.parkingLot.Enums.vehicleColor;
import com.parkingLot.Exceptions.InvalidTicketException;
import com.parkingLot.Exceptions.NoEmptySlotException;
import com.parkingLot.Exceptions.VehicleCannotBeNULL;
import com.parkingLot.Exceptions.VehicleNotFoundException;

public class ParkingLot {
    //Parking Lot describes the responsibilities of Parking lot with finite set of slots

    private final Character parkingLotId;
    private final Slot[] Slots;

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
        if(vehicle==null){
            throw new VehicleCannotBeNULL("Vehicle cannot be null");
        }

        for (Slot slot : Slots) {
            if(slot.checkSlotStatus(SlotStatus.FREE)){
                return slot.park(vehicle, parkingLotId);
            }
        }
        throw new NoEmptySlotException("Parking Lot is Full");
    }

    public Vehicle unPark(Ticket ticket) throws InvalidTicketException {
        if(ticket==null){
            throw new InvalidTicketException("Ticket cannot be null");
        }
        Vehicle unParkVehicle = null;

        for (Slot slot : Slots) {
            System.out.println(ticket.getParkingLotId()+" "+ticket.getSlotNumber());
            if(slot.hasTicket(ticket)){
                return slot.unPark(ticket);
            }
        }
        System.out.println("Vehicle with Register number "+ ticket.getRegistrationNumber()+" is not parked in the parking lot.");
        throw new InvalidTicketException("Vehicle not found in parking to be un Parked");
    }

    public int getNumberOfCarsByColor(vehicleColor vehicleColor) {
        if(vehicleColor==null){
            throw new VehicleCannotBeNULL("Vehicle Color cannot be null");
        }
        int count = 0;
        for (Slot slot : Slots) {
            if (slot.checkSlotStatus(SlotStatus.OCCUPIED) && slot.checkVehicleColor(vehicleColor) ) {
                count++;
            }
        }
        return count;
    }

    public int findVehicleSlotByRegistrationNumber(String registerNo) {
        for (Slot slot : Slots) {
            if (slot.checkSlotStatus(SlotStatus.OCCUPIED) && slot.hasRegisterNumber(registerNo)) {
                return slot.getSlotNumber();
            }
        }

        System.out.println("A Vehicle with Register No. "+ registerNo+" is not parked in the parking lot.");
        throw new VehicleNotFoundException("Vehicle not found");
    }

    public int numberOfVacantSlots() {
        //Returns the number of vacant slots in the parking lot

        int capacity=0;
        for(Slot slot: Slots){
            if(slot.checkSlotStatus(SlotStatus.FREE)){
                capacity++;
            }
        }
        return capacity;
    }

    public boolean hasParkingLotId( String parkingLotId) {
        return Character.toString(this.parkingLotId).equals(parkingLotId);
    }
}
