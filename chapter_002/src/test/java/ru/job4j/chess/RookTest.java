package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.exception.FigureNotFoundException;
import ru.job4j.chess.exception.ImpossibleMoveException;
import ru.job4j.chess.exception.OccupiedWayException;
import ru.job4j.chess.figure.Rook;
import ru.job4j.chess.figure.Figure;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Rook.
 *
 * @author Dmitriy Bobrov (mailto:bobrov.dmitriy@gmail.com)
 * @version $id$
 * @since 0.1
 */
public class RookTest {
    /**
     * Test when move takes place outside the board.
     *
     * @throws FigureNotFoundException Figure not found.
     * @throws OccupiedWayException    Figure on the way.
     * @throws ImpossibleMoveException Figure make imposible move.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenWentBeyondTheBoard() throws FigureNotFoundException, OccupiedWayException, ImpossibleMoveException {
        Figure figure = new Rook(new Cell(1, 1));
        figure.way(new Cell(10, 10));
    }

    /**
     * Test when figure not found.
     *
     * @throws FigureNotFoundException Figure not found.
     * @throws OccupiedWayException    Figure on the way.
     * @throws ImpossibleMoveException Figure make imposible move.
     */
    @Test(expected = FigureNotFoundException.class)
    public void whenFigureNotFound() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        Cell source = new Cell(1, 1);
        Cell destination = new Cell(1, 8);
        board.addFigureToBoard(new Rook(new Cell(8, 1)));
        board.move(source, destination);
    }

    /**
     * Test when figure make impossible move.
     *
     * @throws FigureNotFoundException Figure not found.
     * @throws OccupiedWayException    Figure on the way.
     * @throws ImpossibleMoveException Figure make imposible move.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenFigureMakeImpossibleMove() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        board.addFigureToBoard(new Rook(new Cell(1, 1)));
        Cell source = new Cell(1, 1);
        Cell destination = new Cell(2, 2);
        board.move(source, destination);
    }

    /**
     * Test when figure make move through occupied cell.
     *
     * @throws FigureNotFoundException Figure not found.
     * @throws OccupiedWayException    Figure on the way.
     * @throws ImpossibleMoveException Figure make imposible move.
     */
    @Test(expected = OccupiedWayException.class)
    public void whenFigureGoThroughtOccupiedCell() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        board.addFigureToBoard(new Rook(new Cell(1, 1)));
        board.addFigureToBoard(new Rook(new Cell(1, 2)));
        Cell source = new Cell(1, 1);
        Cell destination = new Cell(1, 3);
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
        board.addFigureToBoard(new Rook(new Cell(1, 1)));
        Cell source = new Cell(1, 1);
        Cell destination = new Cell(1, 3);
        board.move(source, destination);
        Figure[] figures = board.getFigures();
        Cell result = figures[0].getPosition();
        assertThat(result, is(destination));
    }
}
