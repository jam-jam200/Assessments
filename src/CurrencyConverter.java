import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //defining the conversion rates for different currencies relative to USD(US dollar)
        Map<String, Double> conversionRates = createConversionRates();

        //displaying available currencies for conversion
        displayAvailableCurrencies(conversionRates);

        //exit the loop if the user doesn't want to continue
        do {
            double amountUSD = getValidAmountUSD(scanner);

            String targetCurrency = getValidTargetCurrency(scanner, conversionRates);

            double convertedAmount = convertCurrency(amountUSD, targetCurrency, conversionRates);

            /** displaying the conversion results in a well-formatted manner using printf.
            The "%.2f" placeholder is used to display floating-point numbers with two decimal places,
            ensuring precision in the currency amounts. The "%s" placeholder is used for the target
            currency, which is displayed as a string. This approach provides a clear and organized
            representation of the conversion results for the user.
             **/
            System.out.printf("%.2f USD is equal to %.2f %s\n", amountUSD, convertedAmount, targetCurrency);

            //asking the user if they want to continue converting
        } while (askForContinuation(scanner));

        System.out.println("Thank you for using the currency converter!");

        //closing the scanner to release resources associated with standard input (System.in)
        scanner.close();
    }

    //method to create and initialize the conversion rates for different currencies
    public static Map<String, Double> createConversionRates() {
        Map<String, Double> conversionRates = new HashMap<>();
        conversionRates.put("USD", 1.0);
        conversionRates.put("EUR", 0.85);
        conversionRates.put("GBP", 0.73);
        conversionRates.put("JPY", 110.89);
        // Add more currencies and their conversion rates as needed
        return conversionRates;
    }

    // Method to display the available currencies for conversion
    public static void displayAvailableCurrencies(Map<String, Double> conversionRates) {
        System.out.println("Available Currencies for Conversion:");
        for (String currency : conversionRates.keySet()) {
            System.out.println(currency);
        }
    }

    // Method to get valid user input for the amount in USD
    public static double getValidAmountUSD(Scanner scanner) {
        double amountUSD;
        while (true) {
            System.out.print("\nEnter the amount in USD: ");
            if (scanner.hasNextDouble()) {
                amountUSD = scanner.nextDouble();
                break;
            } else {
                System.out.print("Invalid input. Please enter a numeric value: ");
                scanner.next();
            }
        }
        return amountUSD;
    }

    // Method to get valid user input for the target currency
    public static String getValidTargetCurrency(Scanner scanner, Map<String, Double> conversionRates) {
        String targetCurrency;
        while (true) {
            System.out.print("Enter the target currency: ");
            targetCurrency = scanner.next().toUpperCase();
            if (conversionRates.containsKey(targetCurrency)) {
                break;
            } else {
                System.out.print("Invalid target currency. Please try again: ");
            }
        }
        return targetCurrency;
    }

    // Method to convert the amount from USD to the target currency
    public static double convertCurrency(double amountUSD, String targetCurrency, Map<String, Double> conversionRates) {
        double conversionRate = conversionRates.get(targetCurrency);
        return amountUSD * conversionRate;
    }

    // Method to ask the user if they want to continue converting
    public static boolean askForContinuation(Scanner scanner) {
        while (true) {
            System.out.print("Do you want to convert again? (yes/no): ");
            String continueOption = scanner.next().toLowerCase();
            if (continueOption.equals("yes")) {
                return true;
            } else if (continueOption.equals("no")) {
                return false;
            } else {
                System.out.print("Invalid input. Please enter 'yes' or 'no': ");
            }
        }
    }
}
