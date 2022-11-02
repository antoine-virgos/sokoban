package com.sokoban.controller.boardsDatabaseManager;

import com.sokoban.model.BoardCellException;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

/**
 * BoardsDatabase class tests.
 */
public class BoardsDatabaseTest {
    
    /**
     * Test of the board got using BoardsDatabase. 
     * 
     * @throws BoardCellException the cell coordinates of the board are
     * not valid
     */
    @Test
    public void BoardsDatabaseGet() throws BoardCellException {
        // A Simple Board
        Assert.assertEquals("A Simple Board", BoardsDatabase.get("simple").getTitle());
        // The Zagreus trial
        assertEquals("The Zagreus trial", BoardsDatabase.get("difficult").getTitle());
    }
}