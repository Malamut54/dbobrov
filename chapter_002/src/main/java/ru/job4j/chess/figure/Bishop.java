package ru.job4j.chess.figure;

import ru.job4j.chess.Cell;
import ru.job4j.chess.exception.ImpossibleMoveException;

import java.util.Arrays;



public class Bishop extends Figure {
    private Cell position;

    public Bishop(Cell position) {
        super(position);
        this.position = position;
    }
    public Figure clone(Cell dist) {
        return new Bishop(dist);
    }
}
