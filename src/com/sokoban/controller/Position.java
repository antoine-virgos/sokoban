package com.sokoban.controller;

import com.sokoban.model.BoardCellException;
import com.sokoban.model.Cell;
import com.sokoban.model.Item;

import java.util.HashSet;

/**
 * A modifier for a cell position.
 */
public class Position extends Game {

    /**
     * Position constructor.
     * 
     * @param title title of the board
     * @param sizeX length of the board abscissa
     * @param sizeY length of the board ordinate
     */
    public Position(String title, int sizeX, int sizeY) {
        super(title, sizeX, sizeY);
    }

    /**
     * Move the player to a void cell.
     * 
     * @param p player cell
     * @param adj adjacent cell to the player cell
     */
    static void movePlayerCell(Cell p, Cell adj) {
        if (adj.getItem().equals(Item.VOID)) {
            adj.setItem(Item.PLAYER);
            p.setItem(Item.VOID);
        }
    }

    /**
     * Move a crate or multiple crates to a void cell or a target.
     * 
     * @param p player cell
     * @param adj adjacent cell to the player cell
     * @param direction direction to move
     * @throws BoardCellException the cell coordinates of the board are
     * not valid
     */
    static void crateMove(Cell p, Cell adj, char direction) throws BoardCellException {
        switch (direction) {
            // up
            case 'U':
                Cell ceDestinationUp = getCell(p.getRow() - 2, p.getColumn());

                if (ceDestinationUp != null) {
                    // multiple crates
                    if (getAllCratesCol(p).size() > 0 && !ceDestinationUp.getItem().equals(Item.VOID)) {
                        Cell ceCrateMoved = getCell(p.getRow() - (getAllCratesCol(p).size() + 1), p.getColumn());

                        if (ceCrateMoved != null) {
                            if (adj.getItem().equals(Item.CRATE)
                                    && ceCrateMoved.getItem().equals(Item.VOID)
                                    || ceCrateMoved.getItem().equals(Item.TARGET)) {
                                adj.setItem(Item.PLAYER);
                                ceCrateMoved.setItem(Item.CRATE);
                                p.setItem(Item.VOID);
                            }
                        }
                    // unique crate
                    } else if (getAllCratesCol(p).size() > 0 && ceDestinationUp.getItem().equals(Item.VOID)) {
                        if (adj.getItem().equals(Item.CRATE)) {
                            Cell ceUniqueCrateMoved = getCell(p.getRow() - 2, p.getColumn());

                            if (ceUniqueCrateMoved != null) {
                                ceUniqueCrateMoved.setItem(Item.CRATE);
                                adj.setItem(Item.PLAYER);
                                p.setItem(Item.VOID);
                            }
                        }
                    }
                }

                break;
            // left
            case 'L':
                Cell ceDestinationLeft = getCell(p.getRow(), p.getColumn() - 2);

                if (ceDestinationLeft != null) {
                    // multiple crates
                    if (getAllCratesRow(p).size() > 0 && !ceDestinationLeft.getItem().equals(Item.VOID)) {
                        Cell ceCrateMoved = getCell(p.getRow(), p.getColumn() - (getAllCratesRow(p).size() + 1));

                        if (ceCrateMoved != null) {
                            if (adj.getItem().equals(Item.CRATE)
                                    && ceCrateMoved.getItem().equals(Item.VOID)
                                    || ceCrateMoved.getItem().equals(Item.TARGET)) {
                                adj.setItem(Item.PLAYER);
                                ceCrateMoved.setItem(Item.CRATE);
                                p.setItem(Item.VOID);
                            }
                        }
                    // unique crate
                    } else if (getAllCratesRow(p).size() > 0 && ceDestinationLeft.getItem().equals(Item.VOID)) {
                        if (adj.getItem().equals(Item.CRATE)) {
                            Cell ceUniqueCrateMoved = getCell(p.getRow(), p.getColumn() - 2);

                            if (ceUniqueCrateMoved != null) {
                                ceUniqueCrateMoved.setItem(Item.CRATE);
                                adj.setItem(Item.PLAYER);
                                p.setItem(Item.VOID);
                            }
                        }
                    }
                }

                break;
            // down
            case 'D':
                Cell ceDestinationDown = getCell(p.getRow() + 2, p.getColumn());

                if (ceDestinationDown != null) {
                    // multiple crates
                    if (getAllCratesCol(p).size() > 0 && !ceDestinationDown.getItem().equals(Item.VOID)) {
                        Cell ceCrateMoved = getCell(p.getRow() + (getAllCratesCol(p).size() + 1), p.getColumn());

                        if (ceCrateMoved != null) {
                            if (adj.getItem().equals(Item.CRATE)
                                    && ceCrateMoved.getItem().equals(Item.VOID)
                                    || ceCrateMoved.getItem().equals(Item.TARGET)) {
                                adj.setItem(Item.PLAYER);
                                ceCrateMoved.setItem(Item.CRATE);
                                p.setItem(Item.VOID);
                            }
                        }
                    // unique crate
                    } else if (getAllCratesCol(p).size() > 0 && ceDestinationDown.getItem().equals(Item.VOID)) {
                        if (adj.getItem().equals(Item.CRATE)) {
                            Cell ceUniqueCrateMoved = getCell(p.getRow() + 2, p.getColumn());

                            if (ceUniqueCrateMoved != null) {
                                ceUniqueCrateMoved.setItem(Item.CRATE);
                                adj.setItem(Item.PLAYER);
                                p.setItem(Item.VOID);
                            }
                        }
                    }
                }

                break;
            // right
            case 'R':
                Cell ceDestinationRight = getCell(p.getRow(), p.getColumn() + 2);

                if (ceDestinationRight != null) {
                    // multiple crates
                    if (getAllCratesRow(p).size() > 0 && !ceDestinationRight.getItem().equals(Item.VOID)) {
                        Cell ceCrateMoved = getCell(p.getRow(), p.getColumn() + (getAllCratesRow(p).size() + 1));

                        if (ceCrateMoved != null) {
                            if (adj.getItem().equals(Item.CRATE)
                                    && ceCrateMoved.getItem().equals(Item.VOID)
                                    || ceCrateMoved.getItem().equals(Item.TARGET)) {
                                adj.setItem(Item.PLAYER);
                                ceCrateMoved.setItem(Item.CRATE);
                                p.setItem(Item.VOID);
                            }
                        }
                    // unique crate
                    } else if (getAllCratesRow(p).size() > 0 && ceDestinationRight.getItem().equals(Item.VOID)) {
                        if (adj.getItem().equals(Item.CRATE)) {
                            Cell ceUniqueCrateMoved = getCell(p.getRow(), p.getColumn() + 2);

                            if (ceUniqueCrateMoved != null) {
                                ceUniqueCrateMoved.setItem(Item.CRATE);
                                adj.setItem(Item.PLAYER);
                                p.setItem(Item.VOID);
                            }
                        }
                    }
                }

                break;
            default: System.out.println("Unknown direction !\n"); break;
        }
    }

    /**
     * Block a crate to the player if it has reach a target.
     * 
     * @param ceCrate crate cell
     * @param cratesBeforeUpdateTargets HashSet collection of the crates
     * from the board before an update of the targets (deletion of 
     * target)
     * @return true if the crate has reach a target, false if it isn't
     */
    static boolean blockCrate(Cell ceCrate, HashSet<Cell> cratesBeforeUpdateTargets) {
        for (Cell ce : cratesBeforeUpdateTargets) {
            if (ceCrate.getRow() == ce.getRow() && ceCrate.getColumn() == ce.getColumn()) {
                ceCrate.setBlockState(true);
            }
        }

        return !ceCrate.getBlockState();
    }
}