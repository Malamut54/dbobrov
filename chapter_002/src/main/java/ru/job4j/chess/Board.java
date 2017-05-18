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
    Figure bishop3 = new Bishop(new Cell(3, 8));
    Figure bishop4 = new Bishop(new Cell(6, 1));
    Figure[] figures = {bishop1, bishop2, bishop3, bishop4};

    public Figure figureClone(Cell dist) {
        figure.setPosition(dist);
        return figure;
    }


    boolean move(Cell source, Cell dist) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {


        for (int i = 0; i < this.figures.length; ) {
            if (figures[i].getPosition().getX() == source.getX() && figures[i].getPosition().getY() == source.getY()) {
                this.figure = figures[i];
                break;
            } else if (figures[i].getPosition().getX() != source.getX() && figures[i].getPosition().getY() != source.getY()) {
                i++;
            } else {
                throw new FigureNotFoundException("Figure not found");
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
        figure = figureClone(dist);
        return true;
    }

}
