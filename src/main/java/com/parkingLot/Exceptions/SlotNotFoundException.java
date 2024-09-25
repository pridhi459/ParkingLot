package com.parkingLot.Exceptions;

public class SlotNotFoundException extends NullPointerException {
    public SlotNotFoundException(String message) {
        super(message);
    }
}
