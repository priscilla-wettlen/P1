import se.mau.DA343A.VT25.assignment1.Direction;
import se.mau.DA343A.VT25.assignment1.IsLand;

import java.awt.image.BufferedImage;
import java.util.Random;

public class Car implements IMovable {
    private final int numberOfSquares = 1;
    private final int pollutionUnits = 5;
    protected Direction direction;
    protected int row;
    protected int column;
    protected BufferedImage icon;
    private final boolean isLand = true;
    protected IsLand isLandClass;

    public Car(int row, int column, BufferedImage icon, boolean isLand) {
        this.row = row;
        this.column = column;
        this.icon = icon;
    }

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

    @Override
    public void setMovable(Object o) {

    }

    @Override
    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public boolean isLand() {
        return true;
    }

    @Override
    public BufferedImage getIcon() {
        return icon;
    }

    @Override
    public int getRow() {
        return row;
    }

    @Override
    public int getColumn() {
        return column;
    }

    public int getNumberOfSquares() {
        return numberOfSquares;
    }



}
