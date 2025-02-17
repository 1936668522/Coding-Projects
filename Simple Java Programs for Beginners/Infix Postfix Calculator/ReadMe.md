# **Infix Postfix Calculator**
## Author: Thomas Lee
InfixPostfixCalculator is a simple Java application that converts an infix arithmetic expression into its postfix form and then evaluates it. This can handle basic arithmetic operators (+, -, *, /) and parentheses.

## Project Overview
The Project is composed of two main files:
1. **Calculator.java**
    - Core logic of converting infix expressions to postfix and evaluating them
2. **CalculatorDemo.java**
    - A driver (main) class that prompts the user for      

## Features
1. Infix to Postfix Conversion
    -  Leverages a tack-based approach to transform the user-entered infix expression into a postfix expression.

2. Arithmetic Evaluation
    - Uses another stack to evaluate the resulting postfix expression.

3. Simple Error Checking
    - Detects invalid expressions (e.g., mismatched parentheses) and multi-digit numbers properly.

4. Interactive Console
    - A loop prompts the user to input expressions until they type e to exit.
           
## Usage
1. Compile
   
   In the directory containing the Calculator.java and CalculatorDemo.java, run:
   ```
   javac Calculator.java CalculatorDemo.java
   ```
2. Execute
   ```
   java CalculatorDemo
   ```
3. Input an Expression
    - When prompted, type an infix expression (e.g., (12+3)*4) and press Enter.
    - The application prints out:
        - The original infix expression.
        - The converted postfix expression.
        - The evaluated result.

  4. Exit
      - Type "e" at the prompt and press Enter to exit the program.      

## Example
**Input**
```
(10 + 5) * 2
```

**Output**
```
The infix expression you entered is: (10+5)*2
The postfix expression of your infix expression is: 10 5 + 2 *
The result is: 30
```

## Implementation Details
1. Stack Usage
    - Two stacks are used:
        1. Operator Stack (within the convertPostfix() method) to correctly handle the order of operations while scanning the infix expression.
        2. Operand Stack (within the evaluate() method) to compute the final result from the postfix expression.

2. Multi-digit Numbers
    - The code checks subsequent characters to merge them into a single multi-digit number token.

3. Error Handling
    - Detects unmatched parentheses.
    - Rejects invalid characters or operators.

## File Structure
```
.
├── Calculator.java
└── CalculatorDemo.java
```
- **Calculator.java**
    - Main logic for parsing and evaluating infix expressions

- **CalculatorDemo.java**
    - Contains the main method to run the program, prompt for user inputs, and display results.

  
## License
This project is open-source and free to use.
