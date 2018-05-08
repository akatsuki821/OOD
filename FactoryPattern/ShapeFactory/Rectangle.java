package FactoryPattern.ShapeFactory;

public class Rectangle implements Shape {
    private final double width;
    private final double length;
    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    @Override
    public void draw() {
        System.out.format("Inside Rectangle:: draw() method with width: %f, length: %f\n", width, length);
    }
}
