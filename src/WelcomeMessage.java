import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class WelcomeMessage {
    public static void main(String[] args) {
        //creating a Scanner object to read user's input from the console
        Scanner scanner = new Scanner(System.in);

        //prompting the user to input their name
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();


        //initializing the LocalDate variable to null. User's date of birth will be successfully stored once it is successfully parsed.
        LocalDate dob = null;
        //starting the loop that continues until a valid date of birth is provided by the user.
        while (dob == null) {
            //prompting the user to input their date of birth in the format "YYYY-MM-DD"
            System.out.print("Enter your date of birth (YYYY-MM-DD): ");
            String dobString = scanner.nextLine();

            try {
                //creating a DateTimeFormatter with the specified pattern to parse the user's provided date of birth.
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                //attempting to parse the user input into a LocalDate object using the DateTimeFormatter.
                dob = LocalDate.parse(dobString, formatter);
            } catch (Exception e) {
                //if an exception occurs during parsing (e.g. invalid format), it will be caught and displayed as an error message
                System.out.println("Invalid date format. Please use the format YYYY-MM-DD.");
            }
        }

        //prompting the user to input their gender
        System.out.print("Enter your gender: ");
        String gender = scanner.nextLine();

        //closing the scanner to release resources associated with standard input (System.in)
        scanner.close();

        //get the current date using LocalDate
        LocalDate currentDate = LocalDate.now();

        //calculate the age of the user
        int age = currentDate.getYear() - dob.getYear();

        //format the current date using the DateTimeFormatter
        String formattedDate = currentDate.format(DateTimeFormatter.ofPattern("MMMM dd yyyy"));

        System.out.println("Welcome " + name + ", you are " + age + " years old and today's date is " + formattedDate);
    }
}
