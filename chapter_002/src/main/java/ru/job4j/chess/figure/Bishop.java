package ru.job4j.chess.figure;

import ru.job4j.chess.Cell;
import ru.job4j.chess.exception.ImpossibleMoveException;

/**
 * Created by kvazimoda on 12.05.2017.
 */
public class Bishop extends Figure {
    private Cell position;
    private Cell[] waysToDist = new Cell[9];

    public Bishop(Cell position) {
        super(position);
        this.position = position;
    }

    @Override
    public Cell[] way(Cell dest) throws ImpossibleMoveException {
        if (dest.getX() > 8 && dest.getY() > 8 | dest.getX() < 1 && dest.getY() < 1) {
            throw new ImpossibleMoveException("You went beyond the Board");
        }

        if (position.getX() - dest.getX() == position.getY() - dest.getY()) {
            for (int i = 0; i < dest.getX() - position.getX(); i++) {
                waysToDist[i] = super.oneLeft(super.oneDown(position));
                return waysToDist;
            }
        } else if (dest.getX() - position.getX() == position.getY() - dest.getY()) {
            for (int i = 0; i < dest.getX() - position.getX(); i++) {
                waysToDist[i] = super.oneRight(super.oneDown(position));
                return waysToDist;
            }
        } else if (dest.getX() - position.getX() == dest.getY() - position.getY()) {
            for (int i = 0; i < dest.getX() - position.getX(); i++) {
                waysToDist[i] = super.oneRight(super.oneUp(position));
                return waysToDist;
            }
        } else if (position.getX() - dest.getX() == dest.getY() - position.getY()) {
            for (int i = 0; i < position.getX() - dest.getX(); i++) {
                waysToDist[i] = super.oneLeft(super.oneUp(position));
                return waysToDist;
            }
        } else {
            throw new ImpossibleMoveException("Impossible move");
        }

        return waysToDist;

    }
}
