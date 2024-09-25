package com.parkingLot.Entities;

import com.parkingLot.Enums.vehicleColor;
import com.parkingLot.Enums.vehicleType;
import com.parkingLot.Exceptions.DuplicateParkingLotAssignmentException;
import com.parkingLot.Exceptions.VehicleNotFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AttendantTest {



    @Test
    void TestAssignParkingLotToAttendant() throws Exception{
        Attendant attendant = new Attendant();
        assertDoesNotThrow(()->attendant.assign(5));
    }


    @Test
    void TestAttendantPark()throws Exception{
        Attendant attendant = new Attendant();
        attendant.assign(5);
        Vehicle car = new Vehicle("IN-781", vehicleType.CAR, vehicleColor.GREEN);
        assertDoesNotThrow(()->attendant.park(car));
    }

    @Test
    void TestAttendantReturnsRightTicketForParkedCar() throws Exception {
        Attendant attendant = new Attendant();
        attendant.assign(2);
        Vehicle car = new Vehicle("IN-781", vehicleType.CAR, vehicleColor.GREEN);
        Ticket returnedTicket = attendant.park(car);
        assertEquals(returnedTicket.getRegistrationNumber(), car.getRegisterNumber());
    }

    @Test
    void TestShouldNotUnParkCarWithTicketFromDifferentParkingLotOfSameSlot() throws Exception {
        Attendant firstAttendant = new Attendant();
        firstAttendant.assign(1);
        Vehicle firstCar = new Vehicle("IN-781", vehicleType.CAR, vehicleColor.GREEN);
        Ticket firstTicket = firstAttendant.park(firstCar);

        Attendant anotherAttendant = new Attendant();
        anotherAttendant.assign(1);
        Vehicle anotherCar = new Vehicle("IN-786", vehicleType.CAR, vehicleColor.GREEN);
        Ticket anotherTicket = anotherAttendant.park(anotherCar);

        System.out.println(anotherTicket.getParkingLotId()+" "+firstTicket.getParkingLotId()) ;
        assertThrows(VehicleNotFoundException.class,()->firstAttendant.unPark(anotherTicket));
    }

    @Test
    void TestShouldUnParkRightCarWithTicket() throws Exception {
        Attendant firstAttendant = new Attendant();
        firstAttendant.assign(1);
        Vehicle firstCar = new Vehicle("IN-781", vehicleType.CAR, vehicleColor.GREEN);
        Ticket firstTicket = firstAttendant.park(firstCar);

        Attendant anotherAttendant = new Attendant();
        anotherAttendant.assign(1);
        Vehicle anotherCar = new Vehicle("IN-786", vehicleType.CAR, vehicleColor.GREEN);
        Ticket anotherTicket = anotherAttendant.park(anotherCar);

        Vehicle returnedFirstVehicle = firstAttendant.unPark(firstTicket);
        Vehicle returnedAnotherVehicle = anotherAttendant.unPark(anotherTicket);

        assertEquals(returnedFirstVehicle.getRegisterNumber(), firstCar.getRegisterNumber());
        assertEquals(returnedFirstVehicle, firstCar);
        assertEquals(returnedAnotherVehicle.getRegisterNumber(), anotherCar.getRegisterNumber());
        assertEquals(returnedAnotherVehicle, anotherCar);
    }

    @Test
    void TestParkInNearestAvailableSlot() throws Exception {
        Attendant attendant = new Attendant();
        attendant.assign(2);
        attendant.assign(1);

        Vehicle firstCar = new Vehicle("IN-782", vehicleType.CAR, vehicleColor.GREEN);
        Vehicle secondCar = new Vehicle("IN-783", vehicleType.CAR, vehicleColor.GREEN);
        Vehicle thirdCar = new Vehicle("IN-784", vehicleType.CAR, vehicleColor.GREEN);
        Vehicle fourthCar = new Vehicle("IN-785", vehicleType.CAR, vehicleColor.GREEN);

        attendant.park(firstCar);
        Ticket secoundTicket = attendant.park(secondCar);
        attendant.park(thirdCar);
        attendant.unPark(secoundTicket);
        Ticket fourthTicket = attendant.park(fourthCar);

        assertEquals(fourthTicket.getSlotNumber(), secoundTicket.getSlotNumber());
        assertEquals(fourthTicket.getParkingLotId(), secoundTicket.getParkingLotId());
    }
}
