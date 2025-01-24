import java.awt.image.BufferedImage;
import se.mau.DA343A.VT25.assignment1.ImageResources;

public class Main {
    public static void main(String[] args) {
        ImageResources image = new ImageResources();
        MapGrid mapGrid = new MapGrid(new String[]{"Car", "Bike", "Bus", "Airplane", "Woodland"}, image.getMapImage());
        mapGrid.startGUIOnNewThread();
    }
}
