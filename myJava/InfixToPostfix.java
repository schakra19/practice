import java.util.*;

public class InfixToPostfix{

	public boolean isOperand(char c){
		int val = Character.getNumericValue(c);
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int A = Character.getNumericValue('A');
		int Z = Character.getNumericValue('Z');

		return((val >= a && val <= z) || (val >= A && val <= Z));

	}

	public int prec(char c){
		switch (c){
    			case '+':
			case '-':
        			return 1;
 
                        case '*':
                        case '/':
                                return 2;
 
                        case '^':
                                return 3;
                }
                return -1;
	}

	public String infixToPostfix(String infix){
		Stack<Character> exp = new Stack<Character>();
		String output = "";

		char open = '(';
		char close = ')';

		for(int i=0; i<infix.length(); i++){
			if(isOperand(infix.charAt(i))){
				output += infix.charAt(i);
			}
			else if(infix.charAt(i)==open)
				exp.push(infix.charAt(i));
			else if(infix.charAt(i)==close){
				while(!exp.isEmpty() && exp.peek()!= open)
					output += exp.pop();
				if(!exp.isEmpty() && exp.peek()!= open)
					return "";
				else
					exp.pop();
			}
			else{
				while(!exp.isEmpty() && (prec(infix.charAt(i)) <= prec(exp.peek())))
					output += exp.pop();
				exp.push(infix.charAt(i));
			}
		}

		while(!exp.isEmpty())
			output += exp.pop();
	
		return output;
	}

	public static void main(String[] args){
		String infix = "a+b*(c^d-e)^(f+g*h)-i";
		InfixToPostfix ip = new InfixToPostfix();
		System.out.println(ip.infixToPostfix(infix));
	}
}
