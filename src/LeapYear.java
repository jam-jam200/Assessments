import java.util.Scanner;
public class LeapYear {
    public static void main(String[] args) {
        //create a scanner class object that can read the user's input from the console
        Scanner scanner = new Scanner(System.in);

        //prompting user to enter year
        System.out.print("Enter a year: ");
        int year = scanner.nextInt();

        //checking if the year is a leap year using the isLeapYear method
        boolean isLeapYear = isLeapYear(year);

        //displaying the result to the user
        if (isLeapYear) {
            System.out.println(year + " is a leap year.");
        } else {
            System.out.println("sorry, " + year + " is not a leap year.");
        }
        //closing the scanner to release resources associated with standard input (System.in)
        scanner.close();
    }

    //method to check if the given year is a leap year.
    public static boolean isLeapYear(int year) {
        // A leap year is either divisible by 4 but not divisible by 100 or it is divisible by 400.
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
