import java.util.*;

class Palindrome{

	public static void main(String[] args){
		String original, reverse = "";
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a string");
		original = scan.nextLine();
		original = original.replaceAll("\\s","");
		int length = original.length();
		for(int i = length-1; i >= 0; i--)
			reverse = reverse + original.charAt(i);

		if(original.equals(reverse))
			System.out.println("Entered string is a palindrome");
		else
			System.out.println("Not Palindrome");		
	}

}
