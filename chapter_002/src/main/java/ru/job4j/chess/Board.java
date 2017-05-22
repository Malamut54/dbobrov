package ru.job4j.chess;

import ru.job4j.chess.figure.*;
import ru.job4j.chess.exception.*;

public class Board {
    Figure figure;
    //    Figure bishop1 = new Bishop(new Cell(2, 1));
//    Figure bishop2 = new Bishop(new Cell(4, 3));
//    Figure bishop3 = new Bishop(new Cell(3, 8));
//    Figure bishop4 = new Bishop(new Cell(6, 1));
//    Figure[] figures = {bishop1, bishop2, bishop3, bishop4};
    private Figure[] figures = new Figure[32];
    private int countArrFig = 0;


    public Figure[] getFigures() {
        return figures;
    }


    public void addFigureToBoard(Figure figure) {
        figures[countArrFig++] = figure;
    }

    boolean move(Cell source, Cell dist) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        int positions = 0;
        for (int i = 0; i < this.figures.length; ) {
            if (i == figures.length - 1 & figures[i] == null) {
                throw new FigureNotFoundException("Figure not found");
            }
            if (figures[i] == null) {
                i++;
            } else {
                if (figures[i].getPosition().equals(source)) {
                    positions = i;
                    this.figure = figures[i];
                    break;
                } else if (!figures[i].getPosition().equals(source)) {
                    i++;
                }
            }
        }

        Cell[] waysToDist = figure.way(dist);
        for (Figure x : figures) {
            if (x != null) {
                for (Cell cell : waysToDist) {
                    if (x.getPosition().equals(cell)) {
                        throw new OccupiedWayException("Occupied Way");
                    }
                }
            }
        }
        this.figures[positions] = this.figures[positions].clone(dist);
        return true;
    }

}
