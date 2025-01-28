import se.mau.DA343A.VT25.assignment1.IElementIcon;
import se.mau.DA343A.VT25.assignment1.MovedOutOfGridException;

public interface IMovable extends IElementIcon {
    void trackMovement() throws MovedOutOfGridException;
//    void setRow(Object o);
//    void setColumn(Object o);
    void setMovable(Object o);

}
