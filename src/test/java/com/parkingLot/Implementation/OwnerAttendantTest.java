package com.parkingLot.Implementation;

import com.parkingLot.entities.ParkingLot;
import com.parkingLot.entities.Ticket;
import com.parkingLot.entities.Vehicle;
import com.parkingLot.enums.vehicleColor;
import com.parkingLot.enums.vehicleType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OwnerAttendantTest {

    @Test
    void testOwnerAssigns3ParkingLotsTo1Assistant() throws Exception{
        OwnerAttendant ownerAttendant = new OwnerAttendant();
        ParkingLot firstLot = ownerAttendant.createParkingLot(1);
        ParkingLot secondLot = ownerAttendant.createParkingLot(2);
        ParkingLot thirdLot = ownerAttendant.createParkingLot(3);
        AssistantAttendant firstAttendant = new AssistantAttendant();
        ownerAttendant.assignAttendant(firstLot, firstAttendant);
        ownerAttendant.assignAttendant(secondLot, firstAttendant);
        ownerAttendant.assignAttendant(thirdLot, firstAttendant);

        assertEquals(firstAttendant.NoOfAssignedParkingLots(), 3);
    }

    @Test
    void testOwnerAssignes1ParkingLotTo3Assistants() throws Exception{
        OwnerAttendant ownerAttendant = new OwnerAttendant();
        ParkingLot firstLot = ownerAttendant.createParkingLot(1);
        AssistantAttendant firstAttendant = new AssistantAttendant();
        AssistantAttendant secondAttendant = new AssistantAttendant();
        AssistantAttendant thirdAttendant = new AssistantAttendant();
        ownerAttendant.assignAttendant(firstLot, firstAttendant);
        ownerAttendant.assignAttendant(firstLot, secondAttendant);
        ownerAttendant.assignAttendant(firstLot, thirdAttendant);

        assertEquals(firstAttendant.NoOfAssignedParkingLots(), 1);
        assertEquals(secondAttendant.NoOfAssignedParkingLots(), 1);
        assertEquals(thirdAttendant.NoOfAssignedParkingLots(), 1);
    }

    @Test
    void testOwnerAssignedAttendantParkWithOldTechnique() throws Exception {
        OwnerAttendant ownerAttendant = new OwnerAttendant();
        ParkingLot firstLot = ownerAttendant.createParkingLot(1);
        AssistantAttendant firstAttendant1 = new AssistantAttendant();
        Vehicle firstvVehicle = new Vehicle("IN-781", vehicleType.CAR, vehicleColor.BLACK);
        ownerAttendant.assignAttendant(firstLot, firstAttendant1);
        Ticket firstTicket = firstAttendant1.park(firstvVehicle);

        assertEquals(firstAttendant1.unPark(firstTicket), firstvVehicle);
    }

      @Test
    void test (){

      }

}
