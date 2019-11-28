public class ConsoleApp {
    public static void main(String[] args) {


        WestminsterRentalVehicleManager westminsterRentalVehicleManager=new WestminsterRentalVehicleManager();      // creating object of westminster

        int option;
        do{                                      //iterate till user exit
            westminsterRentalVehicleManager.showMenu();
            do {
                option = Validator.intValidator(">");
                if(option<1 || option>6){
                    System.out.println("Invalid selection");
                }
            }while (option<1 || option>6);

            switch (option){
                case 1:
                    westminsterRentalVehicleManager.addVehicle();
                    break;
                case 2:
                    westminsterRentalVehicleManager.deleteVehicle();
                    break;
                case 3:
                    westminsterRentalVehicleManager.printVehicle();
                    break;
                case 4:
                    westminsterRentalVehicleManager.writeStockDetails();
                    break;
                case 5:
                    westminsterRentalVehicleManager.edit();
                    break;

            }
        }while (option!=6);

    }


}
