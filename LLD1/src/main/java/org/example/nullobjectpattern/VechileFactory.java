package org.example.nullobjectpattern;

public class VechileFactory {

    public static Vechile getVechileObject(String typeOfVechile) {

        if(typeOfVechile.equals("Car")) {
            return new Car();
        }
        return new NullVechile();
    }
}
