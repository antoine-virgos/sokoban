package com.sokoban.model;

import static com.sokoban.model.Board.getCell;
import java.util.HashSet;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Board class tests.
 */
public class BoardTest {
    private final Board b = new Board("Test Board", 4, 20);
    
    /**
     * Test of the board constructor.
     */
    @Test
    public void BoardConstructor() {
        assertEquals("Test Board", b.getTitle());
        assertEquals(4, Board.getSizeX());
        assertEquals(20, Board.getSizeY());
    }

    /**
     * Test of the player position on the board.
     * 
     * @throws BoardCellException the cell coordinates of the board are
     * not valid
     */
    @Test
    public void BoardPositionPlayer() throws BoardCellException {
        setPosition(0, 0);
        Cell ce = Board.getCell(0, 0);

        if (ce != null) {
            // Cell position
            assertEquals(ce, b.getPositionPlayer());
            // Item player
            assertEquals(ce.getItem(), b.getPositionPlayer().getItem());
        }
    }
    
    /**
     * Test of the presence of board crates on a row.
     * 
     * @throws BoardCellException the cell coordinates of the board are
     * not valid
     */
    @Test
    public void BoardCratesRow() throws BoardCellException {
        HashSet<Cell> boardCrates = new HashSet<>();
        addCrate(0, 0);
        addCrate(0, 1);
        Cell crate1 = new Cell(0, 0);
        Cell crate2 = new Cell(1, 0);
        boardCrates.add(crate1);
        boardCrates.add(crate2);
        assertEquals(boardCrates.size(), Board.getAllCratesRow(Board.getCell(0, 4)).size());
    }
    
    /**
     * Test of the presence of board crates on a column.
     * 
     * @throws BoardCellException the cell coordinates of the board are
     * not valid
     */
    @Test
    public void BoardCratesCol() throws BoardCellException {
        HashSet<Cell> boardCrates = new HashSet<>();
        addCrate(0, 0);
        addCrate(1, 0);
        Cell crate1 = new Cell(0, 0);
        Cell crate2 = new Cell(1, 0);
        boardCrates.add(crate1);
        boardCrates.add(crate2);
        assertEquals(boardCrates.size(), Board.getAllCratesCol(Board.getCell(4, 0)).size());
    }
    
    /**
     * Test of the presence of board destinations.
     * 
     * @throws BoardCellException the cell coordinates of the board are
     * not valid
     */
    @Test
    public void BoardDestinations() throws BoardCellException {
        HashSet<Cell> boardDestinations = new HashSet<>();
        addTarget(0, 0);
        addTarget(4, 17);
        Cell dest1 = new Cell(0, 0);
        Cell dest2 = new Cell(4, 17);
        boardDestinations.add(dest1);
        boardDestinations.add(dest2);
        assertEquals(boardDestinations.size(), Board.getAllTargets().size());
    }
    
    /**
     * Display a crate on the board.
     *
     * @param row position of the cell on the line
     * @param column position of the cell on the column
     * @throws BoardCellException the cell coordinates of the board are
     * not valid
     */
    public void addCrate(int row, int column) throws BoardCellException {
        Cell ce = getCell(row, column);

        if (ce != null) {
            ce.setItem(Item.CRATE);
        }
    }

    /**
     * Display a target on the board.
     *
     * @param row position of the cell on the line
     * @param column position of the cell on the column
     * @throws BoardCellException the cell coordinates of the board are
     * not valid
     */
    public void addTarget(int row, int column) throws BoardCellException {
        Cell ce = getCell(row, column);

        if (ce != null) {
            ce.setItem(Item.TARGET);
        }
    }

    /**
     * Display a player on the board.
     *
     * @param row position of the cell on the line
     * @param column position of the cell on the column
     * @throws BoardCellException the cell coordinates of the board are
     * not valid
     */
    public void setPosition(int row, int column) throws BoardCellException {
        Cell ce = getCell(row, column);

        if (ce != null) {
            ce.setItem(Item.PLAYER);
        }
    }
}