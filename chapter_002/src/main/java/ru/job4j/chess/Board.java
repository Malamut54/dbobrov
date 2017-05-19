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


    public Figure[] getFigures() {
        return figures;
    }

    public void fillBoard() {
        figures[0] = new Bishop(new Cell(2, 1));
        figures[1] = new Bishop(new Cell(4, 3));
        figures[2] = new Bishop(new Cell(3, 8));
        figures[3] = new Bishop(new Cell(6, 1));
    }

    boolean move(Cell source, Cell dist) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        int positions = 0;
        for (int i = 0; i < this.figures.length; ) {
            if (figures == null) {
                break;
            } else {
                if (figures[i].getPosition().getX() == source.getX() && figures[i].getPosition().getY() == source.getY()) {
                    positions = i;
                    this.figure = figures[i];
                    break;
                } else if (i == figures.length - 1) {
                    throw new FigureNotFoundException("Figure not found");
                } else if (figures[i].getPosition().getX() != source.getX() || figures[i].getPosition().getY() != source.getY()) {
                    i++;
                }
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
        this.figures[positions] = this.figures[positions].clone(dist);
        return true;
    }

}
