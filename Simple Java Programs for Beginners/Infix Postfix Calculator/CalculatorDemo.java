/**
 * @author - Thomas D. Lee
 * this is main class of Calculator that allows user to enter infix expression and 
 * change it to posfix expression
 */

package assg7_lic20;

import java.util.*;

public class CalculatorDemo {

	public static void main(String[] args) 
	{
		
		Scanner kbd = new Scanner(System.in);
			
		String formula;
		
		while(true)
		{
			//ask user to enter the infix formula and continue until they decided to exit
			System.out.println("Please enter an infix expression (e to exit)");
			formula = kbd.nextLine();
			
			if(formula.equalsIgnoreCase("e"))
			{
				System.out.println("You're exited from system");
				System.exit(0);
				break;
			}
			
			Calculator calculator = new Calculator(formula);

			//test toString method
			System.out.println("The infix expression you entered is: " + calculator.toString());
			//test getPostfix method
			System.out.println("The postfix expression of your infix expression is: " + calculator.getPostfix());
			//test evaluate method.
			System.out.println("The result is: " + calculator.evaluate());
		}
		
		kbd.close();

	}

}

