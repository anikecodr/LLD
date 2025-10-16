package org.example.parkinglot;

import java.time.LocalTime;

public class Ticket {
    public Ticket(Vechile vechile, LocalTime entryTime, ParkingSpot parkingSpot) {
        this.vechile = vechile;
        this.entryTime = entryTime;
        this.parkingSpot = parkingSpot;
    }

    private Vechile vechile;
    private LocalTime entryTime;
    private ParkingSpot parkingSpot;

    public Vechile getVechile() {
        return vechile;
    }

    public void setVechile(Vechile vechile) {
        this.vechile = vechile;
    }

    public LocalTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalTime entryTime) {
        this.entryTime = entryTime;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }
}
