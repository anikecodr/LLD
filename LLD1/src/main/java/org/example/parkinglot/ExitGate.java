package org.example.parkinglot;

public class ExitGate {

    Ticket ticket;

    ParkingSpotManager parkingSpotManager;

    public ExitGate(Ticket ticket, ParkingSpotManager parkingSpotManager) {
        this.ticket = ticket;
        this.parkingSpotManager = parkingSpotManager;
    }

    private int calculateCost() {
      if(ticket.getVechile().getVechileType() == VechileType.TWO_WHEELER) return 20;
      else return  50;
    }

    private void payment() {

    }

    private void freeParkingSlot() {
        this.parkingSpotManager.removeParkingSpot(ticket.getParkingSpot());
    }

}
