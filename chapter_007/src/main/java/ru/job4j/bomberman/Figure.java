package ru.job4j.bomberman;

import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO: comment
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 14.11.2017
 */

public class Figure {
    private PlayingField playingField;
    private final ReentrantLock[][] board = playingField.getBoard();

    private int posX;
    private int posY;

    public Figure(PlayingField playingField, int posX, int posY) throws Exception {
        if (posX < board.length && posY < board[0].length) {
            this.posX = posX;
            this.posY = posY;
            board[posX][posY] = new ReentrantLock();
            board[posX][posY].lock();
        } else {
            throw new Exception("Exceeding the allowable limit");
        }
        this.playingField = playingField;
    }

    public void moveUP() {

        if (posX++ < board.length && posY < board[0].length) {
            new Cell(posX, posY);
        }

    }


}
