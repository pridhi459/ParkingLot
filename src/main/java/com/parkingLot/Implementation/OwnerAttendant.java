package com.parkingLot.Implementation;

import com.parkingLot.Interface.Attendant;
import com.parkingLot.Interface.Notifiable;
import com.parkingLot.entities.ParkingLot;
import com.parkingLot.entities.Ticket;
import com.parkingLot.entities.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OwnerAttendant implements Attendant, Notifiable {

    private String ownerID;
    private List<ParkingLot> ownedParkingLots = new ArrayList<>();
    private List<ParkingLot> ownerAssignedParkingLots = new ArrayList<>();

    public OwnerAttendant() {
        this.ownerID = UUID.randomUUID().toString();
    }

    public ParkingLot createParkingLot(int lotSize) throws Exception {

        ParkingLot lot = new ParkingLot(lotSize);
        this.ownedParkingLots.add(lot);
        return lot;
    }

    public Ticket park(Vehicle vehicle) {


        return null;
    }

    @Override
    public Vehicle unPark(Ticket ticket) throws Exception {
        return null;
    }


    public void assignAttendant(ParkingLot lot1, AssistantAttendant attendant1) throws Exception {
        if (lot1 == null || attendant1 == null) {
            throw new Exception("Parking lot cannot be null");
        }
        if (ownedParkingLots.contains(lot1)) {
            attendant1.assign(lot1);
        } else {
            throw new Exception("Parking lot is not owned by the owner");
        }
    }


    @Override
    public boolean notifyParkingFull(ParkingLot parkingLot) {
return false;
    }

    @Override
    public void notifyParkingAvailable(ParkingLot parkingLot) {
return;
    }
}

