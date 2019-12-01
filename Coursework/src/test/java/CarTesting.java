import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTesting {
     String plateNumber = "CAA-3045";                                             //super class of bike and car
     String make = "BMW";
     BigDecimal ratePerDay = BigDecimal.valueOf(3500);
     int manufactureYear = 2017;
     double kmPerLiter = 20;
     boolean hybrid = true;
     int engineCC = 1800;
     int noOfDoors = 3;
     int noOfSpareWheels = 1;
    Vehicle car = new Car(plateNumber,make,ratePerDay,manufactureYear,kmPerLiter,hybrid,engineCC,noOfDoors,noOfSpareWheels);

    @Test
    void checkCarNumber(){
        assertEquals(plateNumber,car.getPlateNumber(),"Should return the same plate number");
    }
    @Test
    void checkCarMake(){
        assertEquals(make,car.getMake(),"Should return the same make");
    }
    @Test
    void checkCarRate(){
        assertEquals(ratePerDay,car.getRatePerDay(),"Should return the same rate per day");
    }
    @Test
    void checkCarKmPerLiter(){
        assertEquals(kmPerLiter,car.getKmPerLiter(),"Should return the same km per liter");
    }
    @Test
    void checkCarHybrid(){
        assertEquals(hybrid,car.isHybrid(),"Should return the same hybrid status");
    }
    @Test
    void checkCarCC(){
        assertEquals(engineCC,car.getEngineCC(),"Should return the same ccr");
    }
    @Test
    void checkCarDoors(){
        assertEquals(noOfDoors,((Car)car).getNoOfDoors(),"Should return the same door count");
    }
    @Test
    void checkCarWheels(){
        assertEquals(noOfSpareWheels,((Car)car).getNoOfSpareWheels(),"Should return the same spare wheel count");
    }
    @Test
    void checkCarYear(){
        assertEquals(manufactureYear,car.getManufactureYear(),"Should return the same manufacture year");
    }
}
