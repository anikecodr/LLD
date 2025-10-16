package org.example.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ClietCode {

    public static void main(String[] args){
        List<ParkingSpot> parkingSpotListTwoWheeler = new ArrayList<>();
        List<ParkingSpot> parkingSpotListFourWheeler = new ArrayList<>();

        for(int i = 1; i<10; i++) {
            parkingSpotListTwoWheeler.add(new TwoWheelerParkingSpot(i, i%3));
        }


        for(int i = 11; i<10; i++) {
            parkingSpotListFourWheeler.add(new FourWheelerParkingSpot(i, i % 3));
        }
        Vechile vechile = new Vechile(VechileType.TWO_WHEELER, 50);
        EntranceGate entranceGate = new EntranceGate(vechile, parkingSpotListTwoWheeler);

        System.out.println(entranceGate.findSpot().getParkingSpotId());
        entranceGate.bookParkingSpot(entranceGate.findSpot());
        System.out.println(entranceGate.findSpot().getParkingSpotId());
    }
}
