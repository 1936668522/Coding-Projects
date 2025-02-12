/**
 *  @author - Thomas Lee
 * This program is to reverse the digits that user entered.
 */

package assg1_lic20;

import java.util.Scanner;

public class DigitReverse {

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		
		System.out.print("PLease enter a non-negative (-1 to exit): ");
		int nums;
		nums = kbd.nextInt();
		
		
		if(nums == 0)//
		{
			System.out.println("\n" + "Your number printed in reverse order is:");
			System.out.println(digitExtract(nums));
		}
		else if(nums != -1)
		{
			System.out.println("\n" + "Your number printed in reverse order is:");

			while(nums != 0)// if the number is not equal to 0, then continue the loop.
			{
				System.out.println(digitExtract(nums));

				nums = nums /10;//let the number get rid of the last digit and then keep the loop.
			}
		}
		else
		{
			System.exit(-1);
		}
		
		kbd.close();
		
	}
	
	public static int digitExtract(int nums) //the method for reversed number. 
	{
		int reminder; // reversed number.
		
		reminder = nums % 10;
		
		return reminder;
	}
}
