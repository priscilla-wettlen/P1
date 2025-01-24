import se.mau.DA343A.VT25.assignment1.AirQualityApp;
import se.mau.DA343A.VT25.assignment1.ImageResources;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class MapGrid extends AirQualityApp {
    private final int [][] grid;
    private final int rows = 10;
    private final int cols = 10;
    private ArrayList<Element> elements;
    private ImageResources image = new ImageResources();



    public MapGrid(String[] elementSelectorTypeNames, BufferedImage mapImage) {
        super(elementSelectorTypeNames, mapImage);
        grid = new int[rows][cols];
        elements = new ArrayList<>();
        image = new ImageResources();

    }

    public String[] elementSelectorTypeNames(){
        return new String[]{"Car", "Bike","Bus", "Airplane","Woodland"};
    }

    @Override
    protected void mouseClicked(int i, int i1) {
        System.out.println("Mouse clicked: " + i + ", " + i1);
        Car car = new Car("Car", i, i1, image.getCarImage());
        elements.add(car);
        repaint();

    }

    @Override
    protected void buttonNextTimeStepClicked() {

    }

    @Override
    protected List<Element> elementIconsToPaint() {
        //System.out.println(elements.toString());
        return new ArrayList<>(elements);
    }

}
