import java.util.*;

public class ReverseStringUsingStack {

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a string");
		String original = scan.nextLine();

		Stack<Character> s = new Stack<Character>();
		for(int i=0; i< original.length(); i++)
			s.push(original.charAt(i));
		String reverse = "";
		while(!s.isEmpty())
			reverse += s.pop();

		System.out.println(reverse);
	}
}
