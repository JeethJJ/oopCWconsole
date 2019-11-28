import com.mongodb.MongoClient;
import dev.morphia.Datastore;
import dev.morphia.Morphia;
import dev.morphia.query.Query;
import java.util.List;


public class Database {
    private Morphia morphia = new Morphia();          //creating connection
    private Datastore rentalStore = morphia.createDatastore(new MongoClient(), "RentalStore");

    //Declare database
    public Database() {
        morphia.mapPackage("com.github.jeethjj.oopcw");
        rentalStore.ensureIndexes();
    }

    public void saveVehicle(Vehicle vehicle) {
        rentalStore.save(vehicle);
    }

    public void saveCar(Car car) {
        rentalStore.save(car);
    }

    public void saveBike(Motorbike bike) {
        rentalStore.save(bike);
    }

    public List<Motorbike> getBike() {                           //get all bike objects
        Query<Motorbike> query = this.rentalStore.createQuery(Motorbike.class);
        return query.find().toList();
    }

    public List<Car> getCar() {                     //get all car objects
        Query<Car> query = this.rentalStore.createQuery(Car.class);
        return query.find().toList();
    }


    public void deleteFromDb(Vehicle vehicle) {

        Query queryB;

        if (vehicle instanceof Car) {
            queryB = (Query<Car>) rentalStore.createQuery(Car.class).field("plateNumber").equal(vehicle.getPlateNumber());
        } else {
            queryB = (Query<Motorbike>) rentalStore.createQuery(Motorbike.class).field("plateNumber").equal(vehicle.getPlateNumber());
        }
        rentalStore.delete(queryB);
    }


}
