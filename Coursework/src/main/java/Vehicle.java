import java.math.BigDecimal;
import java.util.Objects;

public abstract class Vehicle implements Comparable<Vehicle> {                //same structure of a blueprint class
    private String plateNumber;                                             //super class of bike and car
    private String make;
    private BigDecimal ratePerDay;
    private int manufactureYear;
    private double kmPerLiter;
    private boolean hybrid;
    private int engineCC;

    public Vehicle(String plateNumber, String make, BigDecimal ratePerDay, int manufactureYear, double kmPerLiter, boolean hybrid, int engineCC) {
        super();
        setEngineCC(engineCC);
        setHybrid(hybrid);
        setKmPerLiter(kmPerLiter);
        setMake(make);
        setManufactureYear(manufactureYear);
        setPlateNumber(plateNumber);
        setRatePerDay(ratePerDay);
    }

    public Vehicle() {
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getMake() {
        return make;
    }

    public BigDecimal getRatePerDay() {
        return ratePerDay;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public double getKmPerLiter() {
        return kmPerLiter;
    }

    public boolean isHybrid() {
        return hybrid;
    }

    public int getEngineCC() {
        return engineCC;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setRatePerDay(BigDecimal ratePerDay) {
        this.ratePerDay = ratePerDay;
    }

    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public void setKmPerLiter(double kmPerLiter) {
        this.kmPerLiter = kmPerLiter;
    }

    public void setHybrid(boolean hybrid) {
        this.hybrid = hybrid;
    }

    public void setEngineCC(int engineCC) {
        this.engineCC = engineCC;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "plateNumber='" + plateNumber + '\'' +
                ", make='" + make + '\'' +
                ", ratePerDay=" + ratePerDay +
                ", manufactureYear=" + manufactureYear +
                ", kmPerLiter=" + kmPerLiter +
                ", hybrid=" + hybrid +
                ", engineCC=" + engineCC +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return manufactureYear == vehicle.manufactureYear &&
                Double.compare(vehicle.kmPerLiter, kmPerLiter) == 0 &&
                hybrid == vehicle.hybrid &&
                engineCC == vehicle.engineCC &&
                Objects.equals(plateNumber, vehicle.plateNumber) &&
                Objects.equals(make, vehicle.make) &&
                Objects.equals(ratePerDay, vehicle.ratePerDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plateNumber, make, ratePerDay, manufactureYear, kmPerLiter, hybrid, engineCC);
    }

    @Override
    public int compareTo(Vehicle o) {
        return this.getMake().compareTo(o.getMake());
    }
}
