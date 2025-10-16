package org.example.chessgame.pieces;

import org.example.chessgame.Board;
import org.example.chessgame.Cell;
import org.example.chessgame.Color;

public class Rook extends Piece {
    public Rook(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board, Cell from, Cell to) {
        return (from.getRow() == to.getRow() || from.getCol() == to.getCol());
    }
}