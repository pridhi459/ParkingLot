package service;

import Enums.vehicleColor;
import Enums.vehicleType;
import dto.Vehicle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleTest {

    @Test
    public void TestCreatVehicle(){
        Vehicle car = new Vehicle(123, vehicleType.CAR, vehicleColor.RED);
    }

    @Test
    public void TestCheckRegisterNumber(){
        Vehicle car = new Vehicle(19423, vehicleType.CAR, vehicleColor.RED);

        assertTrue(car.checkRegisterNumber(19423));
    }
}
