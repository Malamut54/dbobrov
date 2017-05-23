package ru.job4j.chess.figure;

import ru.job4j.chess.Cell;
import ru.job4j.chess.exception.ImpossibleMoveException;

/**
 * Created by kvazimoda on 23.05.2017.
 */
public class Queen extends Figure {
    /**
     * Class Bishop. Provides the logic of the movements of the figures.
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
    public Queen(Cell position) {
        super(position);
        this.position = position;
    }

    /**
     * Method record new position if figure successfully make move.
     *
     * @param dest Destination figure on the board.
     * @return Figure with new position.
     */
    @Override
    public Figure clone(Cell dest) {
        return new Queen(dest);
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
        if (Math.abs(this.position.getX() - dest.getX()) == Math.abs(this.position.getY() - dest.getY())
                || this.position.getX() == dest.getX() & this.position.getY() != dest.getY()
                || this.position.getY() == dest.getY() & this.position.getX() != dest.getX()) {
            result = super.way(dest);
        } else {
            throw new ImpossibleMoveException("This move is impossible");
        }

        return result;
    }
}
