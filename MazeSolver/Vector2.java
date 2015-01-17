/**
 * Defines a vector with two components whose origin is the upper left corner.
 *
 * @author Andrei Muntean
 */
public class Vector2
{
    // The X component of the vector.
    private final int x;

    // The Y component of the vector.
    private final int y;

    /**
     * Constructs a vector with two components.
     *
     * @param x The X component.
     * @param y The Y component.
     */
    public Vector2(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * Gets the X component of the vector.
     *
     * @return The X component of the vector.
     */
    public int getX()
    {
        return x;
    }

    /**
     * Gets the Y component of the vector.
     *
     * @return The Y component of the vector.
     */
    public int getY()
    {
        return y;
    }

    /**
     * Shifts the vector to the left.
     *
     * @return The left-shifted vector.
     */
    public Vector2 shiftLeft()
    {
        return new Vector2(x - 1, y);
    }

    /**
     * Shifts the vector up.
     *
     * @return The up-shifted vector.
     */
    public Vector2 shiftUp()
    {
        return new Vector2(x, y - 1);
    }

    /**
     * Shifts the vector to the right.
     *
     * @return The right-shifted vector.
     */
    public Vector2 shiftRight()
    {
        return new Vector2(x + 1, y);
    }

    /**
     * Shifts the vector down.
     *
     * @return The down-shifted vector.
     */
    public Vector2 shiftDown()
    {
        return new Vector2(x, y + 1);
    }

    @Override
    public boolean equals(Object object)
    {
        Vector2 vector = (Vector2)object;

        return x == vector.getX() && y == vector.getY();
    }

    @Override
    public String toString()
    {
        return "(" + x + ", " + y + ")";
    }
}