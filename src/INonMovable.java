import se.mau.DA343A.VT25.assignment1.IElementIcon;

public interface INonMovable extends IElementIcon {
    boolean isMovable();
    boolean isLand();
    double getPollutionUnits();
}
