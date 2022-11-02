package com.sokoban.controller;

import static org.junit.Assert.assertEquals;

import com.sokoban.model.Board;
import com.sokoban.model.BoardCellException;
import com.sokoban.model.Cell;
import org.junit.Test;

/**
 * Game class tests.
 */
public class GameTest {
    private final Board b = new Board("Test Board", 4, 20);

    /**
     * Test of the up move of the player.
     * 
     * @throws BoardCellException the cell coordinates of the board are
     * not valid
     */
    @Test
    public void GameMoveUp() throws BoardCellException {
        Cell p = Board.getCell(1, 0);
        if (p != null) {
            Cell ceAdjacent = Board.getCell(p.getRow() - 1, p.getColumn());

            assertEquals(Board.getCell(0, 0), ceAdjacent);
        }
    }
    
    /**
     * Test of the left move of the player.
     * 
     * @throws BoardCellException the cell coordinates of the board are
     * not valid
     */
    @Test
    public void GameMoveLeft() throws BoardCellException {
        Cell p = Board.getCell(0, 1);

        if (p != null) {
            Cell ceAdjacent = Board.getCell(p.getRow(), p.getColumn() - 1);

            assertEquals(Board.getCell(0, 0), ceAdjacent);
        }
    }
    
    /**
     * Test of the down move of the player.
     * 
     * @throws BoardCellException the cell coordinates of the board are
     * not valid
     */
    @Test
    public void GameMoveDown() throws BoardCellException {
        Cell p = Board.getCell(0, 0);

        if (p != null) {
            Cell ceAdjacent = Board.getCell(p.getRow() + 1, p.getColumn());

            assertEquals(Board.getCell(1, 0), ceAdjacent);
        }
    }
    
    /**
     * Test of the right move of the player.
     * 
     * @throws BoardCellException the cell coordinates of the board are
     * not valid
     */
    @Test
    public void GameMoveRight() throws BoardCellException {
        Cell p = Board.getCell(0, 0);

        if (p != null) {
            Cell ceAdjacent = Board.getCell(p.getRow(), p.getColumn() + 1);

            assertEquals(Board.getCell(0, 1), ceAdjacent);
        }
    }
    
    /**
     * Test of the game victory.
     */
    @Test
    public void GameVictory() {
        assertEquals(0, Board.getAllTargets().size());
    }
}