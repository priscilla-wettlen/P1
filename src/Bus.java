import se.mau.DA343A.VT25.assignment1.Direction;
import se.mau.DA343A.VT25.assignment1.IElementIcon;
import se.mau.DA343A.VT25.assignment1.ImageResources;

import java.awt.image.BufferedImage;
import java.util.Random;

public class Bus implements IMovable {
    private final int numberOfSquares = 3;
    private final int pollutionUnits = 3;
    protected final Direction direction = Direction.NORTH;
    protected int row;
    protected int column;
    protected BufferedImage icon;
    protected ImageResources image;

    public Bus(int row, int column, BufferedImage icon) {
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
}
