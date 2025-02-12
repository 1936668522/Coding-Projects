/**
 * @author - Thomas Lee
 * This program is to change the date form from month/day/year to day.moth.year
 */


package assg1_lic20;

import java.util.Scanner;

public class DateChange {

	public static void main(String[] args) {
		
		Scanner kbd = new Scanner(System.in);
		String date;
		
		System.out.println("Enter a date in the form month/day/year: ");
		date = kbd.nextLine();

		int number = date.length();// to find the length of the strings.
		int position = date.indexOf("/");//to find the first "/" position.
		int position2 = date.lastIndexOf("/", number);// to find the second "/" position
				
		date = date.substring((position + 1), position2) + "." + date.substring(0, position) + "." + date.substring((position2 +1), number);
		//use first and the second position "/" to change the date.
		
		System.out.println("\n" + "Your date in Europen form is: " + "\n" + date);
		
		kbd.close();
	}

}
