package ru.job4j.chess;

import ru.job4j.chess.figure.Figure;
import ru.job4j.chess.exception.FigureNotFoundException;
import ru.job4j.chess.exception.ImpossibleMoveException;
import ru.job4j.chess.exception.OccupiedWayException;

/**
 * Task Chess.
 */
public class Board {
    /**
     * Class Board.
     */

    /**
     * Private fields.
     */
    private Figure figure;

    /**
     * Private fields.
     */
    private Figure[] figures = new Figure[32];

    /**
     * Private fields.
     */
    private int countArrFig = 0;

    /**
     * Getter for array figure.
     *
     * @return array figure.
     */
    public Figure[] getFigures() {
        return figures;
    }

    /**
     * Add figure to array.
     * @param figure which add to array.
     */
    public void addFigureToBoard(Figure figure) {
        figures[countArrFig++] = figure;
    }

    /**
     * Perform move figure.
     * @param source figure.
     * @param dest figure.
     * @return boolean.
     * @throws FigureNotFoundException Figure not found.
     * @throws OccupiedWayException Figure on the way.
     * @throws ImpossibleMoveException Figure make imposible move.
     */
    boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        int positions = 0;

        if (dest.getX() > 8 & dest.getY() > 8 || dest.getX() < 1 & dest.getY() < 1) {
            throw new ImpossibleMoveException("You went beyond the Board");
        } else if (source.getX() == dest.getX() && source.getY() == dest.getY()) {
            throw new ImpossibleMoveException("Source equals destination");
        }

        for (int i = 0; i < this.figures.length;) {
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

        Cell[] waysToDist = figure.way(dest);
        for (Figure x : figures) {
            if (x != null) {
                for (Cell cell : waysToDist) {
                    if (x.getPosition().equals(cell)) {
                        throw new OccupiedWayException("Occupied Way");
                    }
                }
            }
        }
        this.figures[positions] = this.figures[positions].clone(dest);
        return true;
    }

}
