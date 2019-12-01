import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DatabaseTesting {

    List<Car> cars = new ArrayList<>();
    List<Motorbike> bikes = new ArrayList<>();
    Database db = new Database();
    WestminsterRentalVehicleManager wm = new WestminsterRentalVehicleManager();

    @Test
    void checkGetVehicle(){
        bikes.addAll(db.getBike());
        cars.addAll(db.getCar());
        assertEquals(bikes.size()+cars.size(),WestminsterRentalVehicleManager.vehicleLot.size());
    }



        @Test
        void carAddCheck(){
            String plateNumber = "CAA-0000";                                             //super class of bike and car
            String make = "BMW";
            BigDecimal ratePerDay = BigDecimal.valueOf(3500);
            int manufactureYear = 2017;
            double kmPerLiter = 20;
            boolean hybrid = true;
            int engineCC = 1800;
            int noOfDoors = 3;
            int noOfSpareWheels = 1;
            boolean status=false;
            Vehicle car = new Car(plateNumber, make, ratePerDay, manufactureYear, kmPerLiter, hybrid, engineCC, noOfDoors, noOfSpareWheels);

            db.saveCar((Car) car);
            cars.clear();
            cars.addAll(db.getCar());

            for (Car c : cars){
                if(c.getPlateNumber().equals(car.getPlateNumber())){
                    status=true;
                }
            }
            db.deleteFromDb(car);
            assertEquals(true,status);
        }

        @Test
        void bikeAddCheck() {
            String plateNumber = "CAA-0001";                                             //super class of bike and car
            String make = "BMW";
            BigDecimal ratePerDay = BigDecimal.valueOf(3500);
            int manufactureYear = 2017;
            double kmPerLiter = 20;
            boolean hybrid = true;
            int engineCC = 1800;
            int stands = 2;
            int helmets = 2;
            boolean status = false;
            Vehicle bike = new Motorbike(plateNumber, make, ratePerDay, manufactureYear, kmPerLiter, hybrid, engineCC, stands, helmets);

            db.saveBike((Motorbike) bike);
            bikes.clear();
            bikes.addAll(db.getBike());

            for (Motorbike b : bikes) {
                if (b.getPlateNumber().equals(bike.getPlateNumber())) {
                    status = true;
                }
            }
            db.deleteFromDb(bike);
            assertEquals(true,status);
        }

    @Test
    void deleteCheck() {
        String plateNumber = "CAA-0002";                                             //super class of bike and car
        String make = "BMW";
        BigDecimal ratePerDay = BigDecimal.valueOf(3500);
        int manufactureYear = 2017;
        double kmPerLiter = 20;
        boolean hybrid = true;
        int engineCC = 1800;
        int stands = 2;
        int helmets = 2;
        Vehicle bike = new Motorbike(plateNumber, make, ratePerDay, manufactureYear, kmPerLiter, hybrid, engineCC, stands, helmets);

        bikes.clear();
        cars.clear();
        db.saveBike((Motorbike) bike);
        bikes.addAll(db.getBike());
        cars.addAll(db.getCar());
        int i=bikes.size()+cars.size();

        db.deleteFromDb(bike);

        bikes.clear();
        cars.clear();
        bikes.addAll(db.getBike());
        cars.addAll(db.getCar());
        int j=bikes.size()+cars.size();

        assertEquals(i,j+1);



    }



}
