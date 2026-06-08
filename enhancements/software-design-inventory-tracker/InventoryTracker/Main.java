/* 
 * The Main class serves as the entry point for the Inventory Tracker application.
 * This class initializes the necessary manager objects used by the program,
 * loads inventory data from the input file, creates the backup file, and starts the menu
 * system for user interaction  
 */

public class Main {
    /* 
     * Starts the Inventory Tracker application by creating the manager objects,
     * loading inventory data from the input file, creating the backup file, and launching the menu system
     */
    public static void main(String[] args) {
        String inputFilePath = "res/CS210_Project_Three_Input_File.txt";
        String backupFilePath = "res/frequency.dat";

        InventoryManager inventoryManager = new InventoryManager();
        MenuManager menuManager = new MenuManager(inventoryManager);
        FileManager fileManager = new FileManager();

        fileManager.loadInventoryData(inputFilePath, inventoryManager);
        fileManager.createBackupFile(backupFilePath, inventoryManager);

        menuManager.switchLoop();
    }
}