package org.example.tictactoe;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Game {

    Board playingBoard;

    public static void main(String[] args) {
        Game game = new Game();
        game.initializeBoard();

        // create players
        Player aniket = new Player("Aniket", new PlayingPiece(PieceType.X));
        Player nilesh = new Player("Nilesh", new PlayingPiece(PieceType.O));

        // start game
        game.start(aniket, nilesh);
    }

    private void initializeBoard() {
        // Change size here for custom boards
        playingBoard = new Board(4, 4);
    }

    private void start(Player aniket, Player nilesh) {
        Deque<Player> deque = new ArrayDeque<>(2);
        deque.add(aniket);
        deque.add(nilesh);

        Scanner sc = new Scanner(System.in);

        while (true) {
            Player currentPlayer = deque.poll();
            playingBoard.printBoard();

            System.out.println(currentPlayer.getName() + "'s turn. Enter row and column (0-based): ");
            int row = sc.nextInt();
            int col = sc.nextInt();

            // Validate move
            if (!playingBoard.isValidMove(row, col)) {
                System.out.println("Invalid move! Try again.");
                deque.addFirst(currentPlayer);
                continue;
            }

            // Place the move
            playingBoard.placeMove(row, col, currentPlayer.getPlayingPiece());

            // Check winner
            if (playingBoard.checkWinner(currentPlayer.getPlayingPiece().getPieceType())) {
                playingBoard.printBoard();
                System.out.println(currentPlayer.getName() + " wins! 🎉");
                break;
            }

            // Check tie
            if (playingBoard.isFull()) {
                playingBoard.printBoard();
                System.out.println("It's a tie!");
                break;
            }

            // Switch player
            deque.addLast(currentPlayer);
        }
        sc.close();
    }
}
