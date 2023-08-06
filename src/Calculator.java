import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            //displaying user's options
            System.out.println("Please select an option:");
            System.out.println("1. Calculate the sum of 2 whole numbers");
            System.out.println("2. Convert input and round up to 2 decimal points");
            System.out.println("3. Input 5 values and calculate the sum, average value, maximum and minimum number, and square root of maximum number");
            System.out.println("0. Exit");

            //reading the user's option from the console
            option = scanner.nextInt();

            //performing the corresponding action based on the selected option
            switch (option) {
                case 1 -> sumOfTwoNumbers(scanner);
                case 2 -> conversionAndRoundInput(scanner);
                case 3 -> validateAndDisplayValues(scanner);
                case 0 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid option. Please try again.");
            }
        } while (option != 0);

        scanner.close();
    }

    //method to calculate the sum of 2 whole numbers
    public static void sumOfTwoNumbers(Scanner scanner) {
        System.out.print("Enter the first whole number: ");
        int num1 = validateWholeNumberInput(scanner);
        System.out.print("Enter the second whole number: ");
        int num2 = validateWholeNumberInput(scanner);

        int sum = num1 + num2;
        System.out.println("The sum of " + num1 + " and " + num2 + " is: " + sum);
    }

    //method to validate whole number input from the user
    public static int validateWholeNumberInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            // If the user enters a non-integer value, display an error message
            System.out.print("Invalid input. Please enter a whole number: ");

            // Clear the non-integer input from the scanner's buffer
            scanner.next();
        }

       //proceeding with the validated number(whole number)
        return scanner.nextInt();
    }

    //method to convert user input and round to 2 decimal points
    public static void conversionAndRoundInput(Scanner scanner) {
        System.out.print("Enter a number: ");
        double number = validateDoubleInput(scanner);

        double rounded = Math.round(number * 100.0) / 100.0;
        System.out.println("Rounded to 2 decimal points: " + rounded);
    }

    // Method to validate double input
    public static double validateDoubleInput(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            // If the user enters a non-numeric value, display an error message
            System.out.print("Invalid input. Please enter a valid number: ");

            // Clear the non-numeric input from the scanner's buffer
            scanner.next();
        }

        // If the loop exits, it means the user has entered a valid number, so we return it
        return scanner.nextDouble();
    }

    // Method 3: Accept 5 values and display various calculations
    public static void validateAndDisplayValues(Scanner scanner) {
        double[] values = new double[5];

        System.out.println("Enter 5 numeric values:");

        // Accepting user input for 5 values and storing them in an array
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter value " + (i + 1) + ": ");
            values[i] = validateDoubleInput(scanner);
        }

        double sum = 0;
        double min = values[0];
        double max = values[0];
        double sqrtMax = Math.sqrt(values[0]);

        // Calculating sum, minimum, maximum, and the square root of the maximum value
        for (double value : values) {
            sum += value;
            if (value < min) {
                min = value;
            }
            if (value > max) {
                max = value;
                sqrtMax = Math.sqrt(max);
            }
        }

        double average = sum / values.length;

        // Displaying the calculated values to the user
        System.out.println("Sum of all values: " + sum);
        System.out.println("Average value: " + average);
        System.out.println("Minimum value: " + min);
        System.out.println("Maximum value: " + max);
        System.out.println("Square root of the maximum value: " + sqrtMax);
    }
}
