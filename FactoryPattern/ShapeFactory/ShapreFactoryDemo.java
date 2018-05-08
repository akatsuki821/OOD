package FactoryPattern.ShapeFactory;

public class ShapreFactoryDemo {
    private  static final ShapeFactory shapeFactory = new ShapeFactory();

    public static void demo() {
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();
        Shape shape2 = shapeFactory.getShape("SQUARE");
        shape2.draw();
        Shape shape3 = shapeFactory.getShape("RECTANGLE");
        shape3.draw();
    }

    public static void main(String[] args) {
        demo();
    }
}
