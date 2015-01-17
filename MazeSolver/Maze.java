import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a maze.
 *
 * @author Andrei Muntean
 */
public class Maze
{
    private final int[][] grid;

    /**
     * Constructs a maze from a specified path.
     *
     * @param path A file path.
     */
    public Maze(String path) throws Exception, FileNotFoundException
    {
        // Initializes the file scanner.
        Scanner scanner = new Scanner(new File(path));

        try
        {
            // Reads the height of the maze.
            int height = scanner.nextInt();

            // Reads the width of the maze.
            int width = scanner.nextInt();

            // Initializes the grid.
            grid = new int[height][width];

            // Reads the grid.
            for (int rowIndex = 0; rowIndex < height; ++rowIndex)
            {
                for (int columnIndex = 0; columnIndex < width; ++columnIndex)
                {
                    grid[rowIndex][columnIndex] = scanner.nextInt();
                }
            }
        }
        catch (Exception exception)
        {
            throw new Exception("\"" + path + "\" is not a maze file.");
        }
    }

    /**
     * Gets the height of the maze.
     *
     * @return The height of the maze.
     */
    public int getHeight()
    {
        return grid.length;
    }

    /**
     * Gets the width of the maze.
     *
     * @return The width of the maze.
     */
    public int getWidth()
    {
        return grid.length > 0 ? grid[0].length : 0;
    }

    /**
     * Gets the value at the specified position.
     *
     * @param position A position.
     *
     * @return The value at the specified position.
     */
    public int getValue(Vector2 position)
    {
        return grid[position.getY()][position.getX()];
    }

    /**
     * Gets every position of the specified value.
     *
     * @param value A value.
     *
     * @return A list that contains every position of the specified value.
     */
    public ArrayList<Vector2> getPositionsOf(int value)
    {
        // Initializes the list of positions.
        ArrayList<Vector2> positions = new ArrayList<Vector2>();

        // Goes through every element of the grid.
        for (int rowIndex = 0; rowIndex < grid.length; ++rowIndex)
        {
            for (int columnIndex = 0; columnIndex < grid[rowIndex].length; ++columnIndex)
            {
                // Determines whether the current element is equal to the value.
                if (grid[rowIndex][columnIndex] == value)
                {
                    // Stores the position of the current element.
                    positions.add(new Vector2(columnIndex, rowIndex));
                }
            }
        }

        // Returns the list of positions.
        return positions;
    }

    @Override
    public String toString()
    {
        String mazeString = "";

        for (int[] row : grid)
        {
            for (int element : row)
            {
                mazeString += element + " ";
            }

            mazeString += System.getProperty("line.separator");
        }

        return mazeString;
    }
}