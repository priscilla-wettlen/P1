import se.mau.DA343A.VT25.assignment1.IElementIcon;

public abstract class Element implements IElementIcon {
    private String name;

    public Element(String name) {
        this.name = name;
    }

    public abstract String getName();
}
