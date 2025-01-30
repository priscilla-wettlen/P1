import org.w3c.dom.ls.LSOutput;
import se.mau.DA343A.VT25.assignment1.*;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MapGrid extends AirQualityApp{
    protected double[][] diffusionGrid = new double[GRID_SIZE][GRID_SIZE];
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
        woodland = new Woodland(rows, cols, image.getTreesImage(), true, -5.0);
        isLand = new IsLand();

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
            setPollution(i, i1, 5.0);
        } else if (super.getSelectedElementType().equals("Bike")) {
            bike = new Bike(i, i1, image.getBikeImage(), true);
            elements.add(bike);
            movableElements.add(bike);
            setPollution(i, i1, 0.0);
        } else if (super.getSelectedElementType().equals("Bus")) {
            bus = new Bus(i, i1, image.getBusImage(), true, 3.0);
            elements.add(bus);
            movableElements.add(bus);
            setPollution(i, i1, 3.0);
        } else if (super.getSelectedElementType().equals("Airplane")) {
            airplane = new Airplane(i, i1, image.getAirPlaneImage(), 10.0);
            elements.add(airplane);
            movableElements.add(airplane);
            setPollution(i, i1, 10.0);
        } else if (super.getSelectedElementType().equals("Woodland")) {
            woodland = new Woodland(i, i1, image.getTreesImage(), true,-5.0);
            elements.add(woodland);
            nonMovableElements.add(woodland);
            setPollution(i, i1, -5.0);
        }
            repaint();
    }


//    public void diffusePollution() {
//        double[][] newDiffusionGrid = new double[GRID_SIZE][GRID_SIZE];
//
//        for (int row = 0; row < GRID_SIZE; row++) {
//            for (int col = 0; col < GRID_SIZE; col++) {
//                double initialGrid = diffusionGrid[row][col];
//                double top = 0.0, bottom = 0.0, left = 0.0, right = 0.0;
//
//
//                //This if-statement is needed to check for the borders
//                if (row > 0) {
//                    top = diffusionGrid[row - 1][col];
//                }
//                if (row < GRID_SIZE - 1) {
//                    bottom = diffusionGrid[row + 1][col];
//                }
//                if (col > 0) {
//                    left = diffusionGrid[row][col - 1];
//                }
//                if (col < GRID_SIZE - 1) {
//                    right = diffusionGrid[row][col + 1];
//                }
//
//                newDiffusionGrid[row][col] = (initialGrid + top + bottom + left + right) / 5.0;
//            }
//        }
//        diffusionGrid = newDiffusionGrid;
//
//        for (int i = 0; i < GRID_SIZE; i++) {
//            for (int j = 0; j < GRID_SIZE; j++) {
//                System.out.print(diffusionGrid[i][j] + "\t");
//            }
//            System.out.println();
//        }
//
//    }

    public void diffusePollution() {
        double[][] newDiffusionGrid = new double[GRID_SIZE][GRID_SIZE];

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
                setPollution(movable.getRow(), movable.getColumn(), movable.getPollutionUnits());
                System.out.println(movable.getPollutionUnits());



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

        repaint();
    }





    @Override
    protected List<IElementIcon> elementIconsToPaint() {
        //System.out.println(elements.toString());
        return new ArrayList<>(elements);
    }

}
