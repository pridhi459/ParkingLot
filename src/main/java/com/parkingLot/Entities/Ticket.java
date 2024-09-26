package com.parkingLot.Entities;

public class Ticket {
    // Ticket class is used to represent a ticket issued to a vehicle by a Parking Lot
    private final int TicketID;
    private final String parkingSlotId;
    private final String registrationNumber;
    static int ticketCount=0;

    Ticket( int SlotNumber, String registrationNumber, Character parkingLotId) {
        this.TicketID = ++ticketCount;
        this.parkingSlotId = parkingLotId +"-"+SlotNumber;
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
    public boolean checkSlotNumber(int slotNumber) {
        return slotNumber == Integer.parseInt(parkingSlotId.split("-")[1]);
    }



    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Ticket)) {
            return false;
        }
        Ticket otherTicket = (Ticket) o;
        return  this.parkingSlotId.equals(otherTicket.parkingSlotId) && this.registrationNumber.equals(otherTicket.registrationNumber);
    }

}
