package com.parkingLot.Entities;

import com.parkingLot.Exceptions.DuplicateParkingLotAssignmentException;
import com.parkingLot.Exceptions.NoEmptySlotException;
import com.parkingLot.Exceptions.VehicleNotFoundException;

import java.util.ArrayList;


public class Attendant {
    // An Attendant is responsible for Managing parking and unparking from parking lots

    private ArrayList<ParkingLot> assignedParkingLots= new ArrayList<>();

    public void assign(int parkingLotWithSlots) throws DuplicateParkingLotAssignmentException, Exception {
        // Assigns a parking lot to the Attendant

        ParkingLot parkingLot = new ParkingLot(parkingLotWithSlots);
        if(assignedParkingLots.contains(parkingLot)){
            throw new DuplicateParkingLotAssignmentException("Parking lot is already assigned to the Attendant");
        }
        assignedParkingLots.add(parkingLot);
    }

    public Ticket park(Vehicle car) throws Exception {
        // Parks a vehicle in the assigned parking lots

        if(car==null){
            throw new Exception("Vehicle cannot be null");
        }
        for (ParkingLot parkingLot : assignedParkingLots) {
            if(parkingLot.getVacantSlots()>0){
                return parkingLot.park(car);
            }
        }
        throw new NoEmptySlotException("No empty slot available in any of the assigned parking lots");
    }

    public Vehicle unPark(Ticket ticket) throws Exception{
        for (ParkingLot parkingLot : assignedParkingLots) {
            if(Character.toString(parkingLot.getParkingLotId()).equals(ticket.getParkingLotId()) ){
                return parkingLot.unPark(ticket);
            }
        }
        System.out.println("Parking lot Invalid");
        throw new VehicleNotFoundException("Vehicle not found in any of the assigned parking lots");
    }
}
