package FactoryPattern.GUIfactory;

public class WinFactory implements GUIFactory {
    public Button createButton() {
        return new WindowsButton("Windows 7");
    }
}
