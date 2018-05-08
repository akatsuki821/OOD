package FactoryPattern.GUIfactory;

public abstract class Button {
    final String operatingSystem;
    public Button(String os) {
        this.operatingSystem = os;
    }
    abstract void action();
}
