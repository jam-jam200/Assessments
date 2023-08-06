import java.util.Scanner;

public class CompoundInterestCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter principal amount
        double principal = getUserInputDouble(scanner, "Enter the principal amount: ");

        // Prompt the user to enter the interest rate
        double rate = getUserInputDouble(scanner, "Enter the annual interest rate (in percentage): ");

        // Prompt the user to enter the time
        double time = getUserInputDouble(scanner, "Enter the time: ");

        // Prompt the user to enter the time unit (years, days, or months)
        String timeUnit = getUserInputString(scanner, "Enter the time unit (years, days, or months): ");

        // Calculate the compound interest based on the user's input
        double compoundInterest = calculateCompoundInterest(principal, rate, time, timeUnit);

        // Display the compound interest to the user
        System.out.println("The compound interest is: " + compoundInterest);

        scanner.close();
    }

    public static double getUserInputDouble(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Please enter a numeric value: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    public static String getUserInputString(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.next().toLowerCase();
    }

    public static double calculateCompoundInterest(double principal, double rate, double time, String timeUnit) {
        double n; // number of times the interest is compounded per time unit

        // Convert time to years for calculation
        switch (timeUnit) {
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
