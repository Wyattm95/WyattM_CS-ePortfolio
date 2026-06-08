/* 
 * The MenuManager class handles the menu system for the Inventory Tracker application.
 * This class is responsible for displaying menu options, collecting the user's menu selection,
 * and executing the corresponding actions based on the user's selection. 
 */

import java.util.Scanner;

public class MenuManager {
    private final InventoryManager inventoryManager;
    private final Scanner scanner;

    public MenuManager(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
        this.scanner = new Scanner(System.in);
    }

    /*
     * Runs the main menu loop for the Inventory Tracker application.
     * This method displays the menu options, reads the user's selection,
     * and executes the corresponding Inventory Manager methods based on the selected option.
     */
    public void switchLoop() {
        char option = '0';

        do {
            displayMenu();
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("No input detected. Please enter a valid option.");
                continue;
            }

            option = input.charAt(0);

            switch (option) {
                case '1':
                    inventoryManager.findItem(scanner);
                    break;
                
                case '2':
                    inventoryManager.listItems();
                    break;
                
                case '3':
                    inventoryManager.histogram();
                    break;
                
                case '4':
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid option. Please enter a valid option.");
                    break;
            }

        } while (option != '4');
    }

    /*
     * Displays the main menu options for the Inventory Tracker application.
     */
    private void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Search for an item");
        System.out.println("2. List all items");
        System.out.println("3. Print histogram");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }
}
