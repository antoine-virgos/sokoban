package com.sokoban.model;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * BoardCellException class test.
 */
public class BoardCellExceptionTest {
        
    /**
     * Test to check BoardCellException of the getCell method. 
     * 
     * @throws BoardCellException the cell coordinates of the board are
     * not valid
     */
    @Test
    public void BoardGetCellException() throws BoardCellException {
        Cell ce = Board.getCell(-1, 0);
        Cell ce2 = Board.getCell(0, 21);

        if (ce != null) {
            assertEquals(Item.VOID, ce.getItem());
        }

        if (ce2 != null) {
            assertEquals(Item.VOID, ce2.getItem());
        }
    }
}