package com.sokoban.controller.boardBuild;

import com.sokoban.model.Board;

/**
 * BoardBuilder interface.
 */
public interface BoardBuilder {
    
    /**
     * Build an instance of a board.
     * 
     * @return the board
     */
    Board build();
    
    /**
     * Get the title of the board.
     * 
     * @return the title of a board
     */
    String getTitle();
    
    /**
     * Get the length of the board abscissa.
     * 
     * @return the length of a board abscissa
     */
    int getSizeX();
    
    /**
     * Get the length of the board ordinate.
     * 
     * @return the length of a board ordinate
     */
    int getSizeY();
}