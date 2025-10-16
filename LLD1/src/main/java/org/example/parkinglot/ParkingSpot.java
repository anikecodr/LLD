package org.example.parkinglot;

public abstract class ParkingSpot {
    private int parkingSpotId;
    private int levelNumber;

    private Vechile vechile;

    public Vechile getVechile() {
        return vechile;
    }

    public void setVechile(Vechile vechile) {
        this.vechile = vechile;
    }

    public ParkingSpot(int parkingSpotId, int levelNumber) {
        this.levelNumber = levelNumber;
        this.parkingSpotId = parkingSpotId;
    }
    public abstract boolean isEmpty();

    public int getParkingSpotId() {
        return parkingSpotId;
    }

    public void setParkingSpotId(int parkingSpotId) {
        this.parkingSpotId = parkingSpotId;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }
}
