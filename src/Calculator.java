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
        //validating user's input
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

    //method to convert user input and round up to 2 decimal points
    public static void conversionAndRoundInput(Scanner scanner) {
        System.out.print("Enter a number: ");
        //validating user's input
        double num = validateInput(scanner);

        //rounding the num to 2 decimal places
        double roundedNum = Math.round(num * 100.0) / 100.0;
        System.out.println("Rounded to 2 decimal points: " + roundedNum);
    }

    //method to validate user's input
    public static double validateInput(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            //if the user enters a non-numeric value or invalid value an error message will be displayed
            System.out.print("Invalid input. Please enter a valid number: ");
            scanner.next();
        }

        //proceeding with the validated number(valid numeric value)
        return scanner.nextDouble();
    }

    //method to calculate the sum, average, minimum, maximum and square root of maximum value of 5 values
    public static void validateAndDisplayValues(Scanner scanner) {
        double[] values = new double[5];

        System.out.println("Enter 5 numeric values:");

        // Accepting user input for 5 values and storing them in an array
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter value " + (i + 1) + ": ");
            values[i] = validateInput(scanner);
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
