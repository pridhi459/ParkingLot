//package MockTest;
//
//import Enums.vehicleColor;
//import Enums.vehicleType;
//import Entities.Vehicle;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.MockitoAnnotations;
//import org.mockito.Spy;
//import Entities.ParkingLot;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.Mockito.*;
//
//public class ParkingLotMockTest {
//
//
//
//    @Spy
//    //@InjectMocks
//    private ParkingLot parkingLot;
//    private Vehicle car1;
//    private Vehicle car2;
//
//    @BeforeEach
//    public void setUp() throws Exception {
//        parkingLot = new ParkingLot(5);
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    public void testParkWithSpy() throws Exception {
//        car1 = new Vehicle("1", vehicleType.CAR, vehicleColor.RED);
//        doNothing().when(parkingLot).park(car1);
//        parkingLot.park(car1);
//        verify(parkingLot, times(1)).park(car1);
//    }
//
//    @Test
//    public void testUnParkWithSpy() throws Exception {
//        car1 = new Vehicle("1", vehicleType.CAR, vehicleColor.RED);
//        parkingLot.park(car1);
//        doReturn(car1).when(parkingLot).unPark(0);
//        parkingLot.unPark(0);
//        verify(parkingLot, times(1)).unPark(0);
//    }
//
//    @Test
//    public void testFindVehicleSlotByRegistrationNumber() throws Exception {
//        car1 = new Vehicle("1", vehicleType.CAR, vehicleColor.RED);
//        parkingLot.park(car1);
//
//        assertEquals(0, parkingLot.findVehicleSlotByRegistrationNumber("1"));
//    }
//
//    @Test
//    public void testCheckEmptySlot() throws Exception {
//        car1 = new Vehicle("1", vehicleType.CAR, vehicleColor.RED);
//        parkingLot.park(car1);
//        parkingLot.unPark(0);
//
//        assertTrue(parkingLot.checkEmptySlot(0));
//    }
//
//    @Test
//    public void testGetNumberOfCarsOfColor() throws Exception {
//        car1 = new Vehicle("1", vehicleType.CAR, vehicleColor.RED);
//        car2 = new Vehicle("2", vehicleType.CAR, vehicleColor.PURPLE);
//        parkingLot.park(car1);
//        parkingLot.park(car2);
//
//        assertEquals(1, parkingLot.getNumberOfCarsOfColor(vehicleColor.RED));
//    }
//}
