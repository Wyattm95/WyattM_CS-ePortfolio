/*
 * The Main class serves as the entry point for the Rescue Animal application.
 * It creates the main manager objects and starts the menu loop.
 */

public class Main {

    /*
     * Starts the Rescue Animal application.
     */
    public static void main(String[] args) {
        String connectionString = "mongodb://localhost:27017";
        String databaseName = "rescueAnimalDB";

        AnimalDatabase animalDatabase = new AnimalDatabase(connectionString, databaseName);
        AnimalManager animalManager = new AnimalManager(animalDatabase);
        MenuManager menuManager = new MenuManager(animalManager);
        
        menuManager.menuLoop();
    }
}