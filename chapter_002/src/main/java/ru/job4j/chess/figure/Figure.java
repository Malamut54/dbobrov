package ru.job4j.chess.figure;

import ru.job4j.chess.Cell;
import ru.job4j.chess.exception.ImpossibleMoveException;

import java.util.Arrays;


public abstract class Figure {
    private Cell position;
    private Cell[] waysToDest = new Cell[9];
    public Figure() {
    }

    public Figure(Cell position) {
        this.position = position;
    }

    public Cell getPosition() {
        return position;
    }

    public Cell[] way(Cell dest) throws ImpossibleMoveException {
        int lenghtMove = 0;
        int posX = this.position.getX();
        int posY = this.position.getY();

        if (dest.getX() > 8 && dest.getY() > 8 || dest.getX() < 1 && dest.getY() < 1) {
            throw new ImpossibleMoveException("You went beyond the Board");
        }
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

        return Arrays.copyOf(waysToDest, lenghtMove);
    }


    public abstract Figure clone(Cell dist);

}
