package ru.job4j.chess;

/**
 * Final task. Chess.
 */
public abstract class Figure {
    String name;
    final Cell StartPosition;

    public Figure(Cell startPosition) {
        this.StartPosition = startPosition;
    }

    Cell[] way(Cell dist) {

    }
}
