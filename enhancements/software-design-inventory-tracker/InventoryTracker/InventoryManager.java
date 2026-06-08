/* 
 * The InventoryManager class stores and manages inventory item data for the inventory tracking application.
 * This class uses a HashMap to store item names and their frequencies, allowing the inventory data 
 * to be loaded once and reused throughout the program. It provides methods for adding items, finding 
 * item quantities, listing all item frequencies, and printing a histogram.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InventoryManager {
    private final Map<String, Integer> itemFrequencies;

    public InventoryManager() {
        itemFrequencies = new HashMap<>();
    }
    /*
     * Prompts the user to enter an item name and displays the frequency of that item.
     */
    public void findItem(Scanner scanner) {
        System.out.println("Enter an item: ");
        String itemName = scanner.nextLine().trim();
        int frequency = getItemFrequency(itemName);
        System.out.println("There are " + frequency + " " + itemName);
        System.out.println();
    }

    /*
     * Prints all items and their frequencies.
     */
    public void listItems() {
        for (Map.Entry<String, Integer> entry : itemFrequencies.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    /*
     * Prints a histogram of the inventory items using asterisks
     * to represent the frequencies.
     */
    public void histogram() {
        for (Map.Entry<String, Integer> entry : itemFrequencies.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            for (int i = 0; i < entry.getValue(); i++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }
    /*
     * Adds an item to the inventory frequency map or increments its frequency if item already exists.
     */
    public void addItem(String itemName) {
        itemFrequencies.put(itemName, itemFrequencies.getOrDefault(itemName, 0) + 1);
    }

    /*
     * Returns the frequency of a specific item.
     */
    public int getItemFrequency(String itemName) {
        return itemFrequencies.getOrDefault(itemName, 0);
    }
    /*
     * Returns the full frequency map of all inventory items.
     */
    public Map<String, Integer> getItemFrequencies() {
        return itemFrequencies;
    }
}