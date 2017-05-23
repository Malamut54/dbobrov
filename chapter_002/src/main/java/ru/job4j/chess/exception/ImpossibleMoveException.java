package ru.job4j.chess.exception;

/**
 * Task Chess.
 */
public class ImpossibleMoveException extends Exception {
    /**
     * Constructor for error message.
     *
     * @param msg error message.
     */
    public ImpossibleMoveException(String msg) {
        super(msg);
    }
}
