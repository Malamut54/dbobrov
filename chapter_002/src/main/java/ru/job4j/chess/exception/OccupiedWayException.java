package ru.job4j.chess.exception;

/**
 * Task Chess.
 */
public class OccupiedWayException extends Exception {
    /**
     * Constructor for error message.
     *
     * @param msg error message.
     */
    public OccupiedWayException(String msg) {
        super(msg);
    }
}
