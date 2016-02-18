//http://www.geeksforgeeks.org/anagram-substring-search-search-permutations/
public class AnagramSubstringSearch{

	private static boolean compare(int[] a, int[] b){
		for(int i=0; i<a.length;i++)
			if(a[i] != b[i])
				return false;
		return true;
	}

	public static void search(String s, String t){
		int m = t.length();
		int n = s.length();

		char[] s_arr = s.toCharArray();
		char[] t_arr = t.toCharArray();
		int[] countP = new int[256];
		int[] countW = new int[256];

		for(int i=0; i<m; i++){
			countP[t_arr[i]]++;
			countW[s_arr[i]]++;
		}

		for(int i=m; i<n; i++){
			if(compare(countP, countW))
				System.out.println("Anagram found at index " + (i-m));
			countW[s_arr[i]]++;
			countW[s_arr[i-m]]--;
		}

		if(compare(countP,countW))
			System.out.println("Anagram found at index "+(n-m));
	}

	public static void main(String[] args){
		String s = "BACDGABCDA";
		String t = "ABCD";
		search(s,t);	
	}
}
			


