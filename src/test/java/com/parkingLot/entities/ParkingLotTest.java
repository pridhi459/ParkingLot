//package com.parkingLot.Entities;
//
//import com.parkingLot.Enums.vehicleColor;
//import com.parkingLot.Enums.vehicleType;
//import com.parkingLot.Exceptions.VehicleNotFoundException;
//import org.junit.jupiter.api.*;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class ParkingLotTest {
//
//    @Test
//    public void TestCreateEmptyParkingLot() throws Exception {
//
//        ParkingLot parkinglot = new ParkingLot(5);
//        assertEquals(parkinglot.getVacantSlots(), 5);
//    }
//
//    @Test
//    public void TestCreateEmptyParkingLotForNegativeSlots() throws Exception {
//        Assertions.assertThrows(Exception.class, () -> new ParkingLot(-5));
//    }
//
//    @Test
//    public void TestAssignParkingSlotToVehicle() throws Exception {
//
//        Vehicle car = new Vehicle("123", vehicleType.CAR, vehicleColor.RED);
//        ParkingLot parkinglot = new ParkingLot(5);
//        parkinglot.park(car);
//        assertEquals(parkinglot.findVehicleSlotByRegistrationNumber("123"), 0);
//    }
//
//    @Test
//    public void TestNumberOfCarsOfColorRed() throws Exception {
//
//        Vehicle car1 = new Vehicle("123", vehicleType.CAR, vehicleColor.RED);
//        Vehicle car2 = new Vehicle("124", vehicleType.CAR, vehicleColor.RED);
//        Vehicle car3 = new Vehicle("125", vehicleType.CAR, vehicleColor.RED);
//        Vehicle car4 = new Vehicle("126", vehicleType.CAR, vehicleColor.BLUE);
//        Vehicle car5 = new Vehicle("127", vehicleType.CAR, vehicleColor.BLUE);
//        ParkingLot parkinglot = new ParkingLot(5);
//        parkinglot.park(car1);
//        parkinglot.park(car2);
//        parkinglot.park(car3);
//        parkinglot.park(car4);
//        parkinglot.park(car5);
//
//        assertEquals(parkinglot.getNumberOfCarsByColor(vehicleColor.RED), 3);
//    }
//
//    @Test
//    public void TestFindVehicleWithRegistrationNumber125() throws Exception {
//
//        Vehicle car1 = new Vehicle("123", vehicleType.CAR, vehicleColor.RED);
//        Vehicle car2 = new Vehicle("124", vehicleType.CAR, vehicleColor.RED);
//        Vehicle car3 = new Vehicle("125", vehicleType.CAR, vehicleColor.RED);
//        Vehicle car4 = new Vehicle("126", vehicleType.CAR, vehicleColor.BLUE);
//        Vehicle car5 = new Vehicle("127", vehicleType.CAR, vehicleColor.BLUE);
//        ParkingLot parkinglot = new ParkingLot(5);
//        parkinglot.park(car1);
//        parkinglot.park(car2);
//        parkinglot.park(car3);
//        parkinglot.park(car4);
//        parkinglot.park(car5);
//
//        assertEquals(parkinglot.findVehicleSlotByRegistrationNumber("125"), 2);
//    }
//
//    @Test
//    public void TestFindVehicleWithIncorrectRegistrationNumber() throws Exception {
//
//        Vehicle car1 = new Vehicle("123", vehicleType.CAR, vehicleColor.RED);
//        Vehicle car2 = new Vehicle("124", vehicleType.CAR, vehicleColor.RED);
//        Vehicle car3 = new Vehicle("125", vehicleType.CAR, vehicleColor.RED);
//        Vehicle car4 = new Vehicle("126", vehicleType.CAR, vehicleColor.BLUE);
//        Vehicle car5 = new Vehicle("127", vehicleType.CAR, vehicleColor.BLUE);
//        ParkingLot parkinglot = new ParkingLot(5);
//        parkinglot.park(car1);
//        parkinglot.park(car2);
//        parkinglot.park(car3);
//        parkinglot.park(car4);
//        parkinglot.park(car5);
//
//        Assertions.assertThrows(VehicleNotFoundException.class, ()->parkinglot.findVehicleSlotByRegistrationNumber("135"));
//    }
//
//    @Test
//    public void TestUnParkingWithRegisterNo5() throws Exception {
//
//        Vehicle car1 = new Vehicle("1", vehicleType.CAR, vehicleColor.RED);
//        Vehicle car2 = new Vehicle("2", vehicleType.CAR, vehicleColor.RED);
//        Vehicle car3 = new Vehicle("3", vehicleType.CAR, vehicleColor.RED);
//        Vehicle car4 = new Vehicle("4", vehicleType.CAR, vehicleColor.BLUE);
//        Vehicle car5 = new Vehicle("5", vehicleType.CAR, vehicleColor.BLUE);
//        ParkingLot parkinglot = new ParkingLot(5);
//        parkinglot.park(car1);
//        Ticket allotedTicket = parkinglot.park(car2);
//        parkinglot.park(car3);
//        parkinglot.park(car4);
//        parkinglot.park(car5);
//        Vehicle unParkedVehicle = parkinglot.unPark(allotedTicket);
//
//        assertEquals(unParkedVehicle, car3);
//    }
//
//    @Test
//    public void TestParkingInNearestSlotWhichIsSlotNo2() throws Exception {
//
//        Vehicle car1 = new Vehicle("1", vehicleType.CAR, vehicleColor.RED);
//        Vehicle car2 = new Vehicle("2", vehicleType.CAR, vehicleColor.GREEN);
//        Vehicle car3 = new Vehicle("3", vehicleType.CAR, vehicleColor.BLACK);
//        Vehicle car4 = new Vehicle("4", vehicleType.CAR, vehicleColor.PINK);
//        ParkingLot parkinglot = new ParkingLot(5);
//
//        Ticket allotedTicket = parkinglot.park(car1);
//        parkinglot.park(car2);
//        parkinglot.park(car3);
//        parkinglot.park(car4);
//        parkinglot.unPark(allotedTicket);
//        Vehicle car6 = new Vehicle("6", vehicleType.CAR, vehicleColor.RED);
//        parkinglot.park(car6);
//
//        assertEquals(parkinglot.findVehicleSlotByRegistrationNumber("6"), 1);
//    }
//
//    @Test
//    public void TestEmptySlotAfterUnPark() throws Exception{
//        Vehicle car1 = new Vehicle("1", vehicleType.CAR, vehicleColor.RED);
//        Vehicle car2 = new Vehicle("2", vehicleType.CAR, vehicleColor.GREEN);
//
//        ParkingLot parkinglot = new ParkingLot(5);
//        Ticket allotedTicket = parkinglot.park(car1);
//        parkinglot.park(car2);
//
//        parkinglot.unPark(allotedTicket);
//        assertTrue(parkinglot.checkEmptySlot(1));
//    }
//}
