package org.example.nullobjectpattern;

public class NullVechile implements Vechile{

    @Override
    public int getTankCapacity() {
        return 0;
    }

    @Override
    public int getSeatingCapacity() {
        return 0;
    }
}
