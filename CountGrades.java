/**
 * @author - Thomas Lee
 * This program is to count the grades that's above average grade.
 */

package assg1_lic20;

import java.util.Scanner;

public class CountGrades {

	public static void main(String[] args) {

		Scanner kbd = new Scanner(System.in);

		System.out.print("Please enter the number of grades: ");

		int numOfGrades;
		numOfGrades = kbd.nextInt();

		System.out.print("\n");

		double sum = 0; // for average purpose.

		if (numOfGrades > 0) {
			int[] sizeOfGrades = new int[numOfGrades];// array for size of numOfGrades
			for (int i = 0; i + 1 <= numOfGrades; i++) {
				System.out.print("Enter a grade: ");
				sizeOfGrades[i] = kbd.nextInt();

				sum = sum + sizeOfGrades[i];
			}

			double average = sum / numOfGrades;

			System.out.println("\n" + "The average grade is: " + average);

			System.out.println("\n" + "The grades above the average grade are/is: ");

			int num = 0;// for the number of grades that are above the average
			for (int i = 0; i + 1 <= numOfGrades; i++) {
				if (sizeOfGrades[i] > average) {
					System.out.println(sizeOfGrades[i]);
					num++;
				}
			}

			System.out.print("for a total of " + (num) + " grades/grade");
		} else {
			System.out.println("Sorry the number you enter won't work.");
			System.exit(0);
		}

		kbd.close();

	}

}
