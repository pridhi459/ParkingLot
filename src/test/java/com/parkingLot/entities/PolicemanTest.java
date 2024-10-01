package com.parkingLot.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolicemanTest {

    @Test
    void testPolicemanCreation() {
        Policeman policeman = new Policeman();
        assertNotNull(policeman);
    }
    @Test
    void testPolicemannotification()throws Exception {
        Policeman policeman = new Policeman();
        String message = "Parking Lot is full";
        ParkingLot lot = new ParkingLot(1);
        policeman.assignParkingLot(lot);
        assertTrue(policeman.notifyParkingFull(lot));
    }

}