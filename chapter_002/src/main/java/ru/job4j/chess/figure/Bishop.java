package ru.job4j.chess.figure;

import ru.job4j.chess.Cell;
import ru.job4j.chess.exception.ImpossibleMoveException;

/**
 * Created by kvazimoda on 12.05.2017.
 */
public class Bishop extends Figure {
    private Cell position;
    private Cell[] waysToDist = new Cell[18];
    private int count = 0;

    public Bishop(Cell position, String name) {
        super(position, name);
    }

    Cell[] way(Cell dist) throws ImpossibleMoveException {
        if (0 <= dist.getX() && LENGTHBOARD <= dist.getX() &&
                0 <= dist.getY() && LENGTHBOARD <= dist.getY()) {

        }
        if (dist.getY() - position.getY() == dist.getX() - position.getX()) {

        }
        return new Cell[0];
    }
}
