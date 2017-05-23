package ru.job4j.chess.exception;

/**
 * Task Chess.
 */
public class FigureNotFoundException extends Exception {
    /**
     * Constructor for error message.
     *
     * @param msg error message.
     */
    public FigureNotFoundException(String msg) {
        super(msg);
    }
}
