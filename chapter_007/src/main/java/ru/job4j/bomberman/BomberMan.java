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
    private final ReentrantLock[][] board;

    private int posX;
    private int posY;

    public Figure(ReentrantLock[][] playingField, int posX, int posY) throws Exception {
        this.board = playingField;
        try {
            this.posX = posX;
            this.posY = posY;
            board[posX][posY].tryLock();
        } catch (Exception e) {
            outerLoop: for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (!board[i][j].isLocked()) {
                        board[i][j].lock();
                        break outerLoop;
                    }
                }
            }
        }
    }

    public void moveUP() {

    }


}
