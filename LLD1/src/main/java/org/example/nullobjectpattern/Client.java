package org.example.nullobjectpattern;

public class Client {

    public static void main(String[] args){

        Vechile vechile = VechileFactory.getVechileObject("Bike");
        printVechileDetails(vechile);

         vechile = VechileFactory.getVechileObject("Car");
         printVechileDetails(vechile);

    }

    private static void printVechileDetails(Vechile vechile) {

        System.out.println("vehcile fuel capacity " + vechile.getTankCapacity());
    System.out.println("Vechile seat capacity "+ vechile.getSeatingCapacity());
    }
}
