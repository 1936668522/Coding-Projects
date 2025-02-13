/**
 * @author - Thomas Lee
 * This program is to let user choose either test two or three parameter substring recursive
 */

package assg5_lic20;

import java.util.*;

public class RecursionTest
{

	public static void main(String[] args) 
	{

		Scanner input = new Scanner(System.in);
		String word; //The words that user will enter.

		int choice; //options for user to choose.
		int begIndex; // the first index.
		int lastIndex; // second index.
		
		while(true)
		{
			//Ask user to choose the options and enter the word.
			System.out.println("Please chose the options below:");
			System.out.println("1. Test two-parameter substringRecursive method ");
			System.out.println("2. Test three-parameter substringRecursive method ");
			System.out.println("3. Exit ");
			
			choice = input.nextInt();
			input.nextLine(); //in order for user to enter nextLine for word.
			
			if(choice == 3) //if user choose 3 then exit the system.
			{
				System.out.println("You're exit out the system.");
				System.exit(1);
				break;
			}
			
			switch(choice)
			{
			case 1: 
				//ask user to enter a word 
				System.out.println("Please enter a word: ");
				word = input.nextLine();
				
				//ask user to enter the first index.
				System.out.println("Please choose the beginning index: ");
				begIndex = input.nextInt();
				
				//call substringRecursive.
				System.out.println(substringRecursive(word, begIndex));
				break;
			case 2:
				//ask user to enter a word
				System.out.println("Please enter a word: ");
				word = input.nextLine();
				
				//ask user to enter the first index
				System.out.println("Please choose the beginning index: ");
				begIndex = input.nextInt();
				
				//ask user to enter the second index.
				System.out.println("Please choose the ending index: ");
				lastIndex = input.nextInt();
				
				//call second substringRecursive.
				System.out.println(substringRecursive(word,begIndex,lastIndex));
				break;
			}	
		}
		input.close();
	}
	
	
	/**
	 * This method is for two-parameter substringRecursive.
	 * @param str the word that user entered
	 * @param index first index that user enter
	 * @return shows the substring of first index.
	 */
	public static String substringRecursive(String str, int index)
	{
		if(str.equals("") || str == null)
		{
			return str;
		}
		else if(index >= str.length())// if the index number bigger than words length. It will return ""
		{
			return "";
		}
		//return the the substring after the index that user entered.
		return str.charAt(index) + substringRecursive(str, index+1 );
	}
	
	/**
	 * This method is for three-parameter substringRecursive.
	 * @param str the word that user entered.
	 * @param  first index that user entered
	 * @param second index that user entered.
	 * @return the substring between first and the second index but exclude the second index.
	 */
	public static String substringRecursive(String str, int index, int secIndex)
	{
		if(str.equals("") || str == null)
		{
			return str;
		}
		else if(index >= str.length() || index == secIndex)//when index == secIndex, it will stop showing the letters after second index
		{
			return "";
		}
		else if (secIndex < index)
		{
			return "";
		}
		//return the substring between the first and second index.
		return str.charAt(index) + substringRecursive(str, index+1, secIndex);
	}

	
}
