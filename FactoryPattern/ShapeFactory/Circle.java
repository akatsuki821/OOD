package FactoryPattern.ShapeFactory;

public class Circle implements Shape {
    private final double radius;
    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.format("Inside Circle:: draw() method with radius: %f\n", radius);
    }
}
