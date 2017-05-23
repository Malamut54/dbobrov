package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.exception.FigureNotFoundException;
import ru.job4j.chess.exception.ImpossibleMoveException;
import ru.job4j.chess.exception.OccupiedWayException;
import ru.job4j.chess.figure.Queen;
import ru.job4j.chess.figure.Figure;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Queen.
 *
 * @author Dmitriy Bobrov (mailto:bobrov.dmitriy@gmail.com)
 * @version $id$
 * @since 0.1
 */
public class QueenTest {
    /**
     * Test when move takes place outside the board.
     *
     * @throws FigureNotFoundException Figure not found.
     * @throws OccupiedWayException    Figure on the way.
     * @throws ImpossibleMoveException Figure make impossible move.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenWentBeyondTheBoard() throws FigureNotFoundException, OccupiedWayException, ImpossibleMoveException {
        Figure figure = new Queen(new Cell(2, 1));
        figure.way(new Cell(1, 10));
    }


    /**
     * Test when figure not found.
     *
     * @throws FigureNotFoundException Figure not found.
     * @throws OccupiedWayException    Figure on the way.
     * @throws ImpossibleMoveException Figure make impossible move.
     */
    @Test(expected = FigureNotFoundException.class)
    public void whenFigureNotFound() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        Cell source = new Cell(3, 1);
        Cell destination = new Cell(7, 1);
        board.addFigureToBoard(new Queen(new Cell(2, 1)));
        board.move(source, destination);
    }

    /**
     * Test when figure make impossible move.
     *
     * @throws FigureNotFoundException Figure not found.
     * @throws OccupiedWayException    Figure on the way.
     * @throws ImpossibleMoveException Figure make impossible move.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenFigureMakeImpossibleMove() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        board.addFigureToBoard(new Queen(new Cell(3, 8)));
        Cell source = new Cell(3, 8);
        Cell destination = new Cell(5, 7);
        board.move(source, destination);
    }

    /**
     * Test when figure make move through occupied cell.
     *
     * @throws FigureNotFoundException Figure not found.
     * @throws OccupiedWayException    Figure on the way.
     * @throws ImpossibleMoveException Figure make impossible move.
     */
    @Test(expected = OccupiedWayException.class)
    public void whenFigureGoThroughtOccupiedCell() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        board.addFigureToBoard(new Queen(new Cell(2, 1)));
        board.addFigureToBoard(new Queen(new Cell(3, 2)));
        Cell source = new Cell(2, 1);
        Cell destination = new Cell(6, 5);
        board.move(source, destination);
    }

    /**
     * Test when figure make successfully move.
     *
     * @throws FigureNotFoundException Figure not found.
     * @throws OccupiedWayException    Figure on the way.
     * @throws ImpossibleMoveException Figure make imposible move.
     */
    @Test
    public void whenFigureSuccesfullyMakeMove() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        board.addFigureToBoard(new Queen(new Cell(6, 1)));
        Cell source = new Cell(6, 1);
        Cell destination = new Cell(7, 2);
        board.move(source, destination);
        Figure[] figures = board.getFigures();
        Cell result = figures[0].getPosition();
        assertThat(result, is(destination));
    }
}
