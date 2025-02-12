/**
 * @author - Thomas Lee
 * This program is to made a simulate a small application system of student 
 * data. Where you can change their major.
 * Also to test if every methods from Student class works properly.
 */

package assg4_lic20;

import java.io.*;
import java.util.*;


public class StudentApplication 
{

	public static void main(String[] args) 
	{
		Scanner kbd= new Scanner(System.in);
		int choice; //Allow user to choose number from the menu.

		int MAX = 100;
		int numOfStu = 0; //number of students allowed to be in array.

		Student[] student = new Student[MAX];//Maximum 100 students to be in student array.
	
		String fileName = "assg4_input.txt";
		Scanner inputStream = null;
				
		String id = null; 
		String name = null;
		char gender; 
		String dayOfBirth;
		String major;
		String[] stuArr;//String array that will be used for split.

		
		try
		{
			inputStream = new Scanner (new File(fileName));//Read the file.
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Sorry we can't find the file you're looking for.");
			System.exit(1);
		}

		while(inputStream.hasNextLine())
			{				
				stuArr = inputStream.nextLine().split(",");//split array by "," 
				
				//store from String[] stuArry into Student[] student.
				if(stuArr.length == 4)
				{
					 id = stuArr[0];
					 name = stuArr[1];
					 gender = stuArr[2].charAt(0);
					 dayOfBirth = stuArr[3];
					
					//To test if the constructor without major parameter works properly.
					student[numOfStu] = new Student(id, name, gender, dayOfBirth);
					
					//To test if toString method works properly.
					System.out.println(student[numOfStu].toString());
				}
				else if(stuArr.length == 5)
				{
					 id = stuArr[0];
					 name = stuArr[1];
					 gender = stuArr[2].charAt(0);
					 dayOfBirth = stuArr[3];
					 major = stuArr[4];
					 
					 //To test if the constructor with major parameter works properly.
					student[numOfStu] = new Student(id, name, gender,dayOfBirth, major);
					//To test toString method.
					System.out.println(student[numOfStu].toString());
				}
				numOfStu++;
			}	
		
		System.out.println("\n" + "you have " + numOfStu + " students in the system.");
		
		System.out.println();
		
		System.out.println(student[6].toString());
		
		//To test getName and getId method;
		System.out.println("Student: " + student[6].getName() + "'s ID is " + student[6].getId());
		
		//To test getGender method;
		System.out.println("Student: " + student[6].getName() + "'s gender is " + student[6].getGender());
		
		//To test getDayOfBirth method;
		System.out.println("Student: " + student[6].getName() + "'s birthday is " + student[6].getDayOfBirth());
		
		//To test getMajortest;
		System.out.println("Student: " + student[6].getName() + "'s major is " + student[6].getMajor());
		
		//To test setMajor method.
		student[6].setMajor("Art");
		System.out.println("\nStudent: " + student[6].getName() + "'s new major is " + student[6].getMajor());
		

		while(true)
		{			
			System.out.println("\n" + "Please select the options below.");
			System.out.println("1. Search student by id");
			System.out.println("2. Search student by name");
			System.out.println("3. Change student major");
			System.out.println("4. Exit");
			
			choice = kbd.nextInt();

			//If user enter 4, it will exit the system.
			if(choice == 4)
			{
				System.out.println("You're exited from the system.");
				System.exit(1);
				break;
			}

			switch(choice)
			{
			case 1:
				try
				{
					//If user choose 1, it will call StudentSearchById method.
					Student.StudentSearchById(student, numOfStu, id);
				}
				catch(StudentNotFoundException e)
				{
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				try
				{	//If user choose 2, it will call StudentSearchByName method.
					Student.StudentSearchByName(student, numOfStu, name);
				}
				catch(StudentNotFoundException e)
				{
					System.out.println(e.getMessage());
				}

				break;
			case 3:
				try
				{	//If user choose 3, it will call ChangeMajor method.
					Student.ChangeMajor(student, numOfStu, id);
					
					
				}
				catch(StudentNotFoundException e)
				{
					System.out.println(e.getMessage());
				}
				break;
			default: //if user enter any other number it will show "invalid input" and continue.
				System.out.println("Invalid input");
				break;
			}	

		}

		inputStream.close();
		kbd.close();
	}


}
