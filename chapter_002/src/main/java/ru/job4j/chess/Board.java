package ru.job4j.chess;

import ru.job4j.chess.figure.*;
import ru.job4j.chess.exception.*;
/**
 * Final task. Chess.
 */
public class Board {
    private Figure[] figures;
//    Figure bishopLeft = new Bishop(new Cell(0,2), "bishopLeft");

    boolean move(Cell source, Cell dist) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        return true;
    }

}
