import dev.morphia.annotations.Entity;

import java.math.BigDecimal;
import java.util.Objects;

@Entity("Car")      //create a car collection in mongo when a instance of this class is added to thr database
public final class Car extends Vehicle {     //same structure of a blueprint class
    private int noOfDoors;
    private int noOfSpareWheels;

    public Car(String plateNumber, String make, BigDecimal ratePerDay, int manufactureYear, double kmPerLiter, boolean hybrid, int engineCC, int noOfDoors, int noOfSpareWheels){
        super(plateNumber, make, ratePerDay, manufactureYear, kmPerLiter, hybrid, engineCC);
        setNoOfDoors(noOfDoors);
        setNoOfSpareWheels(noOfSpareWheels);
    }

    public Car(){}

    public int getNoOfDoors() {
        return noOfDoors;
    }

    public int getNoOfSpareWheels() {
        return noOfSpareWheels;
    }

    public void setNoOfDoors(int noOfDoors) {
        this.noOfDoors = noOfDoors;
    }

    public void setNoOfSpareWheels(int noOfSpareWheels) {
        this.noOfSpareWheels = noOfSpareWheels;
    }

    @Override
    public String toString() {
        return super.toString()+"Car{" +
                "noOfDoors=" + noOfDoors +
                ", noOfSpareWheels=" + noOfSpareWheels +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return noOfDoors == car.noOfDoors &&
                noOfSpareWheels == car.noOfSpareWheels;
    }

    @Override
    public int hashCode() {
        return Objects.hash(noOfDoors, noOfSpareWheels);
    }
}
