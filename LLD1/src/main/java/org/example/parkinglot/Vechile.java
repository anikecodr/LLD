package org.example.parkinglot;

public class Vechile {
    private VechileType vechileType;
    private int VechileNumber;

    public Vechile(VechileType vechileType, int vechileNumber) {
        this.vechileType = vechileType;
        VechileNumber = vechileNumber;
    }

    public VechileType getVechileType() {
        return vechileType;
    }

    public void setVechileType(VechileType vechileType) {
        this.vechileType = vechileType;
    }

    public int getVechileNumber() {
        return VechileNumber;
    }

    public void setVechileNumber(int vechileNumber) {
        VechileNumber = vechileNumber;
    }
}
