import dev.morphia.annotations.Entity;

import java.math.BigDecimal;
import java.util.Objects;

@Entity("Motorbike")
public final class Motorbike extends Vehicle {
    private int noOfStands;
    private int noOfHelmets;

    public Motorbike(String plateNumber, String make, BigDecimal ratePerDay, int manufactureYear, double kmPerLiter, boolean hybrid, int engineCC, int noOfStands, int noOfHelmets) {
        super(plateNumber, make, ratePerDay, manufactureYear, kmPerLiter, hybrid, engineCC);
        setNoOfHelmets(noOfHelmets);
        setNoOfStands(noOfStands);
    }

    public Motorbike(){}

    public int getNoOfStands() {
        return noOfStands;
    }

    public int getNoOfHelmets() {
        return noOfHelmets;
    }

    public void setNoOfStands(int noOfStands) {
        this.noOfStands = noOfStands;
    }

    public void setNoOfHelmets(int noOfHelmets) {
        this.noOfHelmets = noOfHelmets;
    }

    @Override
    public String toString() {
        return super.toString()+"Motorbike{" +
                "noOfStands=" + noOfStands +
                ", noOfHelmets=" + noOfHelmets +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Motorbike motorbike = (Motorbike) o;
        return noOfStands == motorbike.noOfStands &&
                noOfHelmets == motorbike.noOfHelmets;
    }

    @Override
    public int hashCode() {
        return Objects.hash(noOfStands, noOfHelmets);
    }
}
