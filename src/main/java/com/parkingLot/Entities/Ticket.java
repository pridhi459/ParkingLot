package com.parkingLot.Entities;

public class Ticket {
    // Ticket class is used to represent a ticket issued to a vehicle by a Parking Lot
    private final int TicketID;
    private final String parkingSlotId;
    private final String registrationNumber;

    Ticket(int TicketID, int SlotNumber, String registrationNumber, Character parkinglotId) {
        this.TicketID = TicketID;
        this.parkingSlotId = parkinglotId+"-"+SlotNumber;
        this.registrationNumber = registrationNumber;
    }


    public int getTicketID() {
        return TicketID;
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
