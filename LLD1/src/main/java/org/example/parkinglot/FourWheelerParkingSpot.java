package org.example.parkinglot;

public class FourWheelerParkingSpot  extends ParkingSpot{


    public FourWheelerParkingSpot(int parkingSpotId, int levelNumber) {
        super(parkingSpotId, levelNumber);
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void parkVechile(Vechile vechile, ParkingSpot parkingSpot) {

        parkingSpot.isEmpty() = false;
        parkingSpot.setVechile(vechile);

    }

    @Override
    public boolean removeVechile(Vechile vechile) {
        return false;
    }
}
