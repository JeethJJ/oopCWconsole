import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;

public class Schedule {     //schedule class is created prior to the requests of the coursework, but gor the spring backend this is not suitable
    private LocalDate pickUpDate;
    private LocalDate dropOffDate;

    //so a new scheduling class is created in the spring project
    public Schedule(LocalDate pickUpDate, LocalDate dropOffDate) {
        this.pickUpDate = pickUpDate;
        this.dropOffDate = dropOffDate;
    }

    public LocalDate getPickUpDate() {
        return pickUpDate;
    }

    public LocalDate getDropOffDate() {
        return dropOffDate;
    }

    public void setPickUpDate(LocalDate pickUpDate) throws IllegalAccessException {
        if (pickUpDate.isAfter(LocalDate.now())) {
            this.pickUpDate = pickUpDate;
        } else {
            throw new IllegalAccessException("Date already past or current date cannot be used");
        }
    }

    public void setDropOffDate(LocalDate dropOffDate) throws IllegalAccessException {
        if (dropOffDate.isAfter(pickUpDate)) {
            this.dropOffDate = dropOffDate;
        } else {
            throw new IllegalAccessException("Date should be after pick up date");
        }
    }

    public long getNoOfDays() {
        return DAYS.between(pickUpDate, dropOffDate);
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "pickUpDate=" + pickUpDate +
                ", dropOffDate=" + dropOffDate +
                '}';
    }
}

