package com.sokoban.view;

import com.sokoban.controller.boardsDatabaseManager.BoardsDatabase;
import com.sokoban.model.BoardCellException;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * A player.
 */
public class Player {
    private static final Scanner IN = new Scanner(System.in);
    private static final PrintStream OUT = System.out;

    /**
     * Remove spaces from the string.
     *
     * @return the line lacking in spaces, wrote by a user
     */
    private static String read() {
        return IN.nextLine().trim();
    }

    /**
     * Main program.
     *
     * @param args the command line arguments
     * @throws BoardCellException if the cell coordinates of the board
     * are not valid
     */
    public static void main(String[] args) throws BoardCellException {
        BoardsDatabase.loadDatabase();
        
        OUT.println("| Welcome to Sokoban Project ! |" + "\n");
        
        boolean loop = true;
        while (loop) {
            OUT.println("1. List boards");
            OUT.println("2. Select a board and play");
            OUT.println("3. Quit." + "\n");
            OUT.println("* Type a number to use a command.");
            String command = read();
            OUT.println();
            switch (command) {
                case "1": BoardsDatabase.executeListCommand(); break;
                case "2": BoardsDatabase.executeSelectBoardCommand(); break;
                case "3": loop = false; break;
                default: OUT.println("Command not found : \"" + command + "\"." + "\n"); break;
            }
        }
    }
}