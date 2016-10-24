import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Application - the main application for the assignment
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
public class Application {

    /**
     * Runs the maze finder UI, solves the maze and prints the output
     * @param args  command line arguments
     */
    public static void main(String[] args) {
        String filename = P4Utils.choose();

        if (filename != null) {
            System.out.println("Filename: "  + filename);
            Stack<Point> solution = solveMaze(filename);
            System.out.println("Solution: " + solution.size());
            while (!solution.isEmpty()) {
                System.out.println(solution.pop().toString());
            }
        } else {
            // user clicked cancel or dismissed the dialog
            System.out.println("no Filename");
        }
    }

    /**
     * Loads a maze from a filepath, and solves it
     * @param filename  path to the maze file
     * @return          stack of the coordinates from start to finish
     */
    private static Stack<Point> solveMaze(String filename) {
        try {
            Path file = Paths.get(filename);
            ArrayList<String> content = new ArrayList(Files.readAllLines(file));
            String sizeString = content.remove(0);
            String startingString = content.remove(0);
            int[] starting = parseIntArray(startingString);
            return new DepthFirst(generateArray(sizeString, content)).depthFirstSearch(starting[0], starting[1]);
        } catch (IOException e ) {
            System.out.println("Error loading map");
            return null;
        }
    }

    /**
     * Create char[][] to represent the maze
     * @param sizeString    the string value of the dimensions of the maze
     * @param rows          list of rows of the maze
     * @return              2d array representing the maze
     */
    private static char[][] generateArray(String sizeString, ArrayList<String> rows) {
        try {
            int[] size = parseIntArray(sizeString);
            char[][] maze = new char[size[0]][size[1]];
            for (int i = 0; i < rows.size(); i++) {
                String row = rows.get(i);
                maze[i] = row.toCharArray();
            }

            return maze;
        } catch (Exception e) {
            System.out.println("Error parsing app");
            return null;
        }
    }

    /**
     * Transform space separated string into an array of int values
     * @param stringValue   space separated string
     * @return              parsed integers array
     */
    private static int[] parseIntArray(String stringValue) {
        String[] values = stringValue.split(" ");
        int[] result = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            String value = values[i];
            result[i] = Integer.parseInt(value);
        }
        return result;
    }
}
