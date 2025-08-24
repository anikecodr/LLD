package org.example.tictactoe;

public class Board {

    private final PlayingPiece[][] board;
    private final int rows;
    private final int cols;

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.board = new PlayingPiece[rows][cols];
    }

    public void printBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(board[i][j] == null ? "-" : board[i][j].getPieceType());
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public boolean isValidMove(int row, int col) {
        return row >= 0 && col >= 0 && row < rows && col < cols && board[row][col] == null;
    }

    public void placeMove(int row, int col, PlayingPiece piece) {
        board[row][col] = piece;
    }

    public boolean checkWinner(PieceType type) {
        // Check rows
        for (int i = 0; i < rows; i++) {
            boolean win = true;
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == null || board[i][j].getPieceType() != type) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }

        // Check columns
        for (int j = 0; j < cols; j++) {
            boolean win = true;
            for (int i = 0; i < rows; i++) {
                if (board[i][j] == null || board[i][j].getPieceType() != type) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }

        // Check diagonals
        boolean winDiag1 = true;
        for (int i = 0; i < rows; i++) {
            if (board[i][i] == null || board[i][i].getPieceType() != type) {
                winDiag1 = false;
                break;
            }
        }
        if (winDiag1) return true;

        boolean winDiag2 = true;
        for (int i = 0; i < rows; i++) {
            if (board[i][cols - 1 - i] == null || board[i][cols - 1 - i].getPieceType() != type) {
                winDiag2 = false;
                break;
            }
        }
        return winDiag2;
    }

    public boolean isFull() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == null) return false;
            }
        }
        return true;
    }

    public PlayingPiece getFreeCell(PlayingPiece piece) {
        // Unused in this approach, can remove safely.
        return null;
    }
}
