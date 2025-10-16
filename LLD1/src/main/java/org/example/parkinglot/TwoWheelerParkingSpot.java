package org.example.parkinglot;

public class TwoWheelerParkingSpot extends ParkingSpot {
    public TwoWheelerParkingSpot(int parkingSpotId, int levelNumber) {
        super(parkingSpotId, levelNumber);
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

}
