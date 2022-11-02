package com.sokoban.controller.boardBuild;

import com.sokoban.model.Board;
import com.sokoban.model.BoardCellException;
import com.sokoban.model.Cell;
import com.sokoban.model.Item;
import java.io.File;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * TextBoardBuilder class tests.
 */
public class TextBoardBuilderTest {
    private final TextBoardBuilder BUILDER = new TextBoardBuilder("Test Builder", 10, 5);
    
    /**
     * Test of the TextBoardBuilder constructor.
     */
    @Test
    public void TextBoardBuilderConstructor() {
        assertEquals("Test Builder", BUILDER.getTitle());
        assertEquals(10, BUILDER.getSizeX());
        assertEquals(5, BUILDER.getSizeY());
    }
    
    /**
     * Test of the creation of the row. 
     * 
     * @throws BoardCellException the cell coordinates of the board are
     * not valid
     */
    @Test
    public void TextBoardBuilderAddRow() throws BoardCellException {
        BUILDER.addRow("#.#.#.", 0);

        Cell ce = Board.getCell(0, 0);
        Cell ce2 = Board.getCell(0, 1);
        Cell ce3 = Board.getCell(0, 2);

        if (ce != null) {
            assertEquals(Item.WALL, ce.getItem());
        }

        if (ce2 != null) {
            assertEquals(Item.VOID, ce2.getItem());
        }

        if (ce3 != null) {
            assertEquals(Item.WALL, ce3.getItem());
        }
    }
    
    /**
     * Test of the creation of the file generation.
     * 
     * @throws BoardCellException the cell coordinates of the board are
     * not valid
     * @throws BoardBuildException the board cannot be built
     */
    @Test
    public void TextBoardBuilderGenerateFile() throws BoardCellException, BoardBuildException {
        Board b = BUILDER.build();
        BUILDER.addRow("#x#.#.", 0);
        BUILDER.addRow("#.#.#.", 1);
        BUILDER.addRow("#.#.#.", 2);
        BUILDER.addRow("#.#.#C", 3);
        BUILDER.addRow("#.#.#.", 4);
        BUILDER.addRow("#.#.#P", 5);
        
        File testFile = new File("levels/" + b.getTitle() + ".txt");
        
        BUILDER.generateFile();
        // Test file existence
        assertTrue(testFile.exists());
        // Test file content
        assertEquals(109, testFile.length());
        
        testFile.delete(); // comment this line if you want to see, in details, the board created
    }
}