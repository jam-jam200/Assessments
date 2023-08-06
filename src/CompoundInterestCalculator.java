import java.util.Scanner;

public class CompoundInterestCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //prompting user to enter principal amount
        double principal = getUserInputDouble(scanner, "Enter the principal amount: ");

        //prompting user to enter interest rate
        double rate = getUserInputDouble(scanner, "Enter the interest rate in percentage: ");

        //prompting user to enter the time
        double time = getUserInputDouble(scanner, "Enter the time time: ");

        String unit;
        //validating the time unit inputted by the user using a do-while loop
        do {
            unit = getUserInputString(scanner, "Enter the time unit in either years, days, or months): ");
        } while (!isValidTimeUnit(unit));

        //calculating the compound interest based on the user's input
        double compoundInterest = calculateCompoundInterest(principal, rate, time, unit);

        System.out.println("The compound interest is: " + compoundInterest);

        //closing the scanner to release resources associated with standard input (System.in)
        scanner.close();
    }

    //prompts user to enter a double value and validates the input
    public static double getUserInputDouble(Scanner scanner, String prompt) {
        System.out.print(prompt);
        //keep prompting the user until a valid double value is provided
        while (!scanner.hasNextDouble()) {
            //if the user enters an invalid value an error message will be displayed
            System.out.print("Invalid input. Please enter a numeric value: ");
            scanner.next();
        }
        //proceeding with the validated number(valid number)
        return scanner.nextDouble();
    }

    //method to get user input for the time unit
    public static String getUserInputString(Scanner scanner, String prompt) {
        System.out.print(prompt);
        //returns the user's input as a lowercase string.
        return scanner.next().toLowerCase();
    }

    //method to validate the time unit input
    public static boolean isValidTimeUnit(String timeUnit) {
        // return true if the time unit is valid either "years", "days", or "months" otherwise false
        return timeUnit.equals("years") || timeUnit.equals("days") || timeUnit.equals("months");
    }

    //method to calculate the compound interest
    public static double calculateCompoundInterest(double principal, double rate, double time, String unit) {
         //number of times the interest is compounded per time unit
         double n;

        // Convert time to years for calculation
        switch (unit) {
            case "days" -> {
                n = 365.0;
                time /= 365.0;
            }
            case "months" -> {
                n = 12.0;
                time /= 12.0;
            }
            default -> n = 1.0;
        }

        // Calculate compound interest using the formula A = P(1 + r/n)^(nt)
        double amount = principal * Math.pow(1 + (rate / (100 * n)), n * time);
        return amount - principal;
    }
}
