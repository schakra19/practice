import java.util.*;

public class MergeSort{

	public static void merge(int[] arr, int low, int mid, int high){
		int[] result = new int[arr.length];
		for(int i=0;i<arr.length;i++)
			result[i]=arr[i];
		int i=low;
		int j= mid+1;
		int k=low;
		while(i<=mid && j<=high){
			if(result[i]<=result[j]){
				arr[k] = result[i];
				i++;
				k++;
			}
			else{
				arr[k]=result[j];
				j++;
				k++;
			}
		}
		while(i<=mid){
			arr[k]=result[i];
			i++;
			k++;
		}
		while(j<=high){
			arr[k]=result[j];
			j++;
			k++;
		}
	}
	public static void mergesort(int[] arr,int low, int high){
		if(low < high){
			int mid = low + (high-low)/2;
			mergesort(arr,low,mid);
			mergesort(arr,mid+1,high);
			merge(arr,low,mid,high);
		}
	}
	public static void main(String[] args){
		int[] arr = {2,5,9,1,7,4,3,6,10};
		mergesort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
}
