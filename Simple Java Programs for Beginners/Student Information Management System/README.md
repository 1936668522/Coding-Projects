# **Student Information Management System**
## Author: Thomas Lee
This project simulates a student information management system where students’ details can be stored, searched, and updated.

## Project Overview
This Java-based system allows:
- Storing and retrieving student information (ID, name, gender, birthdate, major)
- Searching for students by name or ID
- Updating a student's major
- Handling exceptions when a student is not found

## Programs Included
### 1. Student.java
- Defines a **Student** class that includes:
  - Attributes: ID, name, gender, date of birth, and major
  - Getters and setters for student attributes
  - Methods for searching students by ID or name
  - A method for changing a student's major
  - A **toString()** method for displaying student details


### 2. RewardsAccount.java
- Simulates a simple student database system:
  - Reads student data from a file (**studentInfo.txt**)
  - Displays student information
  - Provides a menu for searching by ID, searching by name, or changing a major
  - Demonstrates all functionalities of the Student class

### 3. StudentNotFoundException.java
- Custom exception class to handle cases where a student is not found in the system.

## How to Run
1. Ensure you have Java installed (**java -version** to check).
2. Compile the programs:
```
javac Student.java StudentApplication.java StudentNotFoundException.java
```
3. Run the test program:
```
java StudentApplication
```
4. Follow the menu options to search for students or update their major.


## Example Output
```
Student Database Loaded. 10 students in the system.

Please select the options below:
1. Search student by id
2. Search student by name
3. Change student major
4. Exit

Enter your choice: 1
Please enter the student's ID: S12345
S12345, Alice Johnson, F, 01/15/2002, Computer Science

Enter your choice: 3
Please enter the student's ID: S12345
Please enter a new major: Data Science
The new major of Alice Johnson is Data Science.

Enter your choice: 4
You're exited from the system.

```
## Future Improvements
- Add support for writing updates back to a file
- Implement a graphical user interface (GUI)
- Expand functionalities to include GPA tracking
  
## License
This project is open-source and free to use.
