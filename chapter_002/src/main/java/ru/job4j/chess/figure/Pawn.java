package ru.job4j.chess.figure;

import ru.job4j.chess.Cell;
import ru.job4j.chess.exception.ImpossibleMoveException;

/**
 * Task Chess.
 */
public class Pawn extends Figure {
    /**
     * Class Pawn. Provides the logic of the movements of the figures.
     */

    /**
     * Private fields.
     */
    private Cell position;

    /**
     * Constructor for figure position.
     *
     * @param position Set figure position.
     */
    public Pawn(Cell position) {
        super(position);
        this.position = position;
    }

    /**
     * Method way. Provides the movement of the figures.
     *
     * @param dest Destination figure on the board.
     * @return way to destination.
     * @throws ImpossibleMoveException Figure make impossible move.
     */
    @Override
    public Cell[] way(Cell dest) throws ImpossibleMoveException {

        Cell[] result;
        if (position.getY() == 2 & dest.getY() > position.getY() & Math.abs(position.getY() - dest.getY()) <= 2
                & position.getX() - dest.getX() == 0
                || position.getY() >= 3 & dest.getY() > position.getY() & Math.abs(position.getY() - dest.getY()) <= 1
                & position.getX() - dest.getX() == 0) {
            result = super.way(dest);
        } else {
            throw new ImpossibleMoveException("This move is impossible");
        }
        return result;
    }

    /**
     * Method record new position if figure successfully make move.
     *
     * @param dest Destination figure on the board.
     * @return Figure with new position.
     */
    @Override
    public Figure clone(Cell dest) {
        return new Pawn(dest);
    }
}
