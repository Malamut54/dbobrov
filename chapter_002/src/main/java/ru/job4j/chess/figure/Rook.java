package ru.job4j.chess.figure;

import ru.job4j.chess.Cell;
import ru.job4j.chess.exception.ImpossibleMoveException;

/**
 * Task Chess.
 */
public class Rook extends Figure {
    /**
     * Class Rook. Provides the logic of the movements of the figures.
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
    public Rook(Cell position) {
        super(position);
        this.position = position;
    }

    /**
     * Method record new position if figure successfully make move.
     *
     * @param dest Destination figure on the board.
     * @return Figure with new position.
     */
    public Figure clone(Cell dest) {
        return new Rook(dest);
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
        if (this.position.getX() == dest.getX() & this.position.getY() != dest.getY()
                || this.position.getY() == dest.getY() & this.position.getX() != dest.getX()) {
            result = super.way(dest);
        } else {
            throw new ImpossibleMoveException("This move is impossible");
        }
        return result;
    }
}
