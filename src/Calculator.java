import java.util.Arrays;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            // Displaying options for users
            System.out.println("Please select an option from the list below:");
            System.out.println("1. Calculate the sum of 2 whole numbers");
            System.out.println("2. Convert input and round up to 2 decimal points");
            System.out.println("3. Enter 5 values to calculate the sum, average value, minimum value, maximum value  and square root of maximum value of inputted values");
            System.out.println("0. Exit");

            //reading user's input from the console
            option = scanner.nextInt();

            switch (option) {
                case 1 -> calculateSumOfTwoNumbers(scanner);
                case 2 -> performOperation(scanner, "Enter a number: ", (double a) -> Math.round(a * 100.0) / 100.0);
                case 3 -> performMultipleOperations(scanner);
                case 0 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid option. Please select a valid option (1, 2, 3, or 0 to exit).");
            }
        } while (option != 0);

        //closing scanner to release resources since it's not in use
        scanner.close();
    }

    // Method to calculate the sum of 2 whole numbers
    public static void calculateSumOfTwoNumbers(Scanner scanner) {
        int num1, num2;

        // Prompting user to enter the first whole number
        do {
            System.out.print("Enter the first whole number: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.next();
            }
            num1 = scanner.nextInt();
        } while (num1 < Integer.MIN_VALUE || num1 > Integer.MAX_VALUE);

        // Prompting user to enter the second whole number
        do {
            System.out.print("Enter the second whole number: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.next();
            }
            num2 = scanner.nextInt();
        } while (num2 < Integer.MIN_VALUE || num2 > Integer.MAX_VALUE);

        int sum = num1 + num2;
        System.out.println("The sum of " + num1 + " and " + num2 + " is: " + sum);
    }

    // Method to perform binary operations (e.g., sum)
    public static void performOperation(Scanner scanner, String prompt1, BinaryOperation operation) {
        System.out.print(prompt1);
        double num1 = scanner.nextDouble();

        double result = operation.calculate(num1);
        System.out.println("Result: " + result);
    }

    // Functional interface for binary operations
    @FunctionalInterface
    interface BinaryOperation {
        double calculate(double a);
    }

    // Method to accept 5 values and display various calculations
    public static void performMultipleOperations(Scanner scanner) {
        double[] values = new double[5];

        // Accepting user input for 5 values and storing them in an array
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter value " + (i + 1) + ": ");
            values[i] = scanner.nextDouble();
        }

        // Using Java 8 Stream API to perform calculations
        double sum = Arrays.stream(values).sum();
        double average = Arrays.stream(values).average().orElse(0);
        double min = Arrays.stream(values).min().orElse(0);
        double max = Arrays.stream(values).max().orElse(0);
        double sqrtMax = Math.sqrt(max);

        // Displaying the calculated values to the user
        System.out.println("Sum of all values: " + sum);
        System.out.println("Average value: " + average);
        System.out.println("Minimum value: " + min);
        System.out.println("Maximum value: " + max);
        System.out.println("Square root of the maximum value: " + sqrtMax);
    }
}
