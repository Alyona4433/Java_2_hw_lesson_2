package com.devision;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Game game = new Game();

        System.out.println("Enter box number to select. Enjoy!\n");

        while (true) {
            game.displayBoard();
            game.resetBoardIfEmpty();

            if (game.hasWinner()) {
                game.displayResult();
                break;
            }

            game.playerMove(scan);

            if (game.hasWinner()) {
                game.displayResult();
                break;
            }

            game.computerMove();

            if (game.isDraw()) {
                game.displayResult();
                break;
            }
        }
    }
}
