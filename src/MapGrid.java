import se.mau.DA343A.VT25.assignment1.AirQualityApp;

import java.awt.image.BufferedImage;
import java.util.List;

public class MapGrid extends AirQualityApp {
    private final int [][] grid;
    private int rows;
    private int cols;




    public MapGrid(String[] elementSelectorTypeNames, BufferedImage mapImage, int rows, int cols) {
        super(elementSelectorTypeNames, mapImage);
        this.rows = rows;
        this.cols = cols;
        grid = new int[rows][cols];

    }

    @Override
    protected void mouseClicked(int i, int i1) {
        System.out.println("Mouse clicked: " + i + ", " + i1);

    }

    @Override
    protected void buttonNextTimeStepClicked() {

    }

    @Override
    protected List elementIconsToPaint() {
        return List.of();
    }

}
