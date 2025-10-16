package org.example.parkinglot;

import java.util.List;

public class ParkingSpotManagerFactory {

    public static ParkingSpotManager getParkingSpotManager(VechileType vechileType, List<ParkingSpot> parkingSpotList) {
        if(vechileType == VechileType.TWO_WHEELER) return new TwoWheelerParkingSpotManager(parkingSpotList);
        else if(vechileType == VechileType.FOUR_WHEELER) return new FourWheelerParkingSpotManager(parkingSpotList);
        else {
            System.out.println("None of Vechile Type found");
            return  null;
        }
    }
}
