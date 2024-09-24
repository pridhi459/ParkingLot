package com.parkingLot.Entities;

import com.parkingLot.Enums.vehicleColor;
import com.parkingLot.Enums.vehicleType;
import com.parkingLot.Exceptions.DuplicateParkingLotAssignmentException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AttendantTest {



    @Test
    void TestAssignParkingLotToAttendant() throws Exception{
        Attendant attendant = new Attendant();
        ParkingLot parkinglot = new ParkingLot(5);

        assertDoesNotThrow(()->attendant.assign(parkinglot));
    }

    @Test
    void TestCannotAssignParkingLotToAttendantTwice() throws Exception {
        Attendant attendant = new Attendant();
        ParkingLot parkinglot = new ParkingLot(5);
        attendant.assign(parkinglot);
        assertThrows(DuplicateParkingLotAssignmentException.class,() -> attendant.assign(parkinglot));
    }


    @Test
    void TestAttendantPark()throws Exception{
        Attendant attendant = new Attendant();
        ParkingLot parkinglot = new ParkingLot(5);
        attendant.assign(parkinglot);
        Vehicle car = new Vehicle("IN-781", vehicleType.CAR, vehicleColor.GREEN);
        assertDoesNotThrow(()->attendant.park(car));
    }

    @Test
    void TestAttendantReturnsRightTicketForParkedCar() throws Exception {
        Attendant attendant = new Attendant();
        ParkingLot parkinglot = new ParkingLot(2);
        attendant.assign(parkinglot);
        Vehicle car = new Vehicle("IN-781", vehicleType.CAR, vehicleColor.GREEN);
        Ticket returnedTicket = attendant.park(car);
        assertEquals(returnedTicket.getRegistrationNumber(), car.getRegisterNumber());
    }

    @Test
    void TestShouldNotUnParkCarWithTicketFromDifferentParkingLotOfSameSlot() throws Exception {
        ParkingLot firstParkingLot= new ParkingLot(1);
        Vehicle firstCar = new Vehicle("IN-781", vehicleType.CAR, vehicleColor.GREEN);
        Ticket firstTicket = firstParkingLot.park(firstCar);

        ParkingLot anotherParkingLot= new ParkingLot(1);
        Vehicle anotherCar = new Vehicle("IN-786", vehicleType.CAR, vehicleColor.GREEN);

    }

}
