# **Simple Library Catalog**
## Author: Thomas Lee
Simple Library Catalog is a straightforward Java-based application for managing a collection of books. It provides features to display, search, add, update, sort, and remove books, and it can also load and save the book catalog to a file. 

## Project Overview
This Java-based Simple Library Catalog is organized into four core classes:
1. 1
2. 2
3. 3
4. 4

   
## Programs Included
### 1. StudentAccount.java
- Defines a **StudentAccount** class that supports:
  - Account creation
  - Deposits and withdrawals
  - Transfers between accounts
  - Retrieving account balance and number
  - Comparing accounts based on balance

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

