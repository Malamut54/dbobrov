package ru.job4j.chess.figure;

import ru.job4j.chess.Cell;
import ru.job4j.chess.exception.ImpossibleMoveException;

/**
 * Created by kvazimoda on 12.05.2017.
 */
public class Bishop extends Figure {
    private Cell position = new Cell(2, 0);
    private Cell[] waysToDist = new Cell[9];
    private int count = 0;

    public Bishop(Cell position, String name) {
        super(position, name);
    }

    @Override
    public Cell[] way(Cell dist) throws ImpossibleMoveException {
        if (0 <= dist.getX() && LENGTHBOARD <= dist.getX() &&
                0 <= dist.getY() && LENGTHBOARD <= dist.getY()) {

        }
        if (position.getX() - dist.getX() == position.getY() + dist.getY()) {
        }
        if (dist.getX() - position.getX() == dist.getY() - position.getY()) {
        }
        if (position.getX() - dist.getX() == position.getY() - dist.getY()) {
        }

        return new Cell[0];
    }
}
