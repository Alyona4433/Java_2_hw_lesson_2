package com.devision;

import java.util.Scanner;

public class Game {
    private char[] box;
    private boolean boxEmpty;
    private byte winner;

    public Game() {
        box = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        boxEmpty = false;
        winner = 0;
    }

    public void displayBoard() {
        System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
    }

    public void resetBoardIfEmpty() {
        if (!boxEmpty) {
            for (byte i = 0; i < 9; i++)
                box[i] = ' ';
            boxEmpty = true;
        }
    }

    public boolean hasWinner() {
        if ((box[0] == 'X' && box[1] == 'X' && box[2] == 'X') ||
                (box[3] == 'X' && box[4] == 'X' && box[5] == 'X') ||
                (box[6] == 'X' && box[7] == 'X' && box[8] == 'X') ||
                (box[0] == 'X' && box[3] == 'X' && box[6] == 'X') ||
                (box[1] == 'X' && box[4] == 'X' && box[7] == 'X') ||
                (box[2] == 'X' && box[5] == 'X' && box[8] == 'X') ||
                (box[0] == 'X' && box[4] == 'X' && box[8] == 'X') ||
                (box[2] == 'X' && box[4] == 'X' && box[6] == 'X')) {
            winner = 1;
            return true;
        } else if ((box[0] == 'O' && box[1] == 'O' && box[2] == 'O') ||
                (box[3] == 'O' && box[4] == 'O' && box[5] == 'O') ||
                (box[6] == 'O' && box[7] == 'O' && box[8] == 'O') ||
                (box[0] == 'O' && box[3] == 'O' && box[6] == 'O') ||
                (box[1] == 'O' && box[4] == 'O' && box[7] == 'O') ||
                (box[2] == 'O' && box[5] == 'O' && box[8] == 'O') ||
                (box[0] == 'O' && box[4] == 'O' && box[8] == 'O') ||
                (box[2] == 'O' && box[4] == 'O' && box[6] == 'O')) {
            winner = 2;
            return true;
        } else if (isBoardFull()) {
            winner = 3;
            return true;
        }
        return false;
    }

    private boolean isBoardFull() {
        for (char c : box) {
            if (c != 'X' && c != 'O') {
                return false;
            }
        }
        return true;
    }

    public void displayResult() {
        if (winner == 1) {
            System.out.println("You won the game!\nCreated by Shreya's Sahi. Thanks for playing!");
        } else if (winner == 2) {
            System.out.println("You lost the game!\nCreated by Shreya's Sahi. Thanks for playing!");
        } else if (winner == 3) {
            System.out.println("It's a draw!\nCreated by Shreya's Sahi. Thanks for playing!");
        }
    }

    public void playerMove(Scanner scan) {
        byte input;
        while (true) {
            input = scan.nextByte();
            scan.nextLine();
            if (input > 0 && input < 10) {
                if (box[input - 1] == 'X' || box[input - 1] == 'O')
                    System.out.println("That one is already in use. Enter another.");
                else {
                    box[input - 1] = 'X';
                    break;
                }
            } else
                System.out.println("Invalid input. Enter again.");
        }
    }

    public void computerMove() {
        boolean boxAvailable;
        byte rand;

        boxAvailable = false;
        for (byte i = 0; i < 9; i++) {
            if (box[i] != 'X' && box[i] != 'O') {
                boxAvailable = true;
                break;
            }
        }

        if (!boxAvailable) {
            winner = 3;
            return;
        }

        while (true) {
            rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (box[rand - 1] != 'X' && box[rand - 1] != 'O') {
                box[rand - 1] = 'O';
                break;
            }
        }

        if ((box[0] == 'O' && box[1] == 'O' && box[2] == 'O') || (box[3] == 'O' && box[4] == 'O' && box[5] == 'O') ||
                (box[6] == 'O' && box[7] == 'O' && box[8] == 'O') || (box[0] == 'O' && box[3] == 'O' && box[6] == 'O') ||
                (box[1] == 'O' && box[4] == 'O' && box[7] == 'O') || (box[2] == 'O' && box[5] == 'O' && box[8] == 'O') ||
                (box[0] == 'O' && box[4] == 'O' && box[8] == 'O') || (box[2] == 'O' && box[4] == 'O' && box[6] == 'O')) {
            winner = 2;
        }
    }

    public boolean isDraw() {
        for (byte i = 0; i < 9; i++) {
            if (box[i] != 'X' && box[i] != 'O') {
                return false;
            }
        }
        return true;
    }
}
