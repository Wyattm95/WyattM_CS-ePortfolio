
import java.time.LocalDate;

/*
 * The Dog class represents rescue dog records in the Rescue Animal application.
 * It extends the RescueAnimal parent class and adds the dog-specific breed attribute.
*/
public class Dog extends RescueAnimal {
    private String breed;

    /*
     * Creates a Dog object using rescue animal attributes and the dog-specific breed attribute.
     */
    public Dog(String name, String breed, String gender, int age, double weight,
    LocalDate acquisitionDate, String acquisitionCountry, String trainingStatus, boolean reserved,
    String inServiceCountry) {
        setName(name);
        setBreed(breed);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionCountry(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
    
}
