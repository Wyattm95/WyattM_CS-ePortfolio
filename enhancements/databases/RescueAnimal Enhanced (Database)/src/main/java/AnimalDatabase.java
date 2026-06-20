import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

/*
 * The AnimalDatabase class handles MongoDB operations for the Rescue Animal application.
 * This class connects to the database, saves animal records, loads animal records,
 * and updates reservation status in the animals collection.
 */

public class AnimalDatabase {
    private final MongoClient mongoClient;
    private final MongoDatabase database;
    private final MongoCollection<Document> animalCollection;

    public AnimalDatabase(String connectionString, String dbName) {
        mongoClient = MongoClients.create(connectionString);
        database = mongoClient.getDatabase(dbName);
        animalCollection = database.getCollection("animals");
    }

    /* 
     * Saves a dog object as a document in the animals collection.
     */
    public void saveDog(Dog dog) {
        Document dogDocument = new Document("animalType", "dog")
                .append("name", dog.getName())
                .append("breed", dog.getBreed())
                .append("gender", dog.getGender())
                .append("age", dog.getAge())
                .append("weight", dog.getWeight())
                .append("acquisitionDate", dog.getAcquisitionDate().toString())
                .append("acquisitionCountry", dog.getAcquisitionCountry())
                .append("trainingStatus", dog.getTrainingStatus())
                .append("reserved", dog.isReserved())
                .append("inServiceCountry", dog.getInServiceCountry());
        animalCollection.insertOne(dogDocument);
    }

    /*
     * Saves a monkey object as a document in the animals collection.
     */
    public void saveMonkey(Monkey monkey) {
        Document monkeyDocument = new Document("animalType", "monkey")
                .append("name", monkey.getName())
                .append("species", monkey.getSpecies())
                .append("gender", monkey.getGender())
                .append("age", monkey.getAge())
                .append("weight", monkey.getWeight())
                .append("acquisitionDate", monkey.getAcquisitionDate().toString())
                .append("acquisitionCountry", monkey.getAcquisitionCountry())
                .append("trainingStatus", monkey.getTrainingStatus())
                .append("reserved", monkey.isReserved())
                .append("inServiceCountry", monkey.getInServiceCountry())
                .append("tailLength", monkey.getTailLength())
                .append("height", monkey.getHeight())
                .append("bodyLength", monkey.getBodyLength());
        animalCollection.insertOne(monkeyDocument);
    }

    /*
     * Updates the reservation status of an animal document using animal type and name.
     */
    public void updateAnimalReservationStatus(String animalType, String name, boolean reserved) {
        Document query = new Document("animalType", animalType.toLowerCase())
                .append("name", name);

        Document update = new Document("$set", new Document("reserved", reserved));

        animalCollection.updateOne(query, update);
    }

    /*
     * Loads all dog documents from the animals collection.
     */
    public Iterable<Document> loadDogs() {
        return animalCollection.find(new Document("animalType", "dog"));
    }

    /*
     * Loads all monkey documents from the animals collection.
     */
    public Iterable<Document> loadMonkeys() {
        return animalCollection.find(new Document("animalType", "monkey"));
    }
}
