import java.util.*;

public class HeapSort{

	private static int total;

	private static void swap(int[] arr, int i, int j){
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	private static void heapify(int arr[], int i){
		int left = 2*i;
		int right = left + 1;
		int greatest = i;

		if(left <= total && arr[left] > arr[greatest]) greatest = left;
		if(right <= total && arr[right] > arr[greatest]) greatest = right;

		if(greatest != i){
			swap(arr,greatest,i);
			heapify(arr,greatest);
		}
	}

	public static void heapSort(int arr[]){
		total = arr.length - 1;
		for(int i = total/2; i>=0; i--)
			heapify(arr,i);
		for(int i=total; i>0; i--){
			swap(arr,0,i);
			total--;
			heapify(arr,0);
		}		
	}
	public static void main(String[] args){
		int arr[] = {4,3,1,2,5};
		heapSort(arr);
		System.out.println(java.util.Arrays.toString(arr));
	}
}
