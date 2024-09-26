package com.parkingLot.Entities;

import com.parkingLot.Exceptions.*;

import java.util.ArrayList;
import java.util.List;


public class Attendant {
    // An Attendant is responsible for Managing parking and un Parking from parking lots

    private ArrayList<ParkingLot> assignedParkingLots= new ArrayList<>();
    private List<Vehicle> parkedVehiclesList = new ArrayList<Vehicle>();

    public void assign(ParkingLot parkingLot) throws DuplicateParkingLotAssignmentException, Exception {
        // Assigns a parking lot to the Attendant

      //  ParkingLot parkingLot = new ParkingLot(parkingLotWithSlots);
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
        if(!parkedVehiclesList.contains(car)){
        for (ParkingLot parkingLot : assignedParkingLots) {
            if(parkingLot.numberOfVacantSlots()>0){
                Ticket returnedTicket = parkingLot.park(car);
                parkedVehiclesList.add(car);
                return returnedTicket;
            }
        }
        throw new NoEmptySlotException("No empty slot available in any of the assigned parking lots");}
        else{
            throw new VehicleAlreadyParkedException("Vehicle is already parked");
        }
    }

    public Vehicle unPark(Ticket ticket) throws Exception{
        // UnParks a vehicle from the assigned parking lots

        if(ticket==null){
            throw new InvalidTicketException("Ticket cannot be null");
        }
        for (ParkingLot parkingLot : assignedParkingLots) {
            if(parkingLot.hasParkingLotId(ticket.getParkingLotId()) ){
                Vehicle unParkedVehicle = parkingLot.unPark(ticket);
                parkedVehiclesList.remove(unParkedVehicle);
                return unParkedVehicle;
            }
        }
        System.out.println("ParkingLot Invalid");
        throw new InvalidTicketException("No such mentioned ParkingLot is assigned to this Attendant");
    }
}
