import org.w3c.dom.ls.LSOutput;
import se.mau.DA343A.VT25.assignment1.AirQualityApp;
import se.mau.DA343A.VT25.assignment1.IElementIcon;
import se.mau.DA343A.VT25.assignment1.ImageResources;
import se.mau.DA343A.VT25.assignment1.MovedOutOfGridException;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class MapGrid extends AirQualityApp {
    private final int [][] grid;
    private int rows;
    private int cols;
    private ArrayList<IElementIcon> elements;
    private ArrayList<IMovable> movableElements;
    private final String[] elementOptions;
    private ImageResources image = new ImageResources();
    protected Car car;
    protected Bike bike;
    protected Bus bus;
    protected Airplane airplane;
    protected Woodland woodland;



    public MapGrid(String[] elementSelectorTypeNames, BufferedImage mapImage) {
        super(elementSelectorTypeNames, mapImage);
        grid = new int[rows][cols];
        elements = new ArrayList<>();
        movableElements = new ArrayList<>();
        this.elementOptions = elementSelectorTypeNames;
        image = new ImageResources();
        car = new Car(rows, cols, image.getCarImage());
        bike = new Bike(rows, cols, image.getBikeImage());
        airplane = new Airplane(rows, cols, image.getAirPlaneImage());
        woodland = new Woodland(rows, cols, image.getTreesImage());

    }

    public String[] elementSelectorTypeNames(){
        return elementOptions;
    }

    @Override
    protected void mouseClicked(int i, int i1) {
        if (super.getSelectedElementType().equals("Car")) {
            car = new Car(i, i1, image.getCarImage());
            elements.add(car);
            movableElements.add(car);
        } else if (super.getSelectedElementType().equals("Bike")) {
            bike = new Bike(i, i1, image.getBikeImage());
            elements.add(bike);
            movableElements.add(bike);
        } else if (super.getSelectedElementType().equals("Bus")) {
            bus = new Bus(i, i1, image.getBusImage());
            elements.add(bus);
            movableElements.add(bus);
        } else if (super.getSelectedElementType().equals("Airplane")) {
            airplane = new Airplane(i, i1, image.getAirPlaneImage());
            elements.add(airplane);
            movableElements.add(airplane);
        } else if (super.getSelectedElementType().equals("Woodland")) {
            woodland = new Woodland(i, i1, image.getTreesImage());
            elements.add(woodland);
        }
            repaint();
    }

    @Override
    protected void buttonNextTimeStepClicked() {
        for (IMovable movable : movableElements) {
            try {
                movable.trackMovement();
                if (movable.getRow() < 0 || movable.getColumn() < 0 ||
                        movable.getRow() >= GRID_SIZE - 1 || movable.getColumn() >= GRID_SIZE - 1) {

                    throw new MovedOutOfGridException("The object has moved out of the grid bounds.");
                }
            } catch (MovedOutOfGridException e) {
                System.err.println(e.getMessage());
            }
        }
        repaint();
    }


    @Override
    protected List<IElementIcon> elementIconsToPaint() {
        //System.out.println(elements.toString());
        return new ArrayList<>(elements);
    }


}
