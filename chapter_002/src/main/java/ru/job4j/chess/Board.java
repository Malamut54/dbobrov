package ru.job4j.chess;

import ru.job4j.chess.figure.*;
import ru.job4j.chess.exception.*;
/**
 * Final task. Chess.
 */
public class Board {
    private Figure[] figures = new Figure[9];

    public void addFigure(Figure figure) {
        figures[0] = new Bishop(new Cell(2, 0), "white Bishop");
    }

    public boolean move(Cell source, Cell dist) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        for (Figure figure : figures) {
            if (source.getY() != figure.)
        }
        return true;
    }

}
