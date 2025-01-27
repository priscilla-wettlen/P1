import se.mau.DA343A.VT25.assignment1.IElementIcon;

public abstract class Element implements IElementIcon {
    private String name;
    private boolean isMovable;

    public Element(String name, boolean isMovable) {
        this.name = name;
        this.isMovable = false;
    }

    public abstract String getName();
    public abstract boolean isMovable();
}
