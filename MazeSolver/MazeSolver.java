import java.util.ArrayList;

/**
 * Solves a maze, where:
 * 0 - Cannot walk. 
 * 1 - Can walk. 
 * 2 - Start. 
 * 3 - Exit. 
 *
 * @author Andrei Muntean
 */
public class MazeSolver
{
    private static ArrayList<Vector2> path;
    private static Maze maze;

    // Outputs a solution.
    private static void showSolution()
    {
        // Outputs a new line.
        System.out.println();

        for (int rowIndex = 0; rowIndex < maze.getHeight(); ++rowIndex)
        {
            for (int columnIndex = 0; columnIndex < maze.getWidth(); ++columnIndex)
            {
                // The current position.
                Vector2 position = new Vector2(columnIndex, rowIndex);

                // Determines whether the path contains this position.
                if (path.contains(position))
                {
                    System.out.print("X ");
                }
                else
                {
                    System.out.print(maze.getValue(position) + " ");
                }
            }

            // Outputs a new line.
            System.out.println();
        }
    }

    // Goes to the specified position then to all its neighbors.
    private static void go(Vector2 position)
    {
        // Stores the current position.
        path.add(position);

        // Determines whether this is the exit.
        if (maze.getValue(position) == 3)
        {
            // Outputs this solution.
            showSolution();
        }
        else
        {
            Vector2 left = position.shiftLeft();
            Vector2 up = position.shiftUp();
            Vector2 right = position.shiftRight();
            Vector2 down = position.shiftDown();

            // Determines whether this position is inside the grid and was not visited before.
            if (left.getX() >= 0 && !path.contains(left))
            {
                // Determines whether the left neighbor can be crossed.
                if (maze.getValue(left) != 0)
                {
                    // Goes to the left neighbor.
                    go(left);
                }
            }

            // Determines whether this position is inside the grid and was not visited before.
            if (up.getY() >= 0 && !path.contains(up))
            {
                // Determines whether the top neighbor can be crossed.
                if (maze.getValue(up) != 0)
                {
                    // Goes to the top neighbor.
                    go(up);
                }
            }

            // Determines whether this position is inside the grid and was not visited before.
            if (right.getX() < maze.getWidth() && !path.contains(right))
            {
                // Determines whether the right neighbor can be crossed.
                if (maze.getValue(right) != 0)
                {
                    // Goes to the right neighbor.
                    go(right);
                }
            }

            // Determines whether this position is inside the grid and was not visited before.
            if (down.getY() < maze.getHeight() && !path.contains(down))
            {
                // Determines whether the bottom neighbor can be crossed.
                if (maze.getValue(down) != 0)
                {
                    // Goes to the bottom neighbor.
                    go(down);
                }
            }
        }

        // Backtracks.
        path.remove(position);
    }

    public static void main(String[] args)
    {
        try
        {
            // Reads the maze.
            maze = new Maze(args.length > 0 ? args[0] : "maze.txt");

            // Initializes the path.
            path = new ArrayList<Vector2>();

            // Gets the start position.
            Vector2 startPosition = maze.getPositionsOf(2).get(0);

            // Solves the maze.
            go(startPosition);
        }
        catch (Exception exception)
        {
            System.err.println(exception.getMessage());
        }
    }
}