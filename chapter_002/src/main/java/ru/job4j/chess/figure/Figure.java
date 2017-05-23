package ru.job4j.chess.figure;

import ru.job4j.chess.Cell;
import ru.job4j.chess.exception.ImpossibleMoveException;
import java.util.Arrays;

/**
 * Task Chess.
 */
public abstract class Figure {
    /**
     * Class Figure. Provides the logic of the movements of the figures.
     */

    /**
     * Private fields.
     */
    private Cell position;
    /**
     * Private fields.
     */
    private Cell[] waysToDest = new Cell[9];

    /**
     * Constructor for figure position.
     *
     * @param position Set figure position.
     */
    public Figure(Cell position) {
        this.position = position;
    }

    /**
     * Getter for figure position.
     * @return position figure(Cell).
     */
    public Cell getPosition() {
        return position;
    }

    /**
     * Method way. Provides the movement of the figures.
     * @param dest Destination figure on the board.
     * @return way to destination.
     * @throws ImpossibleMoveException Figure make impossible move.
     */
    public Cell[] way(Cell dest) throws ImpossibleMoveException {
        int lenghtMove = 0;
        int posX = this.position.getX();
        int posY = this.position.getY();

        if (this.position.getX() != dest.getX()) {
            lenghtMove = Math.abs(this.position.getX() - dest.getX());
        } else if (this.position.getY() != dest.getY()) {
            lenghtMove = Math.abs(this.position.getY() - dest.getY());
        }
        for (int i = 0; i < lenghtMove; i++) {
            int xMove = dest.getX() > position.getX() ? 1 : dest.getX() < position.getX() ? -1 : 0;
            int yMove = dest.getY() > position.getY() ? 1 : dest.getY() < position.getY() ? -1 : 0;

            posX += xMove;
            posY += yMove;
            waysToDest[i] = new Cell(posX, posY);
        }
        waysToDest = Arrays.copyOf(waysToDest, lenghtMove);

        if (waysToDest[waysToDest.length - 1].getX() != dest.getX()
                || waysToDest[waysToDest.length - 1].getY() != dest.getY()) {
            throw new ImpossibleMoveException("Impossible move");
        }
        return waysToDest;
    }

    /**
     * Method record new position if figure successfully make move.
     *
     * @param dest Destination figure on the board.
     * @return Figure with new position.
     */
    public abstract Figure clone(Cell dest);
}
