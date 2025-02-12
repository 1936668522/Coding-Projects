/**
 * @author - Thomas Lee
 * This program/class is to contain and modify the student's informations
 *
 */

package assg4_lic20;

import java.util.Scanner;

public class Student {
	
	static Scanner kbd = new Scanner(System.in); //For later ask user to enter the id and the name.

	
	private String id, name, dayOfBirth, major;
	private char gender;
	
	/**
	 * This is the constructor will get the given information
	 * @param id receive given id
	 * @param name receive given name
	 * @param gender receive given gender
	 * @param dayOfBirth receive given day of birth
	 * @param major receive given major.
	 */
	public Student(String id, String name, char gender, String dayOfBirth, String major)
	{
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.dayOfBirth = dayOfBirth;
		this.major = major;
	}
	
	
	/**
	 * This is the constructor will get the given information
	 * @param id receive given id
	 * @param name receive given name
	 * @param gender receive given gender
	 * @param dayOfBirth receive given day of birth
	 * if there is no major we will set major to "undeclared"
	 */
	public Student(String id, String name, char gender, String dayOfBirth)
	{
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.dayOfBirth = dayOfBirth;
		major = "undeclared";
	}
	
	/**
	 * this is get id method to receive the id
	 * @return id 
	 */
	public String getId()
	{
		return id;
	}
	
	/**
	 * This is get name method
	 * @return name 
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * This is get gender method
	 * @return gender to receive the gender.
	 */
	public char getGender()
	{
		return gender;
	}
	
	/**
	 * this is get day of birth method
	 * @return day of birth
	 */
	public String getDayOfBirth()
	{
		return dayOfBirth;
	}
	
	/**
	 * This method is to get the info of major
	 * @return the major.
	 */
	public String getMajor()
	{
		return major;
	}
	
	/**
	 * This method is to set a new major
	 * @param newMajor to set the major to new major.
	 */
	public void setMajor(String newMajor)
	{
		this.major = newMajor;
	}
	
	/**
	 * This is toString method used to return all of the info together.
	 */
	public String toString()
	{
		return id + ", " + name + ", " + gender + ", " + dayOfBirth + ", " + major;
	}
	
	/**
	 * This method is to allow user to search student by their name.
	 * @param stu the array of all the students
	 * @param numOfStu the number of students that are allowed in array	
	 * @param name, student's name that is going to be searched.
	 * @return index number of array.
	 * @throws StudentNotFoundException if students is not found.
	 */
	public static int StudentSearchByName(Student stu[], int numOfStu, String name) throws StudentNotFoundException 
	{
		System.out.println("Please enter the student's name");
		name = kbd.nextLine();//ask user to enter the student's name
		
		for(int i = 0; i < numOfStu; i++)
		{
			if(stu[i].getName().equals(name))
			{
				System.out.println(stu[i].toString());//If system found the name in the array. It will print the information.
				return i;
			}
		}		
		throw new StudentNotFoundException();


	}
	
	
	/**
	 * This method is to allows user to search student by their ID.
	 * @param stu is the student array of all the roster
	 * @param numOfStu the number of students that are allowed to be store in the array.
	 * @param id, student's id to be searched
	 * @return the index of number of the array.
	 * @throws StudentNotFoundException if student's id is not found.
	 */
	public static int StudentSearchById(Student stu[], int numOfStu, String id) throws StudentNotFoundException 
	{
		System.out.println("Please enter the student's id");//ask user to enter the student's id.
		id = kbd.nextLine();
		for(int i = 0; i < numOfStu; i++)//to find the id that user entered.
		{
			if(stu[i].getId().equals(id))//if system fount the id in the array. It will print out the information.
			{
				System.out.println(stu[i].toString());
				return i;
			} 
		}
		throw new StudentNotFoundException();
	}
	
	
	
	
	
	/**
	 * This method is used to change the major 
	 * @param stu array that is going to used for store the info
	 * @param numOfStu number of students that is going to be in the array.
	 * @param id the id that user looking for
	 * @return the index of number of the array.
	 * @throws StudentNotFoundException if student's id is not found.
	 */
	
	public static int ChangeMajor(Student stu[], int numOfStu, String id) throws StudentNotFoundException
	{
		String newMajor; //new Major that user going to enter.
		System.out.println("Please enter the student's id");
		id = kbd.nextLine();// ask user to enter the id
		
		for(int i = 0; i < numOfStu; i++)//to find the id that user entered 
		{
			if(stu[i].getId().equals(id))//if id is found, program will ask user to enter the new major to replace the old one.
			{
				System.out.println("Please enter a new major");
				newMajor = kbd.nextLine();
				stu[i].setMajor(newMajor);
				System.out.println("The new major of " + stu[i].getName() + " is " + stu[i].getMajor());
				System.out.println("The new information of " +  stu[i].getName() + " is: \n" + stu[i].toString());
				return i;
			} 
		}
		throw new StudentNotFoundException();
		
	}
	
}
	
	
	

