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
    private final String[] elementOptions;
    private ImageResources image = new ImageResources();
    protected Car car;
    protected Bike bike;



    public MapGrid(String[] elementSelectorTypeNames, BufferedImage mapImage) {
        super(elementSelectorTypeNames, mapImage);
        grid = new int[rows][cols];
        elements = new ArrayList<>();
        this.elementOptions = elementSelectorTypeNames;
        image = new ImageResources();
        car = new Car("Car", rows, cols, image.getCarImage());
        bike = new Bike("Bike", rows, cols, image.getBikeImage());

    }

    public String[] elementSelectorTypeNames(){
        return elementOptions;
    }

    @Override
    protected void mouseClicked(int i, int i1) {
        System.out.println("Mouse clicked: " + i + ", " + i1);
//        for(int j = 0; j < elementOptions.length; j++){
//            if(elementOptions[j].equals("Car")){
//                Car car = new Car("Car", i, i1, image.getCarImage());
//                System.out.println("this is a car");
//                elements.add(car);
//            }else if(elementOptions[j].equals("Bike")){
//                Bike bike = new Bike("Bike", i, i1, image.getBikeImage());
//                System.out.println("this is a bike");
//                elements.add(bike);
//            }
//
//        }
        if(super.getSelectedElementType().equals("Car")){
            Car car = new Car("Car", i, i1, image.getCarImage());
                System.out.println("this is a car");
                elements.add(car);
        }else if(super.getSelectedElementType().equals("Bike")){
            Bike bike = new Bike("Bike", i, i1, image.getBikeImage());
                System.out.println("this is a bike");
                elements.add(bike);
        }

        repaint();

        //TODO It can only handle one type of image at a time

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
