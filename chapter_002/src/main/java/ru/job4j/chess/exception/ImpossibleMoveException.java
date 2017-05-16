package ru.job4j.chess.exception;

/**
 * Created by kvazimoda on 12.05.2017.
 */
public class ImpossibleMoveException extends Exception {
    public ImpossibleMoveException(String msg) {
        super(msg);
    }
}
