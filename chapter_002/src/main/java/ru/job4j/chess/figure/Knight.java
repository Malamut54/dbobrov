package ru.job4j.chess.figure;

import ru.job4j.chess.Cell;
import ru.job4j.chess.exception.ImpossibleMoveException;

/**
 * Task Chess.
 */
public class Knight extends Figure {
    /**
     * Class Knight. Provides the logic of the movements of the figures.
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
    public Knight(Cell position) {
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
        Cell[] result = {dest};
        if (Math.abs(position.getY() - dest.getY()) == 1 && Math.abs(position.getX() - dest.getX()) == 2
                || Math.abs(position.getY() - dest.getY()) == 2 && Math.abs(position.getX() - dest.getX()) == 1) {
            clone(dest);
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

        return new Knight(dest);
    }
}
