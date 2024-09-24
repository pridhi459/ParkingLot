package service;

import Enums.vehicleColor;
import Exceptions.VehicleNotFoundException;
import dto.Vehicle;
import dto.slot;

public class ParkingLot {
    private final slot[] slots;


    public ParkingLot(int numberOfSlots) throws Exception{
        if (numberOfSlots>0){
            slots = new slot[numberOfSlots];
            for (int i = 0; i < numberOfSlots; i++) {
                slots[i] = new slot(i);
            }
        }
        else{
            throw new Exception("Parking lot cannot be created with 0 or negative slots");
        }
    }

    public int getVacantSlots() {
        int capacity=0;
        for(slot slot:slots){
            if(!slot.isOccupied()){
                capacity++;
            }
        }
        return capacity;
    }

    public void park(Vehicle vehicle) throws Exception{
        for (dto.slot slot : slots) {
            if (!slot.isOccupied()) {
                slot.setOccupied(true);
                slot.setVehicle(vehicle);
                return;
            }
        }
        throw new Exception("Parking lot is full");
    }

    public int getNumberOfCarsOfColor(vehicleColor vehicleColor) {
        int count = 0;
        for (slot slot : slots) {
            if (slot.isOccupied() && slot.getVehicle().checkColor(vehicleColor) ) {
                count++;
            }
        }
        return count;
    }

    public int findVehicleSlotByRegistrationNumber(int registerNo) {
        for (slot slot : slots) {
            if (slot.isOccupied() && slot.getVehicle().checkRegisterNumber(registerNo)) {
                return slot.getSlotNumber();
            }
        }

        System.out.println("A Vehicle with Register No. "+ registerNo+" is not parked in the parking lot.");
        throw new VehicleNotFoundException("Vehicle not found");
    }

    public Vehicle unPark(int slotNo) {
        for (slot slot : slots) {
            if (slot.isOccupied() && slot.getSlotNumber()== slotNo) {
                slot.setOccupied(false);
                System.out.println("Vehicle is unparked from the parking lot and Given Back.");
                return slot.getVehicle();
            }
        }
        System.out.println("A Vehicle is not parked in the parking lot.");
        throw new VehicleNotFoundException("Vehicle not found in parking to be unparked");
    }

    public boolean checkEmptySlot(int slotId) throws Exception{
        for(slot slot:slots){
            if(slot.getSlotNumber()==slotId){
                return !slot.isOccupied() || slot.getVehicle() == null;
            }
        }
        throw new Exception("Slot not found");
    }
}
