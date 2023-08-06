import java.util.Scanner;
public class LeapYear {
    public static void main(String[] args) {
        //create a scanner class object that can read the user's input from the console
        Scanner scanner = new Scanner(System.in);

        //prompting user to enter year
        System.out.print("Enter a year: ");
        int year = scanner.nextInt();

        // Check if the year is a leap year using the isLeapYear method
        boolean isLeapYear = isLeapYear(year);

        // Display the result to the user
        if (isLeapYear) {
            System.out.println(year + " is a leap year.");
        } else {
            System.out.println(year + " is not a leap year.");
        }

        scanner.close();
    }

    /**
     * Check if the given year is a leap year.
     *
     * @param year The year to be checked.
     * @return true if the year is a leap year, false otherwise.
     */
    public static boolean isLeapYear(int year) {
        // A leap year is either divisible by 4 but not divisible by 100,
        // or it is divisible by 400.
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
