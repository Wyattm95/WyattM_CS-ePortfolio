/*
 * The Main class serves as the entry point for the Rescue Animal application.
 * It creates the main manager objects and starts the menu loop.
 */
public class Main {
    public static void main(String[] args) {
        AnimalManager animalManager = new AnimalManager();
        MenuManager menuManager = new MenuManager(animalManager);
        
        menuManager.menuLoop();
    }
}