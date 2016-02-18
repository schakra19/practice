import java.util.*;
public class AllPalindrome{


	public static boolean isPalindrome(String s, int start, int end){
		while(start < end){
			if(s.charAt(start)!=s.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;
	}
	public static void allPalindromeUtil(ArrayList<Queue<String>> allPart, Queue<String> currPart, int start, int n, String str){
		if(start>=n){
			allPart.add(currPart);
			return;
		}
		for(int i=start; i<n;i++){
			if(isPalindrome(str,start,i)){
				currPart.add(str.substring(start,i-start+1));
				allPalindromeUtil(allPart,currPart,i+1,n,str);
				currPart.poll();		
			}
		}
	}
	public static void allPalindromes(String str){
		ArrayList<Queue<String>> allPart = new ArrayList<Queue<String>>();
		int n = str.length();

		Queue<String> currPart = new LinkedList<String>();
		allPalindromeUtil(allPart, currPart, 0, n, str);

		Iterator itList = allPart.iterator();
		while(itList.hasNext()){
			System.out.println(itList.next());
		}
	}
	public static void main(String[] args){
		String s = "nitin";
		allPalindromes(s);
	}
}
