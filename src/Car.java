import se.mau.DA343A.VT25.assignment1.Direction;
import se.mau.DA343A.VT25.assignment1.IElementIcon;

import java.awt.image.BufferedImage;
import java.util.Random;

public class Car implements IElementIcon {
    private final int numberOfSquares = 1;
    private final int pollutionUnits = 5;
    private Direction direction;

    //TODO Hur implementerar jag
    public Direction[] moveElement(int d) {
        Direction[] compassDirections = Direction.values();
        Random random = new Random();
        Direction[] directionMoved = new Direction[d];

        for (int i = 0; i < d; i++) {
            int index = random.nextInt(compassDirections.length/4);
            directionMoved[i] = compassDirections[index];
        }

        return directionMoved;
    }

    @Override
    public BufferedImage getIcon() {
        return null;
    }

    @Override
    public int getRow() {
        return 0;
    }

    @Override
    public int getColumn() {
        return 0;
    }
}
