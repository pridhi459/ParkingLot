package com.parkingLot.Exceptions;

public class NoEmptySlotException extends RuntimeException {
    public NoEmptySlotException(String message) {
        super(message);
    }
}
