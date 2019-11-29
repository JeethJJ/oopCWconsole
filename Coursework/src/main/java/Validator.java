import java.math.BigDecimal;
import java.util.Scanner;

public class Validator {

    public static int intValidator(String question) {
        System.out.print(question);     //prompting the question
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextInt()) {           //validating int until proper input
            System.out.print("Invalid input.\nPlease enter a valid number\n>");
            sc.next();
        }
        int userInputInt = sc.nextInt();
        sc.nextLine();   //to remove skipping errors (https://www.youtube.com/watch?v=R2ZB-Ye6GEo)
        return userInputInt;
    }

    public static double doubleValidator(String question) {
        System.out.print(question);
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextDouble()) {           //validating double until proper input
            System.out.print("Invalid input.\nPlease enter a valid number\n>");
            sc.next();
        }
        double userInputDouble = sc.nextDouble();
        sc.nextLine();   //to remove skipping errors (https://www.youtube.com/watch?v=R2ZB-Ye6GEo)
        return userInputDouble;
    }

    public static BigDecimal bigDecimalValidator(String question) {   // to validate the big decimal input for rate
        System.out.print(question);
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextBigDecimal()) {
            System.out.print("Invalid amount\nPlease enter correct amount\n>");
            sc.next();
        }
        BigDecimal userInputBigDecimal = sc.nextBigDecimal();
        sc.nextLine();
        return userInputBigDecimal;
    }
}
