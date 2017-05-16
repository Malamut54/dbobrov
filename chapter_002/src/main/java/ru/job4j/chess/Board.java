package ru.job4j.chess;

import ru.job4j.chess.figure.*;
import ru.job4j.chess.exception.*;
/**
 * Final task. Chess.
 */
public class Board {
    Figure figure;
    Figure bishop1 = new Bishop(new Cell(2, 1));
    Figure bishop2 = new Bishop(new Cell(4, 3));
    Figure[] figures = {bishop1, bishop2};

    boolean move(Cell source, Cell dist) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        for (Figure figure : figures) {
            if (figure.getPosition().getX() == source.getX() && figure.getPosition().getY() == source.getY()) {
                break;
            } else {
                throw new FigureNotFoundException("Figure not found");
            }
        }

        for (Figure x : figures) {
            if (x.getPosition().getX() == source.getX() && x.getPosition().getY() == source.getY()) {
                figure = x;
                figure.way(dist);
            }
        }
        for (Figure x : figures) {
            if (x.getPosition().getX() == source.getX() && x.getPosition().getY() == source.getY()) {
                figure = x;
                break;
            }
        }
        Cell[] waysToDist = figure.way(dist);
        for (Figure x : figures) {
            for (Cell cell : waysToDist) {
                if (x.getPosition().getX() == cell.getX() && x.getPosition().getY() == cell.getY()) {
                    throw new OccupiedWayException("Occupied Way");
                }
            }
        }

        return true;
    }

}
