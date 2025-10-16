package org.example.parkinglot;

import java.util.List;

public class TwoWheelerParkingStrategy  implements ParkingStrategy {
    @Override
    public ParkingSpot findParkingSpot(List<ParkingSpot> list) {
        for(int i=list.size()-1; i>=0; i--) {
            if(!list.get(i).isEmpty()) return list.get(i);
        }
        return null;
    }
}
