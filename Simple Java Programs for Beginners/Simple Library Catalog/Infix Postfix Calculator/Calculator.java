/**
 * @author - Thomas Lee
 * Calculator allows infix expression converting to postfix expression 
 * evaluating the postfix expression
 */
package assg7_lic20;

import java.util.*;


public class Calculator 
{
	//making the  variables of infixExp and postfixExp.
    private String infixExp;
    private String postfixExp;

    /**
	 * This method is to initializes infix expression
	 * @param the infix expression that user entered.
	 */
    public Calculator(String exp) 
    {
	        infixExp = exp.replaceAll("\\s+", "");
    }

    /**
	 * Returns infix expression that can be print to the screen
	 */
    public String toString() 
    {
        return infixExp;
    }

    /**
     * This is private method to check if the input operator is +,-,* or /
     * @param the input of operator 
     * @return true if operator match to +,-,* or /,other wise return false.
     */
    private boolean isOperator(char op) 
    {
        return op == '+' || op == '-' || op == '*' || op == '/';
    }

    /**
     * @param input of operator
     * @return If the operator is + or - then return 1
     * if the operator is * or / then return 2
     */
    private int precedence(char op) 
    {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }

    /**
     * Creates postfix expression.
     * @return true if successful, else return false.
     */
    private boolean convertPostfix() 
    {
		//Making a operator Stack for converting postfix.
        Stack<Character> opStack = new Stack<>();
        StringBuilder postfixBuilder = new StringBuilder();

        for (int i = 0; i < infixExp.length(); i++) 
        {
            char ch = infixExp.charAt(i);

            if (Character.isDigit(ch)) 
            {
                postfixBuilder.append(ch);

                // Append multi-digit number to postfix expression
                while (i + 1 < infixExp.length() && Character.isDigit(infixExp.charAt(i + 1))) 
                {
                    i++;
                    postfixBuilder.append(infixExp.charAt(i));
                }
                postfixBuilder.append(' ');
            } 
            else if (ch == '(') 
            {
                opStack.push(ch);
            } 
            else if (ch == ')') 
            {
                while (!opStack.isEmpty() && opStack.peek() != '(') 
                {
                    postfixBuilder.append(opStack.pop()).append(' ');
                }
                if (opStack.isEmpty() || opStack.peek() != '(') 
                {
                    return false; // Unmatched parenthesis
                }
                opStack.pop();
            }
            else if (isOperator(ch)) 
            {
                while (!opStack.isEmpty() && precedence(ch) <= precedence(opStack.peek())) 
                {
                    postfixBuilder.append(opStack.pop()).append(' ');
                }
                opStack.push(ch);
            } 
            else
            {
                return false; // Invalid character
            }
        }

        while (!opStack.isEmpty()) 
        {
            if (opStack.peek() == '(') 
            {
                return false; // Unmatched parenthesis
            }
            postfixBuilder.append(opStack.pop()).append(' ');
        }

        postfixExp = postfixBuilder.toString().trim();
        return true;
    }

    /**
	 * Returns the resulting postfix expression
	 * @throws IllegalStateException if user try to call getPostfix before convertPostfix
	 */
    public String getPostfix() {
        if (postfixExp == null && !convertPostfix())
        {
            throw new IllegalStateException("Invalid expression");
        }
        return postfixExp;
    }

    /**
	 * Evaluates the expression
	 * to get the result for expression.
	 */
    public int evaluate() {
        if (postfixExp == null && !convertPostfix())
        {
            throw new IllegalStateException("Invalid expression");
        }

        Stack<Integer> operandStack = new Stack<>();
        String[] tokens = postfixExp.split("\\s+");

        for (String token : tokens) {
            if (Character.isDigit(token.charAt(0))) {
                operandStack.push(Integer.parseInt(token));
            } else {
                int operand2 = operandStack.pop();
                int operand1 = operandStack.pop();

                switch (token) {
                    case "+":
                        operandStack.push(operand1 + operand2);
                        break;
                    case "-":
                        operandStack.push(operand1 - operand2);
                        break;
                    case "*":
                        operandStack.push(operand1 * operand2);
                        break;
                    case "/":
                        operandStack.push(operand1 / operand2);
                        break;
                }
            }
        }
        return operandStack.pop();
    }
}