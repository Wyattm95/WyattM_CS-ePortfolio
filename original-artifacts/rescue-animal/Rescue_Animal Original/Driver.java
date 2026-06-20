import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    
    //Monkey array list
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();
    
    private static String option = "";
    private static Scanner scanner = new Scanner(System.in);
    private static String[] monkeySpecies = {"Capuchin", "Guenon", "Macaque", "Mamoset", "Squirrel Monkey", "Tamarin"};
    
    // Instance variables (if needed)

    public static void main(String[] args) {


        initializeDogList();
        initializeMonkeyList();
        
    //Menu Loop
    while (!option.equals("q")) {
    	displayMenu();
    	option = scanner.nextLine();
    	
    	switch(option) {
    	case "q":
    		break;
    	case "1":
    		intakeNewDog(scanner);
    		break;
    	case "2":
    		intakeNewMonkey(scanner);
    		break;
    	case "3":					
    		reserveAnimals(scanner);
    		break;
    	case "4":
    		printAnimals("dog");
    		break;				   
    	case "5":
    		printAnimals("monkey");
    		break;
    	case "6":
    		printAnimals("available");
    		break;
    	default:
    		System.out.println("Invalid input, enter a valid option.");
    		break;
    		
    	}
    }

    }

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }


    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }


    //Test monkey
    public static void initializeMonkeyList() {
    	Monkey monkey1 = new Monkey("Frank", "Capuchin", "Male", "12", "12", "02-12-2022", "United States", "intake", false, "United States", "12", "12", "12");
    	
    	monkeyList.add(monkey1);

    }

    //Intake new dog method
    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();
        
        //Check if dog is already in system
        for(Dog dog: dogList) {
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; 
            }
        }

        //Gather dog attributes from user
        System.out.println("What is the dog's breed?");
        String breed = scanner.nextLine();
        System.out.println("What is the dog's gender?");
        String gender = scanner.nextLine();
        System.out.println("What is the dog's age?");
        String age = scanner.nextLine();
        System.out.println("What is the dog's weight?");
        String weight = scanner.nextLine();
        System.out.println("What is the dog's acqusition date?");
        String acqusitionDate = scanner.nextLine();
        System.out.println("What is the dog's acqusition country?");
        String acqusitionCountry = scanner.nextLine();
        System.out.println("What is the dog's training status?");
        String trainingStatus = scanner.nextLine();
        System.out.println("What is the dog's in service country?");
        String inServiceCountry = scanner.nextLine();
        
        Dog dog = new Dog(name, breed, gender, age, weight, acqusitionDate, acqusitionCountry, trainingStatus, false, inServiceCountry);
        
        //Adds new dog to dog list
        dogList.add(dog);
    }
       
    	//Method for intaking new Monkey
        public static void intakeNewMonkey(Scanner scanner) {
        	System.out.println("What is the monkey's name?");
        	String name = scanner.nextLine();
        	
        	//Checks if monkey is already in system
        	for(Monkey monkey: monkeyList) {
        		if(monkey.getName().equalsIgnoreCase(name)) {
        			System.out.println("\n\nThis monkey is already in our system.\n\n");
        			return;
        		}
        	}
        	
        	//Checks if species entered is valid
        	System.out.println("What is the monkey's species?");
        	String species = scanner.nextLine();
        	boolean acceptedSpecies = false;
        	for(String monkeySpecies: monkeySpecies) {
        		if(monkeySpecies.equalsIgnoreCase(species)) {
        			acceptedSpecies = true;
        		}
        	}
        	//Prints not accepted line and returns user to menu
        	if(!acceptedSpecies) {
        		System.out.println("\n\nWe do not accept this species.\n\n");
        		return;
        	}
        	
        	//Gather monkey attributes from user
        	System.out.println("What is the monkey's gender?");
        	String gender = scanner.nextLine();
        	System.out.println("What is the monkey's age?");
        	String age = scanner.nextLine();
        	System.out.println("What is the monkey's weight?");
        	String weight = scanner.nextLine();
        	System.out.println("What is the monkey's acqusition date?");
        	String acqusitionDate = scanner.nextLine();
        	System.out.println("What is the monkey's acqusition country?");
        	String acqusitionLocation = scanner.nextLine();
        	System.out.println("What is the monkey's training status?");
        	String trainingStatus = scanner.nextLine();
        	System.out.println("What is the monkey's service country?");
        	String inserviceCountry = scanner.nextLine();
        	System.out.println("What is the monkey's tail length?");
        	String tailLength = scanner.nextLine();
        	System.out.println("What is the monkey's height?");
        	String height = scanner.nextLine();
        	System.out.println("What is the monkey's body length?");
        	String bodyLength = scanner.nextLine();
        	
        	//Creates new Monkey with above monkey attributes
        	Monkey monkey = new Monkey(name, species, gender, age, weight, acqusitionDate, acqusitionLocation, trainingStatus, false,
        	 inserviceCountry, tailLength, height, bodyLength);
                       
            //Adds monkey to monkey array list
            monkeyList.add(monkey);
            
            //Prints monkey list after new monkey is added
            for(Monkey i: monkeyList) {
            	System.out.println(i.getName());
            }
        }

        //Method for reserving new animal
        public static void reserveAnimals(Scanner scanner) {
            System.out.println("What type of animal are you reserving?");
            String animalType = scanner.nextLine();
            System.out.println("Which country will you need the animal in?");
            String country = scanner.nextLine();           
            boolean animalReserved = false;
            
            //Reserving new dog
            if(animalType.equalsIgnoreCase("Dog")) {
            	for(Dog dog: dogList) {
            		if(dog.getAcquisitionLocation().equals(country) && !dog.getReserved()) {
            			dog.setReserved(true);
            			animalReserved = true;
            			System.out.println("Reservation succsessful!");
            			break;
            		}
            	}
            }
            	//Reserving new monkey
            	else if(animalType.equalsIgnoreCase("Monkey")){
            		for(Monkey monkey: monkeyList) {
            			if(monkey.getAcquisitionLocation().equals(country) && !monkey.getReserved()) {
            				monkey.setReserved(true);
            				animalReserved = true;
            				System.out.println("Reservation succsessful!");
            				break;
            		}
            	}
            //Error message if animal entered is not dog/monkey
            }else {
            	System.out.println("We do not offer that type of animal");
            	return;
            }
            //Error message if no available animalType in country
            if(!animalReserved) {
            	System.out.println("There is no available " + animalType + " in " + country);
            	return;
            }
            }
            
        //Method to print animals    
        public static void printAnimals(String printAnimalType) {
        	String header = "Name | Type | Training Status | In Service Country";
            System.out.println(header);
            
            //Prints all dogs
            if(printAnimalType.equals("dog")){
            	for(Dog dog: dogList) {
            		System.out.println(dog.getName() + "|" + dog.getBreed() + "|" + dog.getTrainingStatus() + "|" + dog.getInServiceLocation());
            	}
            }
            
            //Prints all monkeys
            if(printAnimalType.equals("monkey")) {
            	for(Monkey monkey: monkeyList) {
            		System.out.println(monkey.getName() + "|" + monkey.getSpecies() + "|" + monkey.getTrainingStatus() + "|" + monkey.getInServiceLocation());
            	}
            }
            
            //Prints all available dogs
            if(printAnimalType.equals("available")){
            	for(Dog dog:dogList) {
            		if(!dog.getReserved()) {
            			System.out.println(dog.getName() + "|" + dog.getBreed() + "|" + dog.getTrainingStatus() + "|" + dog.getInServiceLocation());            			
            		}
            	}
            	
            	//Prints all available monkeys
            	for(Monkey monkey: monkeyList) {
            		if(!monkey.getReserved()) {
            			System.out.println(monkey.getName() + "|" + monkey.getSpecies() + "|" + monkey.getTrainingStatus() + "|" + monkey.getInServiceLocation());          			
            		}
            	}
            }

        }
}