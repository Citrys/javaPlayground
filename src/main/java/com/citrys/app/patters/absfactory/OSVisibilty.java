package com.citrys.app.patters.absfactory;


import com.citrys.app.utils.Printer;

interface Button {
    public void paint();
}

class MacButton implements Button {
    @Override
    public void paint() {
        Printer.print("This is MacOS Button");
    }
}

class WinButton implements Button {

    @Override
    public void paint() {
        Printer.print("This is WinOS Button");
    }
}

interface Checkbox {
    public void color();
}


class MacCheckbox implements Checkbox {
    @Override
    public void color() {
        Printer.print("This is MacOS Checkbox");
    }
}

class WinCheckbox implements Checkbox {

    @Override
    public void color() {
        Printer.print("This is WinOS Checkbox");
    }
}

interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

class MacOSFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}


class WinOSFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new WinButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WinCheckbox();
    }
}

class Application {
    private Button button;
    private Checkbox checkbox;

    Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.color();
    }
}

class Demo {

    /**
     * Application picks the factory type and creates it in run time (usually at
     * initialization stage), depending on the configuration or environment
     * variables.
     */
    private static Application configureApplication() {
        Application app;
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            factory = new MacOSFactory();
            app = new Application(factory);
        } else {
            factory = new WinOSFactory();
            app = new Application(factory);
        }
        return app;
    }

    public static void main(String[] args) {
        Application app = configureApplication();
        app.paint();
    }
}

