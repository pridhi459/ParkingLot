package com.parkingLot.Implementation;

import com.parkingLot.entities.ParkingLot;
import com.parkingLot.entities.Ticket;
import com.parkingLot.entities.Vehicle;
import com.parkingLot.enums.vehicleColor;
import com.parkingLot.enums.vehicleType;
import com.parkingLot.exceptions.VehicleAlreadyParkedException;
import com.parkingLot.exceptions.InvalidTicketException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class assistantAttendantTest {



    @Test
    void TestAssignParkingLotToAttendant() throws Exception{
        AssistantAttendant AssistantAttendant = new AssistantAttendant();
        ParkingLot parkingLot = new ParkingLot(5);
        assertDoesNotThrow(()-> AssistantAttendant.assign(parkingLot));
    }


    @Test
    void TestAttendantPark()throws Exception{
        AssistantAttendant AssistantAttendant = new AssistantAttendant();
        ParkingLot parkingLot = new ParkingLot(5);
        AssistantAttendant.assign(parkingLot);
        Vehicle car = new Vehicle("IN-781", vehicleType.CAR, vehicleColor.GREEN);
        assertDoesNotThrow(()-> AssistantAttendant.park(car));
    }

    @Test
    void TestAttendantReturnsRightTicketForParkedCar() throws Exception {
        AssistantAttendant AssistantAttendant = new AssistantAttendant();
        ParkingLot parkingLot = new ParkingLot(2);
        AssistantAttendant.assign(parkingLot);
        Vehicle car = new Vehicle("IN-781", vehicleType.CAR, vehicleColor.GREEN);
        Ticket returnedTicket = AssistantAttendant.park(car);
        assertEquals(returnedTicket.getRegistrationNumber(), car.getRegisterNumber());
    }

    @Test
    void TestAttendantShouldNotUnParkCarWithTicketFromDifferentParkingLotOfSameSlot() throws Exception {
        AssistantAttendant firstAssistantAttendant = new AssistantAttendant();
        ParkingLot firstParkingLot= new ParkingLot(1);
        firstAssistantAttendant.assign(firstParkingLot);
        Vehicle firstCar = new Vehicle("IN-781", vehicleType.CAR, vehicleColor.GREEN);
        Ticket firstTicket = firstAssistantAttendant.park(firstCar);

        AssistantAttendant anotherAssistantAttendant = new AssistantAttendant();
        ParkingLot anotherparkingLot = new ParkingLot(1);
        anotherAssistantAttendant.assign(anotherparkingLot);
        Vehicle anotherCar = new Vehicle("IN-786", vehicleType.CAR, vehicleColor.GREEN);
        Ticket anotherTicket = anotherAssistantAttendant.park(anotherCar);

        System.out.println(anotherTicket.getParkingLotId()+" "+firstTicket.getParkingLotId()) ;
        assertThrows(InvalidTicketException.class,()-> firstAssistantAttendant.unPark(anotherTicket));
    }

    @Test
    void TestAttendantShouldUnParkRightCarWithTicket() throws Exception {
        AssistantAttendant firstAssistantAttendant = new AssistantAttendant();
        ParkingLot firstParkingLot= new ParkingLot(1);
        firstAssistantAttendant.assign(firstParkingLot);
        Vehicle firstCar = new Vehicle("IN-781", vehicleType.CAR, vehicleColor.GREEN);
        Ticket firstTicket = firstAssistantAttendant.park(firstCar);

        AssistantAttendant anotherAssistantAttendant = new AssistantAttendant();
        ParkingLot anotherparkingLot = new ParkingLot(1);
        anotherAssistantAttendant.assign(anotherparkingLot);
        Vehicle anotherCar = new Vehicle("IN-786", vehicleType.CAR, vehicleColor.GREEN);
        Ticket anotherTicket = anotherAssistantAttendant.park(anotherCar);

        Vehicle returnedFirstVehicle = firstAssistantAttendant.unPark(firstTicket);
        Vehicle returnedAnotherVehicle = anotherAssistantAttendant.unPark(anotherTicket);

        assertEquals(returnedFirstVehicle.getRegisterNumber(), firstCar.getRegisterNumber());
        assertEquals(returnedFirstVehicle, firstCar);
        assertEquals(returnedAnotherVehicle.getRegisterNumber(), anotherCar.getRegisterNumber());
        assertEquals(returnedAnotherVehicle, anotherCar);
    }

    @Test
    void TestAttendantParksInNearestAvailableSlot() throws Exception {
        AssistantAttendant AssistantAttendant = new AssistantAttendant();
        ParkingLot firstparkingLot= new ParkingLot(2);
        ParkingLot secondparkingLot= new ParkingLot(1);
        AssistantAttendant.assign(firstparkingLot);
        AssistantAttendant.assign(secondparkingLot);

        Vehicle firstCar = new Vehicle("IN-782", vehicleType.CAR, vehicleColor.GREEN);
        Vehicle secondCar = new Vehicle("IN-783", vehicleType.CAR, vehicleColor.GREEN);
        Vehicle thirdCar = new Vehicle("IN-784", vehicleType.CAR, vehicleColor.GREEN);
        Vehicle fourthCar = new Vehicle("IN-785", vehicleType.CAR, vehicleColor.GREEN);

        AssistantAttendant.park(firstCar);
        Ticket secoundTicket = AssistantAttendant.park(secondCar);
        AssistantAttendant.park(thirdCar);
        AssistantAttendant.unPark(secoundTicket);
        Ticket fourthTicket = AssistantAttendant.park(fourthCar);

        assertEquals(fourthTicket.getSlotNumber(), secoundTicket.getSlotNumber());
        assertEquals(fourthTicket.getParkingLotId(), secoundTicket.getParkingLotId());
    }

    @Test
    void TestParkingAParkedCar() throws Exception{
        AssistantAttendant AssistantAttendant = new AssistantAttendant();
        ParkingLot parkingLot = new ParkingLot(2);
        AssistantAttendant.assign(parkingLot);

        Vehicle firstCar = new Vehicle("IN-781", vehicleType.CAR, vehicleColor.GREEN);
        AssistantAttendant.park(firstCar);

        Vehicle secondCar = new Vehicle("IN-782", vehicleType.CAR, vehicleColor.PINK);
        AssistantAttendant.park(secondCar);

        assertThrows(VehicleAlreadyParkedException.class,()-> AssistantAttendant.park(firstCar));

    }
}
