import java.awt.image.BufferedImage;
import se.mau.DA343A.VT25.assignment1.ImageResources;

public class Main {
    public static void main(String[] args) {
        ImageResources image = new ImageResources();
        MapGrid mapGrid = new MapGrid(new String[]{"bike, car"}, image.getMapImage(), 10, 10 );
        mapGrid.startGUIOnNewThread();
    }
}
