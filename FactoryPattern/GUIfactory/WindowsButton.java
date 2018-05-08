package FactoryPattern.GUIfactory;

public class WindowsButton extends Button{
    public WindowsButton(String os) {
        super(os);
    }
    @Override
    public void action() {
        System.out.format("Pressed %s Button\n", this.operatingSystem);
    }
}
