//Given an array of elements - randomize the array
//Also asked as - shuffle a deck of cards 
//Time Complexity = O(n)
import java.util.*;

public class RandomizeArray{

	public static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void randomizeArray(int[] arr){
		Random rGen = new Random();
		for(int i=arr.length-1; i>0;i--){
			int j = rGen.nextInt(arr.length-1);
			swap(arr,i,j);
		}
	}

	public static void main(String[] args){
		int[] arr = {1,2,3,4,5,6,7,8};
		randomizeArray(arr);
		System.out.println("Randomized array is");
		System.out.println(Arrays.toString(arr));
	}
}
