package com.parkingLot.Entities;

import com.parkingLot.Exceptions.DuplicateParkingLotAssignmentException;
import com.parkingLot.Exceptions.NoEmptySlotException;

import java.util.ArrayList;


public class Attendant {
    // An Attendant is responsible for Managing parking and unparking from parking lots

    private ArrayList<ParkingLot> assignedParkingLots= new ArrayList<>();


    public void assign(ParkingLot parkingLot) throws DuplicateParkingLotAssignmentException {
        // Assigns a parking lot to the Attendant
        if(assignedParkingLots.contains(parkingLot)){
            throw new DuplicateParkingLotAssignmentException("Parking lot is already assigned to the Attendant");
        }
        assignedParkingLots.add(parkingLot);

    }


    public Ticket park(Vehicle car) throws Exception {
        if(car==null){
            throw new Exception("Vehicle cannot be null");
        }
        for (ParkingLot parkingLot : assignedParkingLots) {
            if(parkingLot.getVacantSlots()>0){
                System.out.println("Vacant Slots : "+ parkingLot.getVacantSlots());
                return parkingLot.park(car);
            }
        }
        throw new NoEmptySlotException("No empty slot available in any of the assigned parking lots");
    }

    public Vehicle unPark(Ticket ticket){
        for (ParkingLot parkingLot : assignedParkingLots) {
            if(parkingLot.getParkingLotId().equals(ticket.getParkingLotId())){
                return parkingLot.unPark(ticket);
            }
        }
        return null;
    }
}
