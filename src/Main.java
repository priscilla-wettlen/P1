import java.awt.image.BufferedImage;

import se.mau.DA343A.VT25.assignment1.AirQualityApp;
import se.mau.DA343A.VT25.assignment1.ImageResources;

public class Main {
    public static void main(String[] args) {
        ImageResources image = new ImageResources();
        String[] elementOptions = new String[]{"Bike", "Car", "Bus", "Airplane", "Woodland"};
        MapGrid mapGrid = new MapGrid(elementOptions, image.getMapImage());
        mapGrid.startGUIOnNewThread();
    }
}
