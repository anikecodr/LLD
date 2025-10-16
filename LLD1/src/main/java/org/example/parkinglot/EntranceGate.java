package org.example.parkinglot;

import java.time.LocalTime;
import java.util.List;

public class EntranceGate {
    private Ticket ticket;
    private ParkingSpotManager parkingSpotManager;

    private Vechile vechile;

    public EntranceGate(Vechile vechile, List<ParkingSpot> list) {
        this.vechile = vechile;
        this.parkingSpotManager = ParkingSpotManagerFactory.getParkingSpotManager(vechile.getVechileType(), list);

    }

    public ParkingSpot findSpot() {
       return this.parkingSpotManager.findParkingSpot();
    }

    public void bookParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpotManager.parkVechile(vechile, parkingSpot);
    }

    public void generateTicket(Vechile vechile, LocalTime time, ParkingSpot parkingSpot) {
        this.ticket = new Ticket(vechile, time, parkingSpot);
    }

    public Ticket getTicket() {
        return ticket;
    }
}
