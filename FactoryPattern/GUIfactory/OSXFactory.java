package FactoryPattern.GUIfactory;

public class OSXFactory implements GUIFactory {
    public Button createButton() {
        return new MacButton("Mac");
    }
}
