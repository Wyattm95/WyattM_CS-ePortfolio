/* 
 * The FileManager class handles file operations for the Inventory Tracker application.
 * This class is responsible for reading inventory data from the input file, loading item frequencies into the inventory manager,
 * and creating the backup file containing item names and frequencies.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

public class FileManager {
    /* 
     * Reads inventory item data from the input file and loads each item into the inventory manager's frequency map.
     * If the input file is not found, the program displays an error message and exits.
     */
    public void loadInventoryData(String inputFileName, InventoryManager inventoryManager) {
        File inputFile = new File(inputFileName);

        try (Scanner fileScanner = new Scanner(inputFile)) {
            while (fileScanner.hasNextLine()) {
                String itemName = fileScanner.nextLine().trim();

                if (!itemName.isEmpty()) {
                    inventoryManager.addItem(itemName);
                }
            }

            System.out.println("Inventory data loaded successfully from " + inputFileName);
        }
        catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + inputFileName);
            System.exit(1);
        }
    }
    
    /*
     * Creates a backup file containing the inventory item names and their frequencies.
     * The backup data is written from the item frequency map in the inventory manager.
     * If the file cannot be created, an error message is displayed and the program exits.
     */
    public void createBackupFile(String outputFileName, InventoryManager inventoryManager) {
        try (PrintWriter writer = new PrintWriter(outputFileName)) {
            for (Map.Entry<String, Integer> entry : inventoryManager.getItemFrequencies().entrySet()) {
                writer.println(entry.getKey() + ": " + entry.getValue());
            }

            System.out.println("Backup file created successfully: " + outputFileName);
        } 
        catch (FileNotFoundException e) {
            System.out.println("Error: Unable to create file - " + outputFileName);
            System.exit(1);
        }
    }
}