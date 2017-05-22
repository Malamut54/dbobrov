package ru.job4j.chess.figure;

import ru.job4j.chess.Cell;
import ru.job4j.chess.exception.ImpossibleMoveException;

import java.util.Arrays;



public class Bishop extends Figure {
    private Cell position;

    public Bishop(Cell position) {
        super(position);
        this.position = position;
    }
    public Figure clone(Cell dist) {
        return new Bishop(dist);
    }

    @Override
    public Cell[] way(Cell dest) throws ImpossibleMoveException {
        Cell[] result;
        if (Math.abs(this.position.getX() - dest.getX()) == Math.abs(this.position.getY() - dest.getY())) {
            result = super.way(dest);
        } else {
            throw new ImpossibleMoveException("This move is impossible");
        }

        return result;
    }
}
