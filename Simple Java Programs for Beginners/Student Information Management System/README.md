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
- Extends **StudentAccount** to add a rewards system:
  - Earns 4% rewards on deposits over $100
  - Rewards can be redeemed if they exceed $20

### 3. StudentAccountDemo.java
- Tests the **StudentAccount** and **RewardsAccount** functionalities:
  - Creates multiple student accounts
  - Performs transactions (deposits, withdrawals, transfers)
  - Checks reward accumulation and redemption
  - Validate comparison methods

## How to Run
1. Ensure you have Java installed (**java -version** to check).
2. Compile the programs:
```
javac StudentAccount.java RewardsAccount.java StudentAccountDemo.java
```
3. Run the test program:
```
java StudentAccountDemo
```
## Example Output
```
Account 1:
Account number: 1
Current balance: 0.0

Account 2:
Account number: 2
Current balance: 122.34

The new balance of account 1 is: 450.0
The new balance of account 2 is: -72.66

Reward Account:
Account number: 9
Current balance: 700.0
Rewards balance: 28.0

The rewards from Account 9 is: 28.0
```
## Future Improvements
- Implement a user-friendly GUI for account management
- Add interest calculation for savings accounts
- Integrate with a database for persistent storage
  
## License
This project is open-source and free to use.
