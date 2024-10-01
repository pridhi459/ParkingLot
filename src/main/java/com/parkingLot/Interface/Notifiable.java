package com.parkingLot.Interface;

import com.parkingLot.entities.ParkingLot;

public interface Notifiable {

    boolean notifyParkingFull(ParkingLot parkingLot);
    void notifyParkingAvailable(ParkingLot parkingLot);
}
