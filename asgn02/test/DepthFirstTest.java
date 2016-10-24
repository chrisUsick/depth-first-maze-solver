import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * DepthFirstTest - Test class for the DepthFirst Class
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
public class DepthFirstTest {

    /**
     * tests depthFirstSearch with start equal to end
     */
    @Test
    public void depthFirstSearchStartIsEnd() {
        char[] row1 = {MapType.End.toChar()};
        char[][] maze = {row1};
        DepthFirst search = new DepthFirst(maze);
        Stack<Point> result = search.depthFirstSearch(0,0);
        assertEquals(result.size(), 1);
        assertEquals(result.top().getRow(), 0);
        assertEquals(result.top().getColumn(), 0);
    }

    /**
     * tests depthFirstSearch with a straight line
     */
    @Test
    public void depthFirstSearchSimpleVerticalMaze() {
        char blank = MapType.Blank.toChar();
        char[][] maze = {
                {blank},
                {blank},
                {blank},
                {MapType.End.toChar()}
        };
        DepthFirst search = new DepthFirst(maze);
        Stack<Point> result = search.depthFirstSearch(0, 0);
        assertEquals(result.size(), 4);
        int i = 0;
        while (!result.isEmpty()) {
            i++ ;
            assertEquals(result.pop().getRow(), i);
        }
    }


    /**
     * tests depthFirstSearch with no end
     */
    @Test
    public void depthFirstSearchNoEnd() {
        char blank = MapType.Blank.toChar();
        char[][] maze = {
                {blank},
                {blank},
                {blank}
        };
        DepthFirst search = new DepthFirst(bufferMaze(maze));
        Stack<Point> result = search.depthFirstSearch(1, 1);
        assertEquals(result.size(), 0);
    }

    /**
     * Helper method to buffer a maze with 'W' elements
     * @param maze  A maze to buffer
     * @return      A new maze, with a wall buffer
     */
    public char[][] bufferMaze(char[][] maze) {
        char[][] newMaze = new char[maze.length + 2][];
        newMaze[0] = new char[maze[0].length + 2];
        Arrays.fill(newMaze[0], MapType.Wall.toChar());
        for (int i = 0; i < maze.length; i++) {
            char[] newRow = new char[maze[i].length + 2];
            newRow[0] = MapType.Wall.toChar();
            System.arraycopy(maze[i], 0, newRow, 1, maze[i].length);
            newRow[newRow.length - 1] = MapType.Wall.toChar();
            newMaze[i + 1] = newRow;
        }
        newMaze[newMaze.length - 1] = new char[maze[0].length + 2];
        Arrays.fill(newMaze[newMaze.length - 1], MapType.Wall.toChar());

        return newMaze;
    }
}

