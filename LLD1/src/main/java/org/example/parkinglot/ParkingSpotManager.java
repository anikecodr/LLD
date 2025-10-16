package org.example.parkinglot;

import java.util.List;

public abstract class ParkingSpotManager {
    List<ParkingSpot> parkingSpotList;
    ParkingStrategy parkingStrategy;

    public ParkingSpotManager(List<ParkingSpot> parkingSpotList, ParkingStrategy parkingStrategy) {
        this.parkingSpotList = parkingSpotList;
        this.parkingStrategy = parkingStrategy;
    }

    public void addParkingSpot(ParkingSpot parkingSpot) {
        parkingSpotList.add(parkingSpot);
    }
    public void removeParkingSpot(ParkingSpot parkingSpot) {
        parkingSpotList.remove(parkingSpot);
    }

    public ParkingSpot findParkingSpot() {
       return this.parkingStrategy.findParkingSpot(parkingSpotList);
    }

    public abstract void parkVechile(Vechile vechile, ParkingSpot parkingSpot);

    public abstract void removeVechile(Vechile vechile);
}
