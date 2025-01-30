import se.mau.DA343A.VT25.assignment1.Direction;

import java.awt.image.BufferedImage;

public class Bus implements IMovable {
    private final int numberOfSquares = 3;
    private final double pollutionUnits = 3.0;
    protected final Direction direction = Direction.NORTH;
    protected int row;
    protected int column;
    protected BufferedImage icon;
    private final boolean isLand = true;

    public Bus(int row, int column, BufferedImage icon, boolean isLand, double pollutionUnits) {
        this.row = row;
        this.column = column;
        this.icon = icon;
    }

    @Override
    public void trackMovement() {
        row -= numberOfSquares;
        System.out.println("Bus moved to: (" + row + ", " + column + ") in direction North");

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

    public int getNumberOfSquares() {
        return numberOfSquares;
    }

    @Override
    public double getPollutionUnits() {
        return pollutionUnits;
    }


}


