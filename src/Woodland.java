import se.mau.DA343A.VT25.assignment1.IElementIcon;
import se.mau.DA343A.VT25.assignment1.ImageResources;

import java.awt.image.BufferedImage;

public class Woodland implements INonMovable {
    private  double minusPollutionUnits = 25.0;
    protected int row;
    protected int column;
    protected BufferedImage icon;
    private final boolean isLand = true;

    public Woodland(int row, int column, BufferedImage icon, boolean isLand, double minusPollutionUnits) {
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
    public boolean isMovable() {
        return false;
    }

    public boolean isLand() {
        return true;
    }

    public double getMinusPollutionUnits() {
        return minusPollutionUnits;
    }


}
