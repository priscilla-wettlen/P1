import se.mau.DA343A.VT25.assignment1.Direction;
import se.mau.DA343A.VT25.assignment1.IElementIcon;
import se.mau.DA343A.VT25.assignment1.ImageResources;

import java.awt.image.BufferedImage;
import java.util.Random;

public class Bus extends Element {
    private final int numberOfSquares = 3;
    private final int pollutionUnits = 3;
    protected final Direction direction = Direction.NORTH;
    protected int row;
    protected int column;
    protected BufferedImage icon;
    protected ImageResources image;

    public Bus(String name, int row, int column, BufferedImage icon) {
        super(name);
        this.row = row;
        this.column = column;
        this.icon = icon;
    }

    public void trackMovement() {
        row -= numberOfSquares;
        System.out.println("Bus moved to: (" + row + ", " + column + ") in direction North");

    }

    public String getName() {
        return "Bus";
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
