import se.mau.DA343A.VT25.assignment1.Direction;
import se.mau.DA343A.VT25.assignment1.IsLand;

import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * The type Car.
 * @author Priscilla Wettlén
 */
public class Car implements IMovable {
    private final int numberOfSquares = 1;
    private final double pollutionUnits = 50.0;
    protected Direction direction;
    protected int row;
    protected int column;
    protected BufferedImage icon;
    private final boolean isLand = true;
    protected IsLand isLandClass;

    /**
     * Instantiates a new Car.
     *
     * @param row            the x-coordinate
     * @param column         the y-coordinate
     * @param icon           the icon that represents it
     * @param isLand         Indicates the element can only move on land
     * @param pollutionUnits the pollution units it emits
     */
    public Car(int row, int column, BufferedImage icon, boolean isLand, double pollutionUnits) {
        this.row = row;
        this.column = column;
        this.icon = icon;
    }

    /**
     * Generates and tracks the movement of the car element on the map in a random direction

     */
    @Override
    public void trackMovement() {
        Random random = new Random();
        Direction[] directions = Direction.values();
        this.direction = directions[random.nextInt(directions.length)];

        switch (this.direction) {
            case NORTH:
                row -= numberOfSquares;
                break;
            case SOUTH:
                row += numberOfSquares;
                break;
            case EAST:
                column += numberOfSquares;
                break;
            case WEST:
                column -= numberOfSquares;
                break;
        }

        row = Math.max(0, row);
        column = Math.max(0, column);

        System.out.println("Car moved to: (" + row + ", " + column + ") in direction " + direction);

    }


    /**
     * Sets the row
     * @param row the x-axis
     */
    @Override
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * Sets the column
     * @param column the y-axis
     */
    @Override
    public void setColumn(int column) {
        this.column = column;
    }

    /**
     * Decides if the element can only move on land
     */
    @Override
    public boolean isLand() {
        return true;
    }

    /**
     * Loads the icon of the element
     */
    @Override
    public BufferedImage getIcon() {
        return icon;
    }

    /**
     * Gets the row
     */
    @Override
    public int getRow() {
        return row;
    }

    /**
     * Gets the column
     */

    @Override
    public int getColumn() {
        return column;
    }

    /**
     * Gets the number of squares on the grid where the car can move
     */

    public int getNumberOfSquares() {
        return numberOfSquares;
    }

    /**
     * Gets the pollution units the car produces
     */

    @Override
    public double getPollutionUnits() {
        return pollutionUnits;
    }



}
