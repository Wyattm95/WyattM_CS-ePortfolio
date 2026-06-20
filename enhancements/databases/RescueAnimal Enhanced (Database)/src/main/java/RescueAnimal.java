import java.time.LocalDate;

/*
 * The RescueAnimal class serves as the parent class for rescue animal records.
 * It stores shared attributes used by both Dog and Monkey objects.
 */
public class RescueAnimal {
    
    private String name;
    private String animalType;
    private String gender;
    private int age;
    private double weight;
    private LocalDate acquisitionDate;
    private String acquisitionCountry;
    private String trainingStatus;
    private boolean reserved;
    private String inServiceCountry;

    /*
     * Default constructor for RescueAnimal.
     */
    public RescueAnimal() {
    }

    /*
     * Getters and setters 
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public LocalDate getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(LocalDate acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public String getAcquisitionCountry() {
        return acquisitionCountry;
    }

    public void setAcquisitionCountry(String acquisitionCountry) {
        this.acquisitionCountry = acquisitionCountry;
    }

    public String getTrainingStatus() {
        return trainingStatus;
    }

    public void setTrainingStatus(String trainingStatus) {
        this.trainingStatus = trainingStatus;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public String getInServiceCountry() {
        return inServiceCountry;
    }

    public void setInServiceCountry(String inServiceCountry) {
        this.inServiceCountry = inServiceCountry;
    }   
}
