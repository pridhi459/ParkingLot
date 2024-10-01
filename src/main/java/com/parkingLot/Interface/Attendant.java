package com.parkingLot.Interface;

import com.parkingLot.entities.ParkingLot;
import com.parkingLot.entities.Ticket;
import com.parkingLot.entities.Vehicle;

import java.util.ArrayList;
import java.util.List;

public interface Attendant {
    public List<ParkingLot> assignedParkingLots = new ArrayList<>();

    public Ticket park(Vehicle vehicle)throws Exception;

    public Vehicle unPark(Ticket ticket) throws Exception;

}
