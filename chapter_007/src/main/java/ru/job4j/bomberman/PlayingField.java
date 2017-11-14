package ru.job4j.bomberman;

import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO: comment
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 14.11.2017
 */

public class PlayingField {
    private final ReentrantLock[][] board;

    public PlayingField(int x, int y) {
        board = new ReentrantLock[x][y];
    }

    public ReentrantLock[][] getBoard() {
        return board;
    }
}
