package FactoryPattern.GUIfactory;

public class MacButton extends Button {
    public MacButton(String os) {
        super(os);
    }

    @Override
    public void action() {
        System.out.format("Pressed %s Button\n", this.operatingSystem);
    }
}
