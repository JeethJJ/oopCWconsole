import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.List;


public class WestminsterRentalVehicleManager implements RentalVehicleManager {     //all accesses of the manager
    private static final int MAX_SIZE = 50;
    public static List<Vehicle> vehicleLot = new ArrayList<>();        // list of all items
    Database db = new Database();

    public WestminsterRentalVehicleManager() {
        vehicleLot.addAll(db.getBike());
        vehicleLot.addAll(db.getCar());                                 //adding all items from database to the list
    }

    @Override
    public void showMenu() {           //prints all the accesses the manager has to the system
        System.out.println("Welcome to Westminster Rent a Vehicle\n");
        System.out.println("select your purpose");
        System.out.println("1.Add vehicle");
        System.out.println("2.Delete Vehicle");
        System.out.println("3.Print list of vehicles");
        System.out.println("4.Write text document");
        System.out.println("5.Edit details");
        System.out.println("6.Open GUI");
        System.out.println("7.Exit");
    }

    @Override
    public void addVehicle() {                             // adding new objects
        if (vehicleLot.size() < MAX_SIZE) {            // add vehicle only is space available
            Scanner sc = new Scanner(System.in);
            int vehicleType;
            do {
                vehicleType = Validator.intValidator("Select vehicle type\n1.Car\n2.Motor Bike\n>");
                if (vehicleType != 1 && vehicleType != 2) {
                    System.out.println("Invalid Input");
                }
            } while (vehicleType != 1 && vehicleType != 2);

            int plateNumValidator = 0;
            String plateNo;
            do {
                System.out.print("Enter plate number :");
                plateNo = sc.nextLine();
                plateNumValidator = 0;
                for (Vehicle v3 : vehicleLot) {
                    if (plateNo.equals(v3.getPlateNumber())) {
                        plateNumValidator = 1;
                        System.out.println("Plate number already exists. Enter correct number");
                    }
                }
            } while (plateNumValidator == 1);
            System.out.print("Enter make :");
            String make = sc.nextLine();

            int year;
            do {
                year = Validator.intValidator("Enter manufactured year :");
                if (year < 1980 || year > Calendar.getInstance().get(Calendar.YEAR)) {           // assumption : vehicles before 1980 cannot be rented
                    System.out.println("Invalid year!!");
                }
            } while (year < 1980 || year > Calendar.getInstance().get(Calendar.YEAR));

            boolean hybrid;
            char type;
            do {
                System.out.print("Is this vehicle hybrid \n(y)es or (n)o :");
                type = sc.next().toLowerCase().charAt(0);                              // y or n character input
                if (type != 'y' && type != 'n') {
                    System.out.println("Type doesn't match \nEnter again");
                }
                sc.nextLine();
            } while (type != 'y' && type != 'n');
            if (type == 'y') {
                hybrid = true;
            } else {
                hybrid = false;
            }

            int vehicleCC;
            do {
                vehicleCC = Validator.intValidator("Enter vehicle CC :");
                if (vehicleCC < 0) {
                    System.out.println("Invalid Input!!");
                }
            } while (vehicleCC < 0);

            double kmPerLiter;
            do {
                kmPerLiter = Validator.doubleValidator("Enter kilometers per liter :");
                if (kmPerLiter < 0.0) {
                    System.out.println("Invalid Input");
                }
            } while (kmPerLiter < 0.0);

            BigDecimal ratePerDay;
            do {
                ratePerDay = Validator.bigDecimalValidator("Enter rate per day in LKR:");
                if (ratePerDay.compareTo(BigDecimal.ZERO) < 0) {
                    System.out.println("Invalid Amount!!");
                }
            } while (ratePerDay.compareTo(BigDecimal.ZERO) < 0);

            if (vehicleType == 1) {
                int noOfDoors;
                do {
                    noOfDoors = Validator.intValidator("Enter no of doors :");
                    if (noOfDoors < 0) {
                        System.out.println("Invalid Input");
                    }
                } while (noOfDoors < 0);

                int noOfSpareWheels;
                do {
                    noOfSpareWheels = Validator.intValidator("Enter no of spare wheels :");
                    if (noOfSpareWheels < 0) {
                        System.out.println("Invalid Input");
                    }
                } while (noOfSpareWheels < 0);

                Vehicle car = new Car(plateNo, make, ratePerDay, year, kmPerLiter, hybrid, vehicleCC, noOfDoors, noOfSpareWheels);       //creating object
                vehicleLot.add(car);
                System.out.println("Done!!\n\n");
                db.saveVehicle(car);  //adding object to database
            } else {
                int noOfStands;
                do {
                    noOfStands = Validator.intValidator("Enter no of stands installed in the bike :");
                    if (noOfStands < 0) {
                        System.out.println("Invalid Input");
                    }
                } while (noOfStands < 0);

                int noOfHelmets;
                do {
                    noOfHelmets = Validator.intValidator("Enter no of helmets :");
                    if (noOfHelmets < 0) {
                        System.out.println("Invalid Input");
                    }
                } while (noOfHelmets < 0);

                Vehicle motorBike = new Motorbike(plateNo, make, ratePerDay, year, kmPerLiter, hybrid, vehicleCC, noOfStands, noOfHelmets);       //creating object
                vehicleLot.add(motorBike);
                System.out.println("Done!!\n\n");
                db.saveVehicle(motorBike);     //adding object to database
            }
        } else {
            System.out.println("There are 50 vehicles already added. You can't add more...");
        }
    }

    @Override
    public void deleteVehicle() {                             // deleting if existing, if not proper message
        System.out.print("Enter vehicle plate number to delete :");
        Scanner sc = new Scanner(System.in);
        String deleteVehicle = sc.nextLine();

        int finder = 0;
        for (Vehicle v2 : vehicleLot) {
            if (deleteVehicle.equals(v2.getPlateNumber().toString())) {
                System.out.println(v2);
                finder = 1;
                break;
            }
        }
        if (finder == 0) {
            System.out.println("Vehicle not found in the database\n\n");
        } else if (finder == 1) {
            int deleteYN;
            do {
                deleteYN = Validator.intValidator("Confirm deletion\n1.Yes\n2.No\n>");
                if (deleteYN != 1 && deleteYN != 2) {
                    System.out.println("Invalid Input");
                }
            } while (deleteYN != 1 && deleteYN != 2);
            if (deleteYN == 1) {
                for (Vehicle v2 : vehicleLot) {
                    if (deleteVehicle.equals(v2.getPlateNumber().toString())) {
                        db.deleteFromDb(v2);
                        vehicleLot.remove(v2);
                        break;
                    }
                }

                System.out.println("Deleted successfully!!\n\n");
            } else {
                System.out.println("Deletion cancelled!!\n\n");
            }
        }
    }

    @Override
    public void printVehicle() {                                    // print the vehicles plate number and rype sorted according to make
        List<Vehicle> sortedList = new LinkedList(vehicleLot);
        Comparator<Vehicle> v = Comparator.comparing((s) -> {
            return s.getMake();
        });
        sortedList.sort(v);

        System.out.println("|--------------|--------------|");
        System.out.format("%1s%15s%15s%n", "|", "Plate No|", "Vehicle Type|");
        System.out.println("|--------------|--------------|");
        for (Vehicle v2 : sortedList) {
            String type = v2.getClass().toString().split(" ")[1];
            String number = v2.getPlateNumber().toString();
            System.out.format("%1s%15s%15s%n", "|", number + "|", type + "|");
        }
    }

    @Override
    public void writeStockDetails() {                          // Writing all stock details in text file
        File file = new File("Stock details.txt");        //file
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            fw = new FileWriter(file, true);           //append status is true
            pw = new PrintWriter(fw, true);             //auto flush status is true
            pw.println(LocalDateTime.now());            // current date and time to keep track when these data were added
            int counter = 1;
            for (Vehicle v : vehicleLot) {                       // create a loop and through the loop you can iterate through and print them to the file
                pw.println("Vehicle " + counter + ".\n");
                pw.println("Vehicle type :" + v.getClass().toString().split(" ")[1]);
                pw.println("Vehicle plate number :" + v.getPlateNumber());
                pw.println("Vehicle  make :" + v.getMake());
                pw.println("Vehicle manufacture year :" + v.getManufactureYear());
                pw.println("Vehicle kilometers per liter :" + v.getKmPerLiter());
                pw.println("Vehicle CC:" + v.getEngineCC());
                pw.println("Vehicle hybrid status :" + v.isHybrid());
                if (v.getClass().toString().split(" ")[1].equals("Car")) {
                    pw.println("Vehicle no of doors :" + ((Car) v).getNoOfDoors());
                    pw.println("Vehicle no of spare wheels :" + ((Car) v).getNoOfSpareWheels());
                } else {
                    pw.println("Vehicle no of Helmets provided :" + ((Motorbike) v).getNoOfHelmets());
                    pw.println("Vehicle no of stands installed :" + ((Motorbike) v).getNoOfStands());
                }
                pw.println("Vehicle rate per day :" + v.getRatePerDay() + " LKR\n\n");
                counter++;
            }
            pw.println();

            Desktop.getDesktop().open(file);          //auto open the text file which has all the written data
        } catch (IOException e) {
            System.err.println("Error" + e.getMessage());
        } finally {                          //after executing closing all the files
            try {
                fw.close();
                pw.close();
            } catch (IOException e) {
                System.err.println("Error" + e.getMessage());

            }

        }

    }

    @Override
    public void edit() {
        System.out.print("Enter the vehicle plate number you want to edit :");   // user cannot edit all the vehicles, he cah change only certain attributes
        Scanner sc = new Scanner(System.in);
        String editPlateNo = sc.nextLine();
        int count = 1;
        outer:
        for (Vehicle v : vehicleLot) {
            if (editPlateNo.equals(v.getPlateNumber())) {
                db.deleteFromDb(v);
                System.out.println("ONLY CERTAIN ATTRIBUTES CAN BE CHANGED!!!");
                System.out.println("What details would you like to edit:");
                if (v.getClass().toString().split(" ")[1].equals("Car")) {
                    int editOption;
                    do {
                        editOption = Validator.intValidator("1.Rate per day \n2.Km per liter\n3.Number of spare wheel\n>");
                        if (editOption < 1 || editOption > 3) {
                            System.out.println("Invalid Input");
                        }
                    } while (editOption < 1 || editOption > 3);
                    switch (editOption) {
                        case 1:
                            BigDecimal ratePerDay;
                            do {
                                ratePerDay = Validator.bigDecimalValidator("Enter rate per day :");
                                if (ratePerDay.compareTo(BigDecimal.ZERO) < 0) {
                                    System.out.println("Invalid Amount!!");
                                }
                            } while (ratePerDay.compareTo(BigDecimal.ZERO) < 0);
                            v.setRatePerDay(ratePerDay);

                            break;
                        case 2:
                            double kmPerLiter;
                            do {
                                kmPerLiter = Validator.doubleValidator("Enter kilometers per liter :");
                                if (kmPerLiter < 0.0) {
                                    System.out.println("Invalid Input");
                                }
                            } while (kmPerLiter < 0.0);
                            v.setKmPerLiter(kmPerLiter);
                            break;
                        case 3:
                            int noOfSpareWheels;
                            do {
                                noOfSpareWheels = Validator.intValidator("Enter no of spare wheels :");
                                if (noOfSpareWheels < 0) {
                                    System.out.println("Invalid Input");
                                }
                            } while (noOfSpareWheels < 0);
                            ((Car) v).setNoOfSpareWheels(noOfSpareWheels);
                            break;
                    }
                    db.saveCar((Car) v);          // update the edited stuff in the database
                    break outer;
                } else if (v.getClass().toString().split(" ")[1].equals("Motorbike")) {
                    int editOption2;
                    do {
                        editOption2 = Validator.intValidator("1.Rate per day \n2.Km per liter\n3.Number of stands installed\n4.No of helmets provided\n>");
                        if (editOption2 < 1 || editOption2 > 4) {
                            System.out.println("Invalid Input");
                        }
                    } while (editOption2 < 1 || editOption2 > 4);

                    switch (editOption2) {
                        case 1:
                            BigDecimal ratePerDay;
                            do {
                                ratePerDay = Validator.bigDecimalValidator("Enter rate per day :");
                                if (ratePerDay.compareTo(BigDecimal.ZERO) < 0) {
                                    System.out.println("Invalid Amount!!");
                                }
                            } while (ratePerDay.compareTo(BigDecimal.ZERO) < 0);
                            v.setRatePerDay(ratePerDay);

                            break;
                        case 2:
                            double kmPerLiter;
                            do {
                                kmPerLiter = Validator.doubleValidator("Enter kilometers per liter :");
                                if (kmPerLiter < 0.0) {
                                    System.out.println("Invalid Input");
                                }
                            } while (kmPerLiter < 0.0);
                            v.setKmPerLiter(kmPerLiter);
                            break;
                        case 3:
                            int noOfStands;
                            do {
                                noOfStands = Validator.intValidator("Enter no of stands installed in the bike :");
                                if (noOfStands < 0) {
                                    System.out.println("Invalid Input");
                                }
                            } while (noOfStands < 0);
                            ((Motorbike) v).setNoOfStands(noOfStands);
                            break;
                        case 4:
                            int noOfHelmets;
                            do {
                                noOfHelmets = Validator.intValidator("Enter no of helmets :");
                                if (noOfHelmets < 0) {
                                    System.out.println("Invalid Input");
                                }
                            } while (noOfHelmets < 0);
                            ((Motorbike) v).setNoOfHelmets(noOfHelmets);
                            break;
                    }
                    db.saveBike((Motorbike) v);
                    break outer;
                }
            } else if (count == vehicleLot.size()) {
                System.out.println("The plate number that you entered cannot be found.\n");
            }
            count++;
        }
    }

    boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().contains("win");
    }

    String npm = isWindows() ? "npm.cmd" : "npm";

    @Override
    public void openElectron() throws IOException {                 //this is the method to open the electron application
        File file = new File("VehicleRentalStore");       //basically this will execute this command inside that directory
        Process p = new ProcessBuilder(npm, "run", "electron-build").directory(file).start();
    }
}
