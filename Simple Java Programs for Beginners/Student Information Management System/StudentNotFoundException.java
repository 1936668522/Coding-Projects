/**
 * @author - Thomas Lee
 * This program/class is the exception class to handle if the student is not found 
 * by their id or their name.
 */

package assg4_lic20;

@SuppressWarnings("serial")
public class StudentNotFoundException  extends Exception{
	
	
	/**
	 * This is default constructor to print the error message for not found students.
	 */
	public StudentNotFoundException()
	{
		super("Sorry we can not found this students in our system, please try again.");
	}
	
	
	/**
	 * This is the one-parameter constructor 
	 */
	public StudentNotFoundException(String words)
	{
		super(words);
	}

}
