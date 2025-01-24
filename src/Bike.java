import se.mau.DA343A.VT25.assignment1.Direction;
import se.mau.DA343A.VT25.assignment1.IElementIcon;
import se.mau.DA343A.VT25.assignment1.ImageResources;

import java.awt.image.BufferedImage;

public class Bike extends Element {
    private final int numberOfSquares = 1;
    private final int pollutionUnits = 0;
    protected Direction direction;
    protected int row;
    protected int column;
    protected BufferedImage icon;
    protected ImageResources image;

    public Bike(String name, int row, int column, BufferedImage icon) {
        super(name);
        this.row = row;
        this.column = column;
        this.icon = icon;
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
    public String getName() {
        return "Bike";
    }
}
