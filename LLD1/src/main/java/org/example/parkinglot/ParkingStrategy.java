package org.example.parkinglot;

import java.util.List;

public interface ParkingStrategy {
    ParkingSpot findParkingSpot(List<ParkingSpot> list);
}
