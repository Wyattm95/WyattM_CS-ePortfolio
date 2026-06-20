#ifndef TRACKER_H
#define TRACKER_H

#include <string>
#include <fstream>
using namespace std;

class Tracker {

public:
	Tracker(); // Default contructor

	// Opens files and checks they opened successfully
	int fileManagement();

	// Writes item name and quantity to output file
	void fileBackup();

	// Menu with user input options
	void displayMenu() const;

	// Loop that excepts user input and calls functions based on input number
	void switchLoop();

	// Functions user can run
	void findItem();
	void listItem();
	void histogram();

private:
	// Member varialbes
	ifstream inFS;
	ofstream outFS;
};
#endif
