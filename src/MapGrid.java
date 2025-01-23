import se.mau.DA343A.VT25.assignment1.AirQualityApp;
import se.mau.DA343A.VT25.assignment1.ImageResources;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class MapGrid extends AirQualityApp {
    private final int [][] grid;
    private final int rows = 10;
    private final int cols = 10;
    ImageResources images;
    private Car car;



    public MapGrid(String[] elementSelectorTypeNames, BufferedImage mapImage) {
        super(elementSelectorTypeNames, mapImage);
        grid = new int[rows][cols];

    }

    @Override
    protected void mouseClicked(int i, int i1) {
        System.out.println("Mouse clicked: " + i + ", " + i1);
        Car car = new Car(i, i1);



    }

    @Override
    protected void buttonNextTimeStepClicked() {

    }

    @Override
    protected List elementIconsToPaint() {
        return List.of();
    }

}
