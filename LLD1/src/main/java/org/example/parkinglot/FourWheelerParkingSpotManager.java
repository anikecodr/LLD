package org.example.parkinglot;

import java.util.List;

public class FourWheelerParkingSpotManager extends ParkingSpotManager{

    public FourWheelerParkingSpotManager(List<ParkingSpot> parkingSpotList) {
    super(parkingSpotList, new FourWheelerParkingStrategy());
    }

    @Override
    public void removeParkingSpot(ParkingSpot parkingSpot) {
        super.removeParkingSpot(parkingSpot);
    }

    @Override
    public void parkVechile(Vechile vechile) {

    }

    @Override
    public void removeVechile(Vechile vechile) {

    }
}
