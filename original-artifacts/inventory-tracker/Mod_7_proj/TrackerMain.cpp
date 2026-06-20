/*			Wyatt Moore				*
 *			04/17/2025				* 
 * This program takes an input file *
 * backs up the product information to an output file *
 * and allows the user gather information about the *
 * products in the file based on user input */
#include <iostream>
#include <fstream>
using namespace std;
#include "Tracker.h"


int main() {
	Tracker test;

	// Calls fileManagement function
	test.fileManagement();

	// Calls fileBackup function
	test.fileBackup();

	// Calls switchLoop function
	test.switchLoop();

	// Exits program
	return 0;
}