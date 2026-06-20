public class Monkey extends RescueAnimal {
	
	//Monkey specific attributes 
    public String species;
    public String tailLength;
    public String height;
    public String bodyLength;
    
    //Constructor for monkey
    public Monkey(String name, String species, String gender, String age, String weight,
    String acquisitionDate, String acquisitionCountry, String trainingStatus, boolean reserved, 
    String inServiceCountry, String tailLength, String height, String bodyLength) {
        setName(name);
        setSpecies(species);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
    }
    
    //Get species
    public String getSpecies() {
        return species;
    }
    
    //Set species
    public void setSpecies(String species) {
        this.species = species;
    }
    
    //Get tailLendth
     public String getTailLength() {
        return tailLength;
    }
     
     //Set tailLength
    public void setTailLength(String tailLength) {
        this.tailLength = tailLength;   
    }
    
    //Get height
    public String getHeight() {
        return height;
    }
    
    //Set height
    public void setHeight(String height) {
        this.height = height;
    }
    
    //Get bodyLength
     public String getBodyLength() {
        return bodyLength;
    }
     
    //Set bodyLength
    public void setBodyLength(String bodyLength) {
        this.bodyLength = bodyLength;  
    }     
    public static void main(String[] args) {
	}          
}