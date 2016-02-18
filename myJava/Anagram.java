import java.util.*;

public class Anagram{

	public static boolean isAnagram(String a, String b){
		if(a.length()!= b.length())
			return false;
		HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
		for(int i =0; i<a.length();i++){
			int count = (hm.get(a.charAt(i))==null) ? 0 : hm.get(a.charAt(i));
			hm.put(a.charAt(i),++count);
		}
		for(int i=0; i<b.length();i++){
			int count = (hm.get(b.charAt(i))==null) ? 0 : hm.get(b.charAt(i));
			hm.put(b.charAt(i),--count);
		}
		for(Integer val: hm.values()){
			if(val!=0)
				return false;
		}
		return true;
	}

	public static void maxOccurringChar(String s){
		HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
		for(int i =0; i<s.length();i++){
			int count = (hm.get(s.charAt(i))==null) ? 0:hm.get(s.charAt(i));
			hm.put(s.charAt(i),++count);
		}
		int maxV = Collections.max(hm.values());
		for(Map.Entry<Character,Integer> e : hm.entrySet()){
			if(e.getValue()==maxV)
				System.out.println(e.getKey() + " occurs " + e.getValue() + " times");
		}
	}

	public static char maxOccurEff(String s){ //only prints first frequent char encountered 
		if(s==null || s.isEmpty())
			throw new IllegalArgumentException("Input string is empty\n");
		char maxch = ' ';
		int maxcount = 0;
		int[] count = new int[Character.MAX_VALUE+1];
		for(int i =0;i<s.length();i++){
			char ch = s.charAt(i);
			if(++count[ch] >= maxcount){
				maxcount = count[ch];
				maxch = ch;
			}
		}
		return maxch;
	}
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		System.out.println("enter first string");
		String a = s.nextLine();
		//System.out.println("enter second string");
		//String b = s.nextLine();

		//System.out.println("Two Strings are anagram of each other "+ isAnagram(a,b));
		//maxOccurringChar(a);
		System.out.println("Max occurring char in " + a + " is " + maxOccurEff(a));
	}
}

