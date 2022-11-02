package com.sokoban.controller.boardBuild;

import com.sokoban.model.Board;
import com.sokoban.model.BoardCellException;
import com.sokoban.model.Cell;
import com.sokoban.model.Item;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * A board created using text.
 */
public class TextBoardBuilder implements BoardBuilder {
    private final String TITLE;
    private final int SIZE_X;
    private final int SIZE_Y;
    private Board b;

    /**
     * TextBoardBuilder constructor.
     *
     * @param title title of the board
     * @param sizeX length of the board abscissa
     * @param sizeY length of the board ordinate
     */
    public TextBoardBuilder(String title, int sizeX, int sizeY) {
        this.TITLE = title;
        this.SIZE_X = sizeX;
        this.SIZE_Y = sizeY;
        this.build();
    }

    /**
     * Get the title of the board.
     *
     * @return the title of a board
     */
    @Override
    public String getTitle() {
        return this.TITLE;
    }

    /**
     * Get the length of the board abscissa.
     *
     * @return the length of a board abscissa
     */
    @Override
    public int getSizeX() {
        return this.SIZE_X;
    }

    /**
     * Get the length of the board ordinate.
     *
     * @return the length of a board ordinate
     */
    @Override
    public int getSizeY() {
        return this.SIZE_Y;
    }

    /**
     * Get the board.
     *
     * @return the board
     */
    public Board getBoard() {
        return this.b;
    }

    /**
     * Add a row to the board.
     *
     * @param elements row composed by elements into a string
     * @param row number of the row
     * @throws BoardCellException the cell coordinates of the board are not
     * valid
     */
    public void addRow(String elements, int row) throws BoardCellException {
        int sizeElements = elements.length();

        for (int j = 0; j < sizeElements; j++) {
            String letterStr = Character.toString(elements.charAt(j));
            Cell ce = Board.getCell(row, j);

            if (ce != null) {
                // wall
                if (letterStr.equals(Item.WALL.toString())) {
                    ce.setItem(Item.WALL);
                }
                // player
                if (letterStr.equals(Item.PLAYER.toString())) {
                    ce.setItem(Item.PLAYER);
                }
                // crate
                if (letterStr.equals(Item.CRATE.toString())) {
                    ce.setItem(Item.CRATE);
                }
                // target
                if (letterStr.equals(Item.TARGET.toString())) {
                    ce.setItem(Item.TARGET);
                }
            }
        }
    }

    /**
     * Generate a text file (file extension : .txt), from the board, which
     * contains the title, the dimensions and the board.
     *
     * @throws BoardCellException the cell coordinates of the board are not
     * valid
     * @throws BoardBuildException the board cannot be built
     */
    public void generateFile() throws BoardCellException, BoardBuildException {
        if (Board.getSizeX() <= 0 || Board.getSizeX() >= 100
                || Board.getSizeY() <= 0 || Board.getSizeY() >= 100) {
            throw new BoardBuildException(
                    "A board can't be build with a sizeX or/and a sizeY less or equal than 0 or more or equal than 100."
            );
        }

        try (
            // filename
            FileWriter fileWriter = new FileWriter("levels/" + this.b.getTitle() + ".txt");  
            PrintWriter boardFile = new PrintWriter(fileWriter)) {
            // title
            boardFile.println(this.b.getTitle());
            // dimensions
            boardFile.println("Dimensions : " + Board.getSizeX() + "x" + Board.getSizeY() + "\n");

            // board
            for (int i = 0; i <= Board.getSizeX(); i++) {
                for (int j = 0; j <= Board.getSizeY(); j++) {
                    Cell ce = Board.getCell(i, j);

                    if (ce != null) {
                        boardFile.print(ce.getItem());
                    }
                }
                boardFile.println();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Build an instance of a board.
     *
     * @return the board
     */
    @Override
    public final Board build() {
        this.b = new Board(getTitle(), getSizeX(), getSizeY());
        return getBoard();
    }
}