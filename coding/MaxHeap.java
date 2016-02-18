import java.util.*;

public class MaxHeap{

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

	public static int heapSort(int arr[],int k){
		total = k-1;
		//build max heap for only k elements
		for(int i = total/2; i>=0; i--)
			heapify(arr,i);
		//Compare n-k elements with the root of heap
		for(int i=k;i<arr.length;i++){
			if(arr[i] < arr[0]){
				swap(arr,0,i);
				heapify(arr,0);
			}
		}
		return arr[0];	
	}
	public static void main(String[] args){
		int arr[] = {12,7,31,9,45};
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the value of k");
		int k = s.nextInt();
		int kth = heapSort(arr,k);
		System.out.println("Kth largest element is "+ kth);
	}
}
