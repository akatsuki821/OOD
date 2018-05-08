package FactoryPattern.GUIfactory;

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        Application winApp = new Application(new WinFactory());
        winApp.run();
        Application macApp = new Application(new OSXFactory());
        macApp.run();
    }
}
