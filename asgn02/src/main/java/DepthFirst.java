import java.util.ArrayList;

/**
 * DepthFirst - A depth first search algorithm
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
public class DepthFirst {
    private char[][] maze;

    private Stack<Point> stack;
    public DepthFirst(char[][] maze) {
        this.maze = maze;
        stack = new Stack<>();
    }

    public Stack<Point> depthFirstSearch(int row, int column) {
        MapType current = MapType.fromChar(maze[row][column]);
        Point point;
        if (current == MapType.End) {
            point = new Point(row, column);
            stack.push(point);
            reverseStack();
        } else {
            if (current != MapType.Visited) {
                point = new Point(row, column);
                stack.push(point);
                maze[row][column] = MapType.Visited.toChar();
            }
            Point adjacency = getFirstAdjacency(row, column);
            if (adjacency != null) {
                depthFirstSearch(adjacency.getRow(),adjacency.getColumn());
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    depthFirstSearch(stack.top().getRow(), stack.top().getColumn());
                }
            }

        }

        return stack;
    }

    /**
     * Reverses the stack
     */
    private void reverseStack() {
        Stack<Point> result = new Stack<>();
        while (!stack.isEmpty()) {
            result.push(stack.pop());
        }

        stack = result;
    }

    private Point getFirstAdjacency(int row, int column) {

        // array of transformation
        int[][] movements = {
                {1,0}, {0,1}, {-1,0}, {0,-1}
        };
        Point point = null;
        for (int[] movement : movements) {
            int newRow = row + movement[0];
            int newColumn = column + movement[1];
            MapType adjacent = MapType.fromChar(maze[newRow][newColumn]);
            if (adjacent == MapType.Blank ||
                    adjacent == MapType.End) {
                point = new Point(newRow, newColumn);
                break;
            }
        }
        return point;
    }

}
