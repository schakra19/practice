import java.util.*;

public class RadixSort{
	public static int getMax(int[] arr){
		int max = 0;
		for(int i=0; i<arr.length; i++){
			if(arr[i] > max)
				max = arr[i];
		}
		return max;
	}

	public static void countSort(int[] arr, int exp){
		int[] output = new int[arr.length];
		int[] count = new int[11];
		Arrays.fill(count,0);
		
		for(int i=0; i<arr.length; i++)
			count[(arr[i]/exp)%10]++;

		for(int i=1; i<11; i++)
			count[i]+=count[i-1];

		for(int i=arr.length-1; i>=0; i--)
			output[--count[(arr[i]/exp)%10]]=arr[i];

		for(int i=0; i<arr.length;i++)
			arr[i] = output[i];
	}

	// Radix sort 
	public static void radixSort(int[] arr){
		int m = getMax(arr);

		for(int exp = 1; m/exp > 0; exp*=10)
			countSort(arr,exp);
	}

	//Counting sort - O(n) where n is the range of numbers
	public static int[] countingSort(int[] arr, int k){
		int[] count = new int[k+1];
		for(int i=0; i < arr.length; i++)
			++count[arr[i]];

		for(int i=1; i <= k ; i++)
			count[i] += count[i-1];

		int[] output = new int[arr.length];
		for(int i=0; i<arr.length; i++)
			output[--count[arr[i]]] = arr[i];

		return output;
	}

	public static void main(String[] args){
		int[] arr = {3,14,18,82,36,71,33,51};
		radixSort(arr);
//		arr = countingSort(arr,100);
		for(int i=0; i<arr.length;i++)
			System.out.print(arr[i]+" ");
	}
}
