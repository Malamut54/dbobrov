package ru.job4j.chess;

/**
 * Task Chess.
 */
public class Cell {
    /**
     * Class Cell. Describes the coordinates of a cell.
     */

    /**
     * Private fields.
     */
    private int x;
    /**
     * Private fields.
     */
    private int y;

    /**
     * Constructor for cell.
     *
     * @param x axis X.
     * @param y axis Y.
     */
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Getter axis X.
     * @return int X.
     */
    public int getX() {
        return x;
    }

    /**
     * Getter axis Y.
     * @return int Y.
     */
    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Cell cell = (Cell) o;

        if (x != cell.x & y != cell.y) {
            return false;
        }
        return y == cell.y & x == cell.x;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
