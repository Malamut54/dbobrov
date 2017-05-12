package ru.job4j.chess.figure;

import ru.job4j.chess.Cell;
import ru.job4j.chess.exception.ImpossibleMoveException;

/**
 * Final task. Chess.
 */
public abstract class Figure {
    private Cell position;
    private String name;
    public static final int LENGTHBOARD = 8;


    public Figure(Cell position, String name) {
        this.position = position;
        this.name = name;
    }

    abstract Cell[] way(Cell dist) throws ImpossibleMoveException;

}
