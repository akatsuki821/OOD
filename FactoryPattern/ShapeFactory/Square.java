package FactoryPattern.ShapeFactory;

public class Square implements Shape {
    private final double length;
    public Square(double length) {
        this.length = length;
    }

    @Override
    public void draw() {
        System.out.format("Inside Square:: draw() method with length: %f\n", length);
    }
}
