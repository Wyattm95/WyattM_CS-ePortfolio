
import java.util.Scanner;

/*
 * The MenuManager class handles the user interface for the Rescue Animal application.
 * It displays the menu, takes user input, and calls the appropriate methods in the AnimalManager.
 */
public class MenuManager {
    private final AnimalManager animalManager;
    private final Scanner scanner;

    public MenuManager(AnimalManager animalManager) {
        this.animalManager = animalManager;
        this.scanner = new Scanner(System.in);
    }

    /*
     * Runs the main menu loop and routes the user's selection to the appropriate AnimalManager method.
     */
    public void menuLoop() {
        String option = "";
        while (!option.equals("q")) {
            displayMenu();
            option = scanner.nextLine().trim().toLowerCase();

            switch (option) {
                case "1":
                    animalManager.intakeNewDog(scanner);
                    break;
                case "2":
                    animalManager.intakeNewMonkey(scanner);
                    break;
                case "3":
                    animalManager.reserveAnimal(scanner);
                    break;
                case "4":
                    animalManager.printAnimals("dog");
                    break;
                case "5":
                    animalManager.printAnimals("monkey");
                    break;
                case "6":
                    animalManager.printAnimals("available");
                    break;
                case "q":
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    /* 
     * Displays the available menu options to the user.
     */
    private void displayMenu() {
        System.out.println("\nRescue Animal Menu:");
        System.out.println("1. Intake a new dog");
        System.out.println("2. Intake a new monkey");
        System.out.println("3. Reserve an animal");
        System.out.println("4. Print a list of all dogs");
        System.out.println("5. Print a list of all monkeys");
        System.out.println("6. Print a list of all animals that are not reserved");
        System.out.println("q. Quit the program");
        System.out.print("Enter a menu selection: ");
    }
}
