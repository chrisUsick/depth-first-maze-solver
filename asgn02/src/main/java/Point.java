/**
 * Point - Representation of a 2D point
 *
 * <pre>
 *
 * Assignment: #2
 * Course: ADEV-3001
 * Date Created: October 24, 2016
 *
 * Revision Log
 * Who          When    Reason
 * --------- ---------- ----------------------------------
 *
 * </pre>
 *
 * @author Chris Usick
 * @version 1.0
 *
 */
public class Point {
    private int row;
    private int column;

    /**
     * Constructs a new point, setting the row and column
     * @param currentRow        the current row
     * @param currentColumn     the current column
     */
    public Point(int currentRow, int currentColumn){
        row = currentRow;
        column = currentColumn;
    }

    /**
     * gets the row of this point
     * @return  the row
     */
    public int getRow() {
        return row;
    }

    /**
     * get the column of this point
     * @return  the column
     */
    public int getColumn() {
        return column;
    }

    @Override
    public String toString() {
        return String.format("[%d, %d]", row, column);
    }
}
