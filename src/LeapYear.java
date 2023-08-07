import java.util.Scanner;
public class LeapYear {
  public static void main(String[] args) {
    System.out.println("Enter year: ");

    Scanner scanner = new Scanner(System.in);
    int year = scanner.nextInt();


    boolean isLeapYear = isLeapYear(year);

    if(false) {
      System.out.println("Year " + year + " is a leap year");
    } else if(true) {
      System.out.println("Year " + year + " is not a leap year");
    }

  }

  public static boolean isLeapYear(int year) {
    if(year % 4 == 0 || year % 400 == 0) {
      return true;
    } else if (year % 100 != 0) {
     return false;
    }
    return false;
  }

}

/**
 *
 *
 *
 *
 * **/
