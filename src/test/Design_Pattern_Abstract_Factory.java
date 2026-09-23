package test;

/**
 *  buttons: First product hierarchy
 *  buttons/Button.java
 */

/**
 * Abstract Factory assumes that you have several families of products,
 * structured into separate class hierarchies (Button/Checkbox). All products of
 * the same family have the common interface.
 *
 * This is the common interface for buttons family.
 */
interface Button {
    void paint();
}

/**
 * buttons/MacOSButton.java
 */

/**
 * All products families have the same varieties (MacOS/Windows).
 *
 * This is a MacOS variant of a button.
 */
class MacOSButton implements Button {

    @Override
    public void paint() {
        System.out.println("You have created MacOSButton.");
    }
}

/**
 * buttons/WindowsButton.java
 */

/**
 * All products families have the same varieties (MacOS/Windows).
 *
 * This is another variant of a button.
 */
class WindowsButton implements Button {

    @Override
    public void paint() {
        System.out.println("You have created WindowsButton.");
    }
}

/**
 * checkboxes: Second product hierarchy
 * checkboxes/Checkbox.java
 */

/**
 * Checkboxes is the second product family. It has the same variants as buttons.
 */
interface Checkbox {
    void paint();
}

/**
 * checkboxes/MacOSCheckbox.java
 */

/**
 * All products families have the same varieties (MacOS/Windows).
 *
 * This is a variant of a checkbox.
 */
class MacOSCheckbox implements Checkbox {

    @Override
    public void paint() {
        System.out.println("You have created MacOSCheckbox.");
    }
}

/**
 * checkboxes/WindowsCheckbox.java
 */

/**
 * All products families have the same varieties (MacOS/Windows).
 *
 * This is another variant of a checkbox.
 */
class WindowsCheckbox implements Checkbox {

    @Override
    public void paint() {
        System.out.println("You have created WindowsCheckbox.");
    }
}

/**
 *  factories
 *  factories/GUIFactory.java: Abstract factory
 */

/**
 * Abstract factory knows about all (abstract) product types.
 */
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

/**
 * factories/MacOSFactory.java: Concrete factory (macOS)
 */

/**
 * Each concrete factory extends basic factory and responsible for creating
 * products of a single variety.
 */
class MacOSFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}

/**
 * factories/WindowsFactory.java: Concrete factory (Windows)
 */

/**
 * Each concrete factory extends basic factory and responsible for creating
 * products of a single variety.
 */
class WindowsFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

/**
 *  app
 *  app/Application.java: Client code
 */

/**
 * Factory users don't care which concrete factory they use since they work with
 * factories and products through abstract interfaces.
 */
class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }
}

/**
 * Demo.java: App configuration
 */

/**
 * Demo class. Everything comes together here.
 */

public class Design_Pattern_Abstract_Factory {

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
        } else {
            factory = new WindowsFactory();
        }
        app = new Application(factory);
        return app;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Application app = configureApplication();
        app.paint();
	}

}
