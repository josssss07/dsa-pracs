//practical 1: to covert infix to postfix expression
package edu;

import java.util.Stack;
//import java.util.Scanner;

class InPostFix {
	
	static int Prec(char ch) {//function to return precedence of operator (higher number equals higher precedence)
		switch (ch) {
			case '+':
			case '-': return 1;
			case '*': 
			case '%': return 2;
			case '^': return 3;
			default: return -1;
		}
	}
	
	static String infixToPostfix(String exp) {
		//initialize empty String for result
		String result = new String("");
		//initialize empty stack
		Stack<Character> stack = new Stack<Character> ();
		//scan left to right
		for (int i=0; i< exp.length(); ++i) {
			char c = exp.charAt(i);
			
			if (Character.isLetterOrDigit(c)) //if scanned is operand, add to output
				result += c;
			else if (c == '(') //if scanned is '(', push to stack
				stack.push(c);
			else if (c == ')') {// if scanned is ')', pop and output from stack until you get '('
				while (!stack.isEmpty() && stack.peek() != '(')
					result += stack.pop();
				if (!stack.isEmpty() && stack.peek() != '(') //input expression is incorrect/invalid
					return "Invalid Expression1";
				else //you got '(' so pop and discard
					stack.pop();
			}
			else {	//if scanned is operator
				while(!stack.isEmpty() && Prec(c) <= Prec(stack.peek())) { //compare priority
					if(stack.peek() == '(')	//input expression is incorrect/invalid
						return "Invalid Expression2"; 
					result += stack.pop();
				}
				stack.push(c);
			}
		}//for loop ends
		
		while(!stack.isEmpty()) { //if stack is not empty
			result += stack.pop();
		}//while loop ends
		return result;
	}
	public static void main(String[] args) {
		String exp = "((a+b)/(c-(d*e)))";
		System.out.print(infixToPostfix(exp)); //should print ab+cde*-
	}//end of main
}//end of class

