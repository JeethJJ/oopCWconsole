import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BikeTesting {
    String plateNumber = "CAA-3045";                                             //super class of bike and Bike
    String make = "BMW";
    BigDecimal ratePerDay = BigDecimal.valueOf(3500);
    int manufactureYear = 2017;
    double kmPerLiter = 20;
    boolean hybrid = true;
    int engineCC = 1800;
    int noOfStands = 2;
    int noOfHelmets = 3;
    Vehicle bike = new Motorbike(plateNumber,make,ratePerDay,manufactureYear,kmPerLiter,hybrid,engineCC,noOfStands,noOfHelmets);

    @Test
    void checkBikeNumber(){
        assertEquals(plateNumber,bike.getPlateNumber(),"Should return the same plate number");
    }
    @Test
    void checkBikeMake(){
        assertEquals(make,bike.getMake(),"Should return the same make");
    }
    @Test
    void checkBikeRate(){
        assertEquals(ratePerDay,bike.getRatePerDay(),"Should return the same rate per day");
    }
    @Test
    void checkBikeKmPerLiter(){
        assertEquals(kmPerLiter,bike.getKmPerLiter(),"Should return the same km per liter");
    }
    @Test
    void checkBikeHybrid(){
        assertEquals(hybrid,bike.isHybrid(),"Should return the same hybrid status");
    }
    @Test
    void checkBikeCC(){
        assertEquals(engineCC,bike.getEngineCC(),"Should return the same ccr");
    }
    @Test
    void checkBikeStands(){
        assertEquals(noOfStands,((Motorbike)bike).getNoOfStands(),"Should return the same stand count");
    }
    @Test
    void checkBikeWheels(){
        assertEquals(noOfHelmets,((Motorbike)bike).getNoOfHelmets(),"Should return the same helmet count");
    }
    @Test
    void checkBikeYear(){
        assertEquals(manufactureYear,bike.getManufactureYear(),"Should return the same manufacture year");
    }
}

