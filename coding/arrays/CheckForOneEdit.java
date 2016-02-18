// Given two strings, check if they are one edit away 
// Edits can be add/delete/remove
public class CheckForOneEdit{
	public static boolean checkOneEdit(String a,String b){
		int m = a.length();
		int n = b.length();
		if(Math.abs(m-n)!=1)
			return false;
		int count = 0;
		int i=0;
		int j=0;
		while(i < m && j < n){
			if(a.charAt(i)!=b.charAt(j)){
				if(count==1)
					return false;
				if(m>n)
					i++;
				else if(m<n)
					j++;
				else{
					i++;
					j++;
				}
					count++;
			}
			else{
				i++;
				j++;
			}
		}

		if(i<m || j<n)
			count++;
		return (count==1);
	}
	public static void main(String[] args){
		String s1 = "abcd";
		String s2 = "abcde";
		System.out.println(s1 + " and " + s2 + " are one edit away " + checkOneEdit(s1,s2));
	}
}
