#include <iostream>
#include <iomanip>
#include <fstream>
#include <map>
#include "Tracker.h"
using namespace std;
Tracker::Tracker() {}

// Menu displayed at start of each switch loop
void Tracker::displayMenu() const {
    cout << "Press 1 to find an item" <<  endl;
    cout << "Press 2 to list items and quantities" << endl;
    cout << "Press 3 to print histogram" << endl;
    cout << "Press 4 to exit" << endl;
    cout << endl;
}

// Opens input and out put files, checks that both opened correctly.
int Tracker::fileManagement() {
    inFS.open("CS210_Project_Three_Input_File.txt"); // Opens input file with products
    if (!inFS.is_open()) { // Checks if input file opened successfully
        cout << "Error opening input file." << endl; // Error message if file dose not open
        return EXIT_FAILURE;
    }
    outFS.open("frequency.dat"); // Opens output file
    if (!outFS.is_open()) { // Checks if output file opened successfully
        cout << "Error opening output file." << endl; // Error message if file dose not open
        return EXIT_FAILURE;
    }
    
}

// Backup item name and inventory count
void Tracker::fileBackup() {
    map<string, int> frequency; // Creates map to store item names and their frequency
    string item = ""; // String to hold item names read from file
    
    inFS.clear(); // Clears errors from input file stream
    inFS.seekg(0); // Moves file read position back to beginning

    while (getline(inFS, item)) { // Reads each line of file
        frequency[item]++; // Increments count for each instance of [item] in file
    }

    for (const auto& pair : frequency) { // Loops through each item name and its frequency
        outFS << pair.first << " " << pair.second << endl; // Writes item name and its frequency to output file 
    }
}

// Find and count specific item function
void Tracker::findItem() {
    string itemToFind = ""; // String to hold item name user inputs
    string item = ""; // String to hold names read from file
    int frequency = 0; // Variable for item count

    inFS.clear(); // Clears errors from input file stream
    inFS.seekg(0); // Moves file read position back to beginning

    cout << "Enter an item" << endl;
    cin >> itemToFind; // Sets itemToFind based on user input
    while (getline(inFS, item)) { // Reads each line of file
        // Increments counter if item and itemToFind are the same
        if (item == itemToFind) { 
            frequency ++;
        }
    }
    cout << "There are " << frequency << " " << itemToFind << endl; // Output with item frequency and name
    cout << endl;
}

// Lists items and counts
void Tracker::listItem() {
    map<string, int> frequency; // Creates a map to store item names and their frequency
    string item = ""; // String to hold names read from file

    inFS.clear(); // Clears errors from input file stream
    inFS.seekg(0); // Moves file read position back to beginning

    while (getline(inFS, item)) { // Reads each line of file
        frequency[item]++; // Increments count for each instance of [item] in file
    }

    for (const auto& pair : frequency) { // Loops through each item and its frequency
        cout << pair.first << " " << pair.second << endl; // Outputs each item name and its frequency
    }
    cout << endl;
}

// Lists items and count as "*"
void Tracker::histogram() {
    map<string, int>frequency; // Creates a map to store item names and their frequency
    string item = ""; // String to hold names read from file

    inFS.clear(); // Clears error from input file stream
    inFS.seekg(0); // Moves file read position back to the beginning

    while (getline(inFS, item)) { // Reads each line of file
        frequency[item]++; // Increments frequecny for each instance of [item] in file
    }

    for (const auto& pair : frequency) { // Loops through each item and its frequency
        cout << pair.first << " "; // Outputs item name
        // Outputs a string of "*" equal to frequcny 
        for (int i = 0; i < pair.second; ++i) {
            cout << "*";
        }
        cout << endl;
    }
    cout << endl;
}

// Switch that calls functions based on user unput
void Tracker::switchLoop() {
    char option = '0'; // Varialbe for user input to select menue option
    // While loop that continues until the user enters 4
    while (option != '4') {
        displayMenu(); // Calls displayMenu function at the top of each loop
        cin >> option; // Takes user input for menue option

        switch (option) {
        // Calls findItem function if user enters 1
        case '1':
            findItem();
            break;
        // Calls listItem function if user enters 2
        case '2': 
            listItem();
            break;
        // Calls histogram function if user enters 3
        case '3': 
            histogram();;
            break;
        case '4':
            inFS.close(); // Close input file stream
            outFS.close(); // Close output file stream
            return; // Exit function
        default: 
            cout << "Invalid input, enter a valid option."; // Error if any number other than 1 - 4 is entered
            break;
        }
    }
}
