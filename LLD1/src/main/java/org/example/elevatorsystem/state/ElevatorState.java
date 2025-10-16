package org.example.elevatorsystem.state;


import org.example.elevatorsystem.Elevator;
import org.example.elevatorsystem.enums.Direction;
import org.example.elevatorsystem.models.Request;

public interface ElevatorState {
    void move(Elevator elevator);
    void addRequest(Elevator elevator, Request request);
    Direction getDirection();
}
