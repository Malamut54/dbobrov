package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.exception.FigureNotFoundException;
import ru.job4j.chess.exception.ImpossibleMoveException;
import ru.job4j.chess.exception.OccupiedWayException;
import ru.job4j.chess.figure.Bishop;
import ru.job4j.chess.figure.Figure;

public class BishopTest {
    @Test(expected = ImpossibleMoveException.class)
    public void WhenWentBeyondTheBoard() throws FigureNotFoundException, OccupiedWayException, ImpossibleMoveException {
        Figure figure = new Bishop(new Cell(2, 1));
        figure.way(new Cell(10, 10));
    }

    @Test(expected = FigureNotFoundException.class)
    public void WhenFigureNotFound() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        Cell source = new Cell(3, 1);
        Cell destination = new Cell(7, 1);
        board.move(source, destination);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void WhenFigureMakeImpossibleMove() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        Cell source = new Cell(3, 8);
        Cell destination = new Cell(5, 7);
        board.move(source, destination);

    }

    @Test(expected = OccupiedWayException.class)
    public void WhenFigureGoThroughtOccupiedCell() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        Cell source = new Cell(2, 1);
        Cell destination = new Cell(6, 5);
        board.move(source, destination);
    }


}
