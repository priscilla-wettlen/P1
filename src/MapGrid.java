import org.w3c.dom.ls.LSOutput;
import se.mau.DA343A.VT25.assignment1.*;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MapGrid extends AirQualityApp{
    private IsLand isLand;
    private int rows;
    private int cols;
    private final ArrayList<IElementIcon> elements;
    private final ArrayList<IMovable> movableElements;
    private final ArrayList<INonMovable> nonMovableElements;
    private final String[] elementOptions;
    private ImageResources image = new ImageResources();
    protected Car car;
    protected Bike bike;
    protected Bus bus;
    protected Airplane airplane;
    protected Woodland woodland;
    private DiffusionGrid diffusionGrid;


    public MapGrid(String[] elementSelectorTypeNames, BufferedImage mapImage) {
        super(elementSelectorTypeNames, mapImage);
        elements = new ArrayList<>();
        movableElements = new ArrayList<>();
        nonMovableElements = new ArrayList<>();
        this.elementOptions = elementSelectorTypeNames;
        image = new ImageResources();
        car = new Car(rows, cols, image.getCarImage(),true, 5.0);
        bike = new Bike(rows, cols, image.getBikeImage(), true);
        bus = new Bus(rows, cols, image.getBusImage(),true, 3.0);
        airplane = new Airplane(rows, cols, image.getAirPlaneImage(), 10.0);
        woodland = new Woodland(rows, cols, image.getTreesImage(), true, 5.0);
        isLand = new IsLand();
        diffusionGrid = new DiffusionGrid();

    }

    public String[] elementSelectorTypeNames(){
        return elementOptions;
    }

    @Override
    protected void mouseClicked(int i, int i1) {
        System.out.println("Mouse clicked at (" + i + ", " + i1 + ")" );
        if (super.getSelectedElementType().equals("Car")) {
            car = new Car(i, i1, image.getCarImage(), true, 5.0);
            elements.add(car);
            movableElements.add(car);
        } else if (super.getSelectedElementType().equals("Bike")) {
            bike = new Bike(i, i1, image.getBikeImage(), true);
            elements.add(bike);
            movableElements.add(bike);
        } else if (super.getSelectedElementType().equals("Bus")) {
            bus = new Bus(i, i1, image.getBusImage(), true, 3.0);
            elements.add(bus);
            movableElements.add(bus);
        } else if (super.getSelectedElementType().equals("Airplane")) {
            airplane = new Airplane(i, i1, image.getAirPlaneImage(), 10.0);
            elements.add(airplane);
            movableElements.add(airplane);
        } else if (super.getSelectedElementType().equals("Woodland")) {
            woodland = new Woodland(i, i1, image.getTreesImage(), true, 5.0);
            elements.add(woodland);
            nonMovableElements.add(woodland);
        }
            repaint();
    }




    private void removeElementIcon(IMovable movable) {
        Iterator<IElementIcon> iconIterator = elements.iterator();

        while (iconIterator.hasNext()) {
            IElementIcon icon = iconIterator.next();

            if (icon.getRow() == movable.getRow() && icon.getColumn() == movable.getColumn()) {
                iconIterator.remove();
                break;
            }
        }
    }


    @Override
    protected void buttonNextTimeStepClicked() {
        //An iterator is like a replacement for a for-loop when one needs to change the
        //size of the list one is working with (which is not possible with a regular for-loop
        //because it will throw a concurrency modification exception)

        Iterator<IMovable> iterator = movableElements.iterator();
        IsLand isLand = new IsLand();


        while (iterator.hasNext()) {
            IMovable movable = iterator.next();
            int nextRow = movable.getRow();
            int nextCol = movable.getColumn();

            try {
                movable.trackMovement();

                if (movable.isLand() && !isLand.isLand(nextRow, nextCol)) {
                    System.out.println("Error: Element moved into water.");
                    movable.setRow(nextRow - movable.getNumberOfSquares());
                    movable.setColumn(nextCol + movable.getNumberOfSquares());
                    System.out.println("Reverted to: Row = " + (nextRow - movable.getNumberOfSquares()) + ", Column = " + (nextCol + movable.getNumberOfSquares()));
                }

                if (movable.getRow() < 0 || movable.getColumn() < 0 ||
                        movable.getRow() >= GRID_SIZE - 1 || movable.getColumn() >= GRID_SIZE - 1) {

                    throw new MovedOutOfGridException("The object has moved out of the grid bounds.");
                }


            } catch (MovedOutOfGridException e) {
                iterator.remove();
                removeElementIcon(movable);
                System.err.println(e.getMessage());
            }
        }

        createPollution();
        repelPollution();

        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                setPollution(i, j, diffusionGrid.getPollution(i, j));
            }
        }

        repaint();
    }

    public void createPollution() {
        for (IMovable movable : movableElements) {
            diffusionGrid.addPollutionToCell(movable.getRow(), movable.getColumn(), movable.getPollutionUnits());
            diffusionGrid.createDiffusion();
        }


    }

    public void repelPollution() {
        for (INonMovable nonMovable : nonMovableElements) {
            diffusionGrid.diminishPollutionInCell(nonMovable.getRow(), nonMovable.getColumn(), nonMovable.getMinusPollutionUnits());
            diffusionGrid.createDiffusion();
        }
    }

    @Override
    protected List<IElementIcon> elementIconsToPaint() {
        //System.out.println(elements.toString());
        return new ArrayList<>(elements);
    }

}
