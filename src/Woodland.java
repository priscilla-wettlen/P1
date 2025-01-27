import se.mau.DA343A.VT25.assignment1.IElementIcon;
import se.mau.DA343A.VT25.assignment1.ImageResources;

import java.awt.image.BufferedImage;

public class Woodland implements IElementIcon {
    private final int pollutionUnits = 10;
    protected int row;
    protected int column;
    protected BufferedImage icon;

    public Woodland(int row, int column, BufferedImage icon) {
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
}
