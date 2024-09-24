package com.parkingLot.Entities;

public class Ticket {
    // Ticket class is used to represent a ticket issued to a vehicle by a Parking Lot
    private final int TicketNo;
    private final String parkingSlotId;
    private final String registrationNumber;

    Ticket(int TicketNo, int SlotNumber, String registrationNumber, String parkinglotId) {
        this.TicketNo = TicketNo;
        this.parkingSlotId = parkinglotId+"-"+SlotNumber;
        this.registrationNumber = registrationNumber;
    }


    public int getTicketNo() {
        return TicketNo;
    }
    public int getSlotNumber() {
        return Integer.parseInt(parkingSlotId.split("-")[1]);
    }
    public String getRegistrationNumber() {
        return registrationNumber;
    }
    public String getParkingLotId() {
        return parkingSlotId.split("-")[0];
    }

}
