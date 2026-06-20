
import java.time.LocalDate;

/*
 * The Monkey class represents a monkey object in the rescue animal system.
 * It extends the RescueAnimal class and adds specific attributes for monkeys.
 */
public class Monkey extends RescueAnimal {

    private String species;
    private double tailLength;
    private double height;
    private double bodyLength;

    /*
     * Creates a Monkey object using Rescue Animal attributes and the monkey-specific attributes.
     */
    public Monkey(String name, String species, String gender, int age, double weight,
            LocalDate acquisitionDate, String acquisitionCountry, String trainingStatus, 
            boolean reserved, String inServiceCountry, double tailLength, double height, 
            double bodyLength) {
        setName(name);
        setSpecies(species);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionCountry(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
        setTailLength(tailLength);
        setHeight(height);
        setBodyLength(bodyLength);
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public double getTailLength() {
        return tailLength;
    }

    public void setTailLength(double tailLength) {
        this.tailLength = tailLength;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBodyLength() {
        return bodyLength;
    }

    public void setBodyLength(double bodyLength) {
        this.bodyLength = bodyLength;
    }
}
