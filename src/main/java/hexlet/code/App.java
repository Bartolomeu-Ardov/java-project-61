package hexlet.code;
/**
 * Main application class.
 * This class serves as the entry point for the application.
 */
public final class App {
    /**
     * Private constructor to prevent instantiation.
     * This is a utility class with only static methods.
     */
    private App() {
        // Utility class constructor
    }

    /**
     * Main method - the entry point of the application.
     * Starts the program execution by greeting the user.
     *
     * @param args command line arguments passed to the application
     */
    public static void main(final String[] args) {
        Cli.greetUser();
    }
}

