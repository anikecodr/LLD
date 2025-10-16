package org.example.chessgame.pieces;

import org.example.chessgame.Board;
import org.example.chessgame.Cell;
import org.example.chessgame.Color;

public abstract class Piece {
    protected final Color color;

    public Piece(Color color) {
        this.color = color;
    }

    public abstract boolean canMove(Board board, Cell from, Cell to);

    public Color getColor() {
        return color;
    }
}
