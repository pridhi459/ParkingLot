package com.parkingLot.entities;

import com.parkingLot.Interface.Notifiable;
import com.parkingLot.enums.SlotStatus;

import java.util.HashMap;

public class Policeman implements Notifiable {

    private String policemanID;
    private HashMap<ParkingLot, SlotStatus> parkingLots = new HashMap<>();
    public Policeman() {
    }

    public void assignParkingLot(ParkingLot lot){
        parkingLots.put(lot, SlotStatus.FREE);
    }

    @Override
    public boolean notifyParkingFull(ParkingLot lot) {
        if(parkingLots.containsKey(lot)){
            parkingLots.put(lot, SlotStatus.OCCUPIED);
            return true;
        }
        return false;

    }

    @Override
    public void notifyParkingAvailable(ParkingLot parkingLot) {
        if(parkingLots.containsKey(parkingLot)){
            parkingLots.put(parkingLot, SlotStatus.FREE);
        }

    }
}