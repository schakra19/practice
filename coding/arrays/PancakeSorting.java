//Implement pancake sorting
//Time Complexity - O(n*n)
import java.util.*;
public class PancakeSorting{
	public static int findMax(int[] arr, int n){
		int mi=0;
		for(int i=0; i<n; i++){
			if(arr[mi] < arr[i])
				mi=i;
		}
		return mi;
	}

	public static void flip(int[] arr, int i){
		int start = 0;
		while(start < i){
			int temp = arr[i];
			arr[i] = arr[start];
			arr[start] = temp;
			i--;
			start++;
		}
	}
	public static void pancake(int[] arr){
		int n  = arr.length;
		for(int curr_size = n; curr_size > 1; curr_size--){
			int mi = findMax(arr,curr_size);
			if(mi != n-1){
				flip(arr,mi);
				flip(arr,curr_size-1);
			}
		}
	}
	
	public static void main(String[] args){
		int[] arr = {23,10,20,11,12,6,7};
		System.out.println(Arrays.toString(arr));
		pancake(arr);
		System.out.println(Arrays.toString(arr));
	}
}
