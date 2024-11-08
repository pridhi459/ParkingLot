package com.parkingLot.entities;

import com.parkingLot.enums.vehicleColor;
import com.parkingLot.enums.vehicleType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SlotTest {


    @Test
    void TestParkCarInSlot() throws Exception{
        Slot slot = new Slot(1);
        Vehicle car = new Vehicle("IN-781", vehicleType.CAR, vehicleColor.GREEN);
        Ticket assignedTicket = slot.park(car,'A');

        assertEquals(assignedTicket, new Ticket(1, "IN-781", 'A'));
    }

    @Test
    void TestUnParkCarFromSlot() throws Exception{
        Slot slot = new Slot(1);
        Vehicle car = new Vehicle("IN-781", vehicleType.CAR, vehicleColor.GREEN);
        Ticket assignedTicket= slot.park(car, 'A');
        Vehicle unParkedCar = slot.unPark(assignedTicket);

        assertEquals(unParkedCar, car);
    }
}
