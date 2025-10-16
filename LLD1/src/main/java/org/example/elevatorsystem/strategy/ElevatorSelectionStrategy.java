package org.example.elevatorsystem.strategy;

import org.example.elevatorsystem.Elevator;
import org.example.elevatorsystem.models.Request;

import java.util.List;
import java.util.Optional;

public interface ElevatorSelectionStrategy {
    Optional<Elevator> selectElevator(List<Elevator> elevators, Request request);
}
