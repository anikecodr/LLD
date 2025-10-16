package org.example.parkinglot;

import java.util.List;

public class TwoWheelerParkingSpotManager extends ParkingSpotManager{

    public TwoWheelerParkingSpotManager(List<ParkingSpot> parkingSpotList) {
        super(parkingSpotList, new TwoWheelerParkingStrategy());
    }

    @Override
    public void parkVechile(Vechile vechile, ParkingSpot parkingSpot) {
        parkingSpot.isEmpty() = Boolean.FALSE;
        parkingSpot.setVechile(vechile);
    }

    @Override
    public void removeVechile(Vechile vechile) {

    }
}
