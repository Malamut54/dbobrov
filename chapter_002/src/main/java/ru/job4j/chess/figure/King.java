package ru.job4j.chess.figure;

import ru.job4j.chess.Cell;
import ru.job4j.chess.exception.ImpossibleMoveException;

/**
 * Created by kvazimoda on 23.05.2017.
 */
public class King extends Figure {
    /**
     * Class King. Provides the logic of the movements of the figures.
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
    public King(Cell position) {
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
        if (Math.abs(this.position.getX() - dest.getX()) <= 1 && Math.abs(this.position.getY() - dest.getY()) <= 1) {
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
        return new King(dest);
    }
}
