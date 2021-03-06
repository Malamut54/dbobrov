package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.exception.FigureNotFoundException;
import ru.job4j.chess.exception.ImpossibleMoveException;
import ru.job4j.chess.exception.OccupiedWayException;
import ru.job4j.chess.figure.Figure;
import ru.job4j.chess.figure.Pawn;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Pawn.
 *
 * @author Dmitriy Bobrov (mailto:bobrov.dmitriy@gmail.com)
 * @version $id$
 * @since 0.1
 */
public class PawnTest {
    /**
     * Test when move takes place outside the board.
     *
     * @throws FigureNotFoundException Figure not found.
     * @throws OccupiedWayException    Figure on the way.
     * @throws ImpossibleMoveException Figure make imposible move.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenWentBeyondTheBoard() throws FigureNotFoundException, OccupiedWayException, ImpossibleMoveException {
        Figure figure = new Pawn(new Cell(1, 2));
        figure.way(new Cell(1, 10));
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
        Cell source = new Cell(1, 2);
        Cell destination = new Cell(1, 4);
        board.addFigureToBoard(new Pawn(new Cell(2, 2)));
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
        board.addFigureToBoard(new Pawn(new Cell(1, 2)));
        Cell source = new Cell(1, 2);
        Cell destination = new Cell(1, 5);
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
        board.addFigureToBoard(new Pawn(new Cell(1, 2)));
        board.addFigureToBoard(new Pawn(new Cell(1, 3)));
        Cell source = new Cell(1, 2);
        Cell destination = new Cell(1, 4);
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
        board.addFigureToBoard(new Pawn(new Cell(1, 4)));
        Cell source = new Cell(1, 4);
        Cell destination = new Cell(1, 5);
        board.move(source, destination);
        Figure[] figures = board.getFigures();
        Cell result = figures[0].getPosition();
        assertThat(result, is(destination));
    }
}
