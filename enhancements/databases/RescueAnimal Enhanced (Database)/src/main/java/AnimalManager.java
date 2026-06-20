import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;
import org.bson.Document;

/*
 * The AnimalManager class stores and manages rescue animal records for the Rescue Animal application.
 * This class uses HashMaps to store Dog and Monkey objects, handles animal intake, reservation, 
 * printing operations, and loads saved records from the database. The class also uses AnimalValidator 
 * to validate animal data. 
 */
public class AnimalManager {
    private final HashMap<String, Dog> dogMap;
    private final HashMap<String, Monkey> monkeyMap;
    private final AnimalValidator animalValidator;
    private final AnimalDatabase animalDatabase;

    public AnimalManager(AnimalDatabase animalDatabase) {
        this.animalDatabase = animalDatabase;
        dogMap = new HashMap<>();
        monkeyMap = new HashMap<>();
        animalValidator = new AnimalValidator();
        loadAnimalsFromDatabase();
    }

    /*
     * Loads saved dog and monkey records from the database and adds them to the respective HashMaps.
     */
    private void loadAnimalsFromDatabase() {
        for (Document document : animalDatabase.loadDogs()) {
            Dog dog = new Dog(
                document.getString("name"),
                document.getString("breed"),
                document.getString("gender"),
                document.getInteger("age"),
                document.getDouble("weight"),
                LocalDate.parse(document.getString("acquisitionDate")),
                document.getString("acquisitionCountry"),
                document.getString("trainingStatus"),
                document.getBoolean("reserved"),
                document.getString("inServiceCountry")
            );

            addDog(dog);
        }

        for (Document document : animalDatabase.loadMonkeys()) {
            Monkey monkey = new Monkey(
                document.getString("name"),
                document.getString("species"),
                document.getString("gender"),
                document.getInteger("age"),
                document.getDouble("weight"),
                LocalDate.parse(document.getString("acquisitionDate")),
                document.getString("acquisitionCountry"),
                document.getString("trainingStatus"),
                document.getBoolean("reserved"),
                document.getString("inServiceCountry"),
                document.getDouble("tailLength"),
                document.getDouble("height"),
                document.getDouble("bodyLength")
            );

            addMonkey(monkey);
        }
    }

    /*
     * Creates a unique key using the animal type and animal name.
     * This key is used to store and retrieve animal records in the HashMaps. 
     */
    private String createKey(String animalType, String name) {
        return animalType.trim().toLowerCase() + "-" + name.trim().toLowerCase();
    }
    /*
     * Adds a dog object to the dog HashMap using the generated key.
     */
    private void addDog(Dog dog) {
        String key = createKey("dog", dog.getName());
        dogMap.put(key, dog);
    }

    /*
     * Adds a monkey object to the monkey HashMap using the generated key.
     */
    private void addMonkey(Monkey monkey) {
        String key = createKey("monkey", monkey.getName());
        monkeyMap.put(key, monkey);
    }

    /*
     * Collects and validates user input for a new dog record, creates a Dog object,
     * adds it to the dog HashMap, and saves it to the database if the dog is not 
     * already in the system.
     */
    public void intakeNewDog(Scanner scanner) {
        System.out.print("Enter dog's name: "); 
        String name = scanner.nextLine().trim();
        if (dogMap.containsKey(createKey("dog", name))) {
            System.out.println("This dog already exists in the system.");
            return;
        }
        System.out.print("Enter dog's breed: ");
        String breed = scanner.nextLine().trim();

        System.out.print("Enter dog's gender: "); 
        String gender = scanner.nextLine().trim();
        if (!animalValidator.isValidGender(gender)) {
            System.out.println("Invalid gender. Please enter 'male' or 'female'.");
            return;
        }

        System.out.print("Enter dog's age: ");
        int age; 
        try {
            age = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Age must be numerical.");
            return;
        }
        if (age < 1 || age > 35) {
            System.out.println("Invalid age. Accepted ages are 1 to 35.");
            return;
        }

        System.out.print("Enter dog's weight: ");
        double weight;
        try {
            weight = Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Weight must be numerical.");
            return;
        }
        if (weight < 1 || weight > 250) {
            System.out.println("Invalid weight. Accepted weights are 1 to 250 pounds.");
            return;
        }

        System.out.print("Enter dog's acquisition date (YYYY-MM-DD): ");
        LocalDate acquisitionDate;
        try {
            acquisitionDate = LocalDate.parse(scanner.nextLine().trim());
        } catch (Exception e) {
            System.out.println("Invalid date. Date must be in the format YYYY-MM-DD.");
            return;
        }

        System.out.print("Enter dog's acquisition country: ");
        String acquisitionCountry = scanner.nextLine().trim();
        if (!animalValidator.isValidCountry(acquisitionCountry)) {
            System.out.println("Invalid acquisition country.");
            return;
        }

        System.out.print("Enter dog's training status: "); 
        String trainingStatus = scanner.nextLine().trim();
        if (!animalValidator.isValidTrainingStatus(trainingStatus)) {
            System.out.println("Invalid training status. Accepted statuses are 'In service', 'Phase I', 'Phase II', 'Phase III', 'Phase IV', or 'Intake'.");
            return;
        }

        System.out.print("Is the dog reserved? (yes/no): ");
        String reservedInput = scanner.nextLine().trim();
        boolean reserved;
        if (reservedInput.equalsIgnoreCase("yes")) {
            reserved = true;
        } 
        else if (reservedInput.equalsIgnoreCase("no")) {
            reserved = false;
        } 
        else {
            System.out.println("Invalid input. Reserved status must be 'yes' or 'no'.");
            return;
        }

        System.out.print("Enter dog's in-service country: "); 
        String inServiceCountry = scanner.nextLine().trim();
        if (!animalValidator.isValidCountry(inServiceCountry)) {
            System.out.println("Invalid in-service country.");
            return;
        }

        Dog dog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, 
            trainingStatus, reserved, inServiceCountry);
        addDog(dog);
        animalDatabase.saveDog(dog);
        System.out.println("Dog added successfully.");
    }

    /*
     * Collects and validates user input for a new monkey record, creates a Monkey object,
     * adds it to the monkey HashMap, and saves it to the database if the monkey is not 
     * already in the system.
     */
    public void intakeNewMonkey(Scanner scanner) {
        System.out.print("Enter monkey's name: ");
        String name = scanner.nextLine().trim();
        if (monkeyMap.containsKey(createKey("monkey", name))) {
            System.out.println("This monkey already exists in the system.");
            return;
        }

        System.out.print("Enter monkey's species: "); 
        String species = scanner.nextLine().trim();
        if (!animalValidator.isValidMonkeySpecies(species)) {
            System.out.println("Invalid monkey species. Accepted species are Capuchin, Guenon, Macaque, Marmoset, Squirrel Monkey, or Tamarin.");
            return;
        }

        System.out.print("Enter monkey's gender: "); 
        String gender = scanner.nextLine().trim();
        if (!animalValidator.isValidGender(gender)) {
            System.out.println("Invalid gender. Please enter 'male' or 'female'.");
            return;
        }

        System.out.print("Enter monkey's age: ");
        int age;
        try {
            age = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Age must be numerical.");
            return;
        }
        if (age < 1 || age > 50) {
            System.out.println("Invalid age. Accepted ages are 1 to 50.");
            return;
        }

        System.out.print("Enter monkey's weight: ");
        double weight;
        try {
            weight = Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Weight must be a numerical value.");
            return;
        }
        if (weight <= 0 || weight > 200) {
            System.out.println("Invalid weight. Accepted weights are between 1 and 200 pounds.");
            return;
        }

        System.out.print("Enter monkey's acquisition date (YYYY-MM-DD): ");
        LocalDate acquisitionDate;
        try {
            acquisitionDate = LocalDate.parse(scanner.nextLine().trim());
        } catch (Exception e) {
            System.out.println("Invalid date. Date must be in the format YYYY-MM-DD.");
            return;
        }

        System.out.print("Enter monkey's acquisition country: "); 
        String acquisitionCountry = scanner.nextLine().trim();
        if (!animalValidator.isValidCountry(acquisitionCountry)) {
            System.out.println("Invalid country. Please enter a valid country name.");
            return;
        }

        System.out.print("Enter monkey's training status: "); 
        String trainingStatus = scanner.nextLine().trim();
        if (!animalValidator.isValidTrainingStatus(trainingStatus)) {
            System.out.println("Invalid training status. Accepted statuses are 'In service', 'Phase I', 'Phase II', 'Phase III', 'Phase IV', or 'Intake'.");
            return;
        }

        System.out.print("Is the monkey reserved? (yes/no): ");
        String reservedInput = scanner.nextLine().trim();
        boolean reserved;

        if (reservedInput.equalsIgnoreCase("yes")) {
            reserved = true;
        } 
        else if (reservedInput.equalsIgnoreCase("no")) {
            reserved = false;
        } 
        else {
            System.out.println("Invalid input. Reserved status must be 'yes' or 'no'.");
            return;
        }

        System.out.print("Enter monkey's in-service country: "); 
        String inServiceCountry = scanner.nextLine().trim();
        if (!animalValidator.isValidCountry(inServiceCountry)) {
            System.out.println("Invalid country in-service country.");
            return;
        }

        System.out.print("Enter monkey's tail length: ");
        double tailLength;
        try {
            tailLength = Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Tail length must be a numerical value.");
            return;
        }
        if (tailLength <= 0 || tailLength > 100) {
            System.out.println("Invalid tail length. Accepted lengths are 1 to 100 inches.");
            return;
        }

        System.out.print("Enter monkey's height: ");
        double height;
        try {
            height = Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Height must be a numerical value.");
            return;
        }
        if (height <= 0 || height > 100) {
            System.out.println("Invalid height. Accepted heights are 1 to 100 inches.");
            return;
        }

        System.out.print("Enter monkey's body length: ");
        double bodyLength;
        try {
            bodyLength = Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Body length must be a numerical value.");
            return;
        }
        if (bodyLength <= 0 || bodyLength > 100) {
            System.out.println("Invalid body length. Accepted lengths are 1 to 100 inches.");
            return;
        }

        Monkey monkey = new Monkey(name, species, gender, age, weight, acquisitionDate, acquisitionCountry, 
            trainingStatus, reserved, inServiceCountry, tailLength, height, bodyLength);
        addMonkey(monkey);
        animalDatabase.saveMonkey(monkey);
        System.out.println("Monkey added successfully.");
    }

    /*
     * Reserves an avaialbe dog or monkey based on the animal type and in-service country.
     * This method searches through the HashMap values becuase the reservation search is
     * based on courntry and available status. */
    public void reserveAnimal(Scanner scanner) {
        System.out.print("Enter animal type to reserve (dog/monkey): ");
        String animalType = scanner.nextLine().trim();

        if (!animalValidator.isValidAnimalType(animalType)) {
            System.out.println("Invalid animal type. Please enter 'dog' or 'monkey'.");
            return;
        }
        System.out.print("Enter the country where the animal is needed: ");
        String country = scanner.nextLine().trim();
        if (!animalValidator.isValidCountry(country)) {
            System.out.println("Invalid country. Please enter a valid country name.");
            return;
        }

        boolean animalReserved = false;

        if (animalType.equalsIgnoreCase("dog")) {
            for (Dog dog : dogMap.values()) {
                if (dog.getInServiceCountry().equalsIgnoreCase(country) && !dog.isReserved()) {
                    dog.setReserved(true);
                    animalDatabase.updateAnimalReservationStatus("dog", dog.getName(), true);
                    animalReserved = true;
                    System.out.println("Dog " + dog.getName() + " has been reserved.");
                    break;
                }
            }
        } 
        else if (animalType.equalsIgnoreCase("monkey")) {
            for (Monkey monkey : monkeyMap.values()) {
                if (monkey.getInServiceCountry().equalsIgnoreCase(country) && !monkey.isReserved()) {
                    monkey.setReserved(true);
                    animalDatabase.updateAnimalReservationStatus("monkey", monkey.getName(), true);
                    animalReserved = true;
                    System.out.println("Monkey " + monkey.getName() + " has been reserved.");
                    break;
                }
            }
        }

        if (!animalReserved) {
            System.out.println("No available " + animalType + " found for reservation in " + country + ".");
        }
    }
    /* 
     * Prints dog, monkey, or available animal records using the selected print option.
     * This method iterates through the HashMap values because it prints groups of animals
     * rather than retrieving one specific animal by key.
     */
    public void printAnimals(String printAnimalType) {
        System.out.printf("%-15s %-18s %-18s %-20s%n",
                "Name", "Breed/Species", "Training Status", "In Service Country");
        System.out.println("--------------------------------------------------------------------------------");

        if (printAnimalType.equalsIgnoreCase("dog")){
            for (Dog dog : dogMap.values()) {
                System.out.printf("%-15s %-18s %-18s %-20s%n",
                        dog.getName(), dog.getBreed(), dog.getTrainingStatus(), dog.getInServiceCountry());
            }
        }
        else if (printAnimalType.equalsIgnoreCase("monkey")){
            for (Monkey monkey : monkeyMap.values()) {
                System.out.printf("%-15s %-18s %-18s %-20s%n",
                        monkey.getName(), monkey.getSpecies(), monkey.getTrainingStatus(), monkey.getInServiceCountry());
            }
        }
        else if (printAnimalType.equalsIgnoreCase("available")){
            for (Dog dog : dogMap.values()) {
                if (!dog.isReserved()) {
                    System.out.printf("%-15s %-18s %-18s %-20s%n",
                            dog.getName(), dog.getBreed(), dog.getTrainingStatus(), dog.getInServiceCountry());
                }
            }
            for (Monkey monkey : monkeyMap.values()) {
                if (!monkey.isReserved()) {
                    System.out.printf("%-15s %-18s %-18s %-20s%n",
                            monkey.getName(), monkey.getSpecies(), monkey.getTrainingStatus(), monkey.getInServiceCountry());
                }
            }
        }
        else {
            System.out.println("Invalid print option. Please enter 'dog', 'monkey', or 'available'.");
        }
    }
}
