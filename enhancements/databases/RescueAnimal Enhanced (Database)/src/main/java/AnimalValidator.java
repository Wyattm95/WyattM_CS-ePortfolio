import java.util.Arrays;
import java.util.List;

/*
 * The AnimalValidator class stores accepted input values for the Rescue Animal application
 * and provides methods for validating user-entered animal data. 
 */
public class AnimalValidator {
    
    private static final List<String> ACCEPTED_MONKEY_SPECIES = Arrays.asList(
        "Capuchin",
        "Guenon",
        "Macaque",
        "Marmoset",
        "Squirrel Monkey",
        "Tamarin"
    );

    private static final List<String> ACCEPTED_GENDERS = Arrays.asList(
        "Male",
        "Female"
    );

    private static final List<String> ACCEPTED_TRAINING_STATUSES = Arrays.asList(
        "intake",
        "Phase I",
        "Phase II",
        "Phase III",
        "Phase IV",
        "In Service"
    );

    private static final List<String> ACCEPTED_COUNTRIES = Arrays.asList(
        "United States",
        "Canada",
        "United Kingdom",
        "Australia",
        "Germany",
        "France",
        "Japan",
        "China",
        "India"
    );

    private static final List<String> ACCEPTED_ANIMAL_TYPES = Arrays.asList(
        "dog",
        "monkey"
    );

    public boolean isValidMonkeySpecies(String species) {
        return isValidInput(ACCEPTED_MONKEY_SPECIES, species);
    }

    public boolean isValidGender(String gender) {
        return isValidInput(ACCEPTED_GENDERS, gender);
    }

    public boolean isValidTrainingStatus(String status) {
        return isValidInput(ACCEPTED_TRAINING_STATUSES, status);
    }

    public boolean isValidCountry(String country) {
        return isValidInput(ACCEPTED_COUNTRIES, country);
    }

    public boolean isValidAnimalType(String type) {
        return isValidInput(ACCEPTED_ANIMAL_TYPES, type);
    }

    /* 
     * Checks if a user-entered value matches one of the accepted values in a list, ignoring case.
     */
    private boolean isValidInput(List<String> list, String value) {
        for (String item : list) {
            if (item.equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }
}
