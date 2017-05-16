package ru.job4j.chess.figure;

import ru.job4j.chess.Cell;
import ru.job4j.chess.exception.ImpossibleMoveException;

/**
 * Final task. Chess.
 */
public abstract class Figure {
    private Cell position;

    public Figure() {
    }

    public Figure(Cell position) {
        this.position = position;
    }

    public Cell getPosition() {
        return position;
    }

    public abstract Cell[] way(Cell dist) throws ImpossibleMoveException;

    public Cell oneLeft(Cell cell) {
        return new Cell(cell.getX() - 1, cell.getY());
    }

    public Cell oneRight(Cell cell) {
        return new Cell(cell.getX() + 1, cell.getY());
    }

    public Cell oneUp(Cell cell) {
        return new Cell(cell.getX(), cell.getY() + 1);
    }

    public Cell oneDown(Cell cell) {
        return new Cell(cell.getX(), cell.getY() - 1);
    }

}
