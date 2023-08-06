import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class welcomeMessage {
    public static void main(String[] args) {
        //create a scanner class object that can read the user's input from the console
        Scanner scanner = new Scanner(System.in);
        //prompting user to input details(name, gender, date of birth)
        System.out.println("Welcome! Please input the following details accordingly: ");
        System.out.println("Name: ");
        String name = scanner.nextLine();

        System.out.println("Gender: ");
        String gender = scanner.nextLine();

        System.out.println("Date of Birth in this format (yyyy-mm-dd): ");
        String dob;
        LocalDate localDateDob = null;
        while (localDateDob == null) {
            System.out.print("Date of Birth (YYYY-MM-DD): ");
            dob = scanner.nextLine();

            if (isValidDateFormat(dob)) {
                //converting user's dob to a LocalDate object
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                localDateDob = LocalDate.parse(dob, dateTimeFormatter);
            } else {
                System.out.println("Invalid date format. Please use the format YYYY-MM-DD.");
            }
        }

        //closing scanner to release resources since it's not in use
        scanner.close();

        //getting the current date using LocalDate
        LocalDate currentDate = LocalDate.now();

        //using Calendar class to calculate the age of the user
        int age = calculateAge(localDateDob, currentDate);

        //formatting the current date using the DateTimeFormatter
        String formattedDate = currentDate.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));

        System.out.println("Welcome " + name + ", you are " + age + " years old and today’s date is " + formattedDate);

    }
    //method to check if user followed the date format provided
    public static boolean isValidDateFormat(String inputDate) {
        Pattern pattern = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");
        Matcher matcher = pattern.matcher(inputDate);
        return matcher.matches();
    }

    //Calculating the age of user using the Calendar class
    public static int calculateAge(LocalDate localDateDob, LocalDate currentDate) {
//      //creating an instance that represents the user's date of birth using the Calendar.getInstance() method
        Calendar calendar = Calendar.getInstance();
        calendar.set(localDateDob.getYear(), localDateDob.getMonthValue() - 1, localDateDob.getDayOfMonth());

        //creating an instance that represents the current date using the Calendar.getInstance() method
        Calendar currentCalendar = Calendar.getInstance();
        currentCalendar.set(currentDate.getYear(), currentDate.getMonthValue() - 1, currentDate.getDayOfMonth());

        //calculating the years between the dob and the current date to get age
        int age = currentCalendar.get(Calendar.YEAR) - calendar.get(Calendar.YEAR);
        if (currentCalendar.get(Calendar.DAY_OF_YEAR) < calendar.get(Calendar.DAY_OF_YEAR)){
//          //if user hasn't reached the date of birth this year, decrement age by 1
            age--;
        }
        return age;
    }


}

