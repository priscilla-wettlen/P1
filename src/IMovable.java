import se.mau.DA343A.VT25.assignment1.IElementIcon;
import se.mau.DA343A.VT25.assignment1.MovedOutOfGridException;

public interface IMovable extends IElementIcon {
    void trackMovement() throws MovedOutOfGridException;
    void setRow(int row);
    void setColumn(int column);
    boolean isLand();
    int getNumberOfSquares();
    double getPollutionUnits();

}
