import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
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

        System.out.println("Date of Birth in this format (YYYY-MM-DD): ");
        String dob = scanner.nextLine();

        //converting user's dob to a LocalDate object
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDateDob = LocalDate.parse(dob, dateTimeFormatter);

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

    //Calculating the age of user using the Calendar class

    public static int calculateAge(LocalDate localDateDob, LocalDate currentDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(localDateDob.getYear(), localDateDob.getMonthValue() - 1, localDateDob.getDayOfMonth());

        Calendar currentCalendar = Calendar.getInstance();
        currentCalendar.set(currentDate.getYear(), currentDate.getMonthValue() - 1, currentDate.getDayOfMonth());

        int age = currentCalendar.get(Calendar.YEAR) - calendar.get(Calendar.YEAR);
        if (currentCalendar.get(Calendar.DAY_OF_YEAR) < calendar.get(Calendar.DAY_OF_YEAR)){
            age--;
        }
        return age;
    }


}

