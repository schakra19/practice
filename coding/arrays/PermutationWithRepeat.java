//Given a string, print all permutations of string where each char can be repeater
//Ex. ABC - AAA, AAB, AAC, ABA, ABB and so on .. CCC
//Time complexity - O(n^n)
import java.util.*;
public class PermutationWithRepeat{

	public static void printRecursive(char[] str, char[] data, int last, int index){
		int n = str.length;
		for(int i=0; i<n; i++){
			data[index] = str[i];
			if(index == last){
				String output = new String(data);
				System.out.println(output);
			}
			else
				printRecursive(str,data,last,index+1);
		}
	}
	public static void printPermutations(String s){
		char[] str = s.toCharArray();
		char[] data = new char[s.length()];
		printRecursive(str,data,s.length()-1,0);
	}
	
	public static void main(String[] args){
		printPermutations("ABC");
	}
}
