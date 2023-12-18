//practical 1: to covert infix to postfix expression

import java.util.Stack;
//import java.util.Scanner;

class InPostFix {
	
	static int Prec(char ch){
        switch(ch){
            case '+':
            case '-': return 1;
            case '*': return 2;
            case '/': return 2;
            case '^': return 3;
            default: return -1;
        }
    }
   
    static String infixToPostFix(String exp){
        String result = new String("");
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < exp.length(); i++)
        {
            char c = exp.charAt(i);
            if(Character.isLetterOrDigit(c)) result += c;
            else if (c == '(') stack.push(c);
            else if (c == ')')
            {
                while(!stack.isEmpty() && stack.peek() != '(')
                {
                    result += stack.pop();
                }
                if(!stack.isEmpty() && stack.peek() != '(')
                {
                    return "Invalid expression";
                }
                else stack.pop();
            }
            else
            {
                while(!stack.isEmpty() && Prec(c) <= Prec(stack.peek()))
                {
                    if(stack.peek() == '(') return "Invalid expression";
                    result += stack.pop();
                }
                stack.push(c);
            }
        }
        while(!stack.isEmpty())
        {
            // if(stack.peep() == '(') return "Invalid expression";
            result += stack.pop();
        }
        return result;
    }

	public static void main(String[] args) {
		String exp = "((a+b)/(c-(d*e)))";
		System.out.print(infixToPostFix(exp)); //should print ab+cde*-/
	}
}//end of class

