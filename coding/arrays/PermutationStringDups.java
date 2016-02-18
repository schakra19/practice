//Print all permutations of a string in a lexicographic order
//Duplicate permutations should not be printed! 
import java.util.*;

public class PermutationStringDups{

	public static void swap(char[] arr,int i,int j){
		char c = arr[i];
		arr[i] = arr[j];
		arr[j] = c;
	}

	public static int findCeil(char[] arr, char c, int l, int h){
		int ceilIndex = l;
		for(int i=l+1; i<=h;i++){
			if(arr[i] > c && arr[i] < arr[ceilIndex])
			ceilIndex = i;
		}
		return ceilIndex;
	}
	public static void printPermutations(String s){
		int len = s.length();
		char[] s_arr = s.toCharArray();
		Arrays.sort(s_arr);
		boolean isFinished = false;

		int x=0;
		while(!isFinished){
			x++;
			System.out.println(x+" " +Arrays.toString(s_arr));
			int i;
			for(i=len-2;i>=0;--i){
				if(s_arr[i]<s_arr[i+1])
					break;
			}
			if(i==-1)
				isFinished = true;
			else{
				int ceilIndex = findCeil(s_arr,s_arr[i],i+1,len-1);
				swap(s_arr,i,ceilIndex);
				Arrays.sort(s_arr,i+1,len);
			}
		}
	}

	public static void main(String[] args){
		String s = "ACBC";
		printPermutations(s);
	}
}
