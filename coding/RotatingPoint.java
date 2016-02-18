//Question - given a rotated array, find the index where it is rotated
import java.util.*;
public class RotatingPoint{

	public static int findPivot(int[] array, int low, int high){
		if(high<low)
			return 0;
		if(high==low)
			return low;
		int mid = low + (high-low)/2;
		if(mid < high && array[mid] > array[mid+1])
			return mid;
		if(mid > low && array[mid-1] > array[mid])
			return mid-1;
		else if(array[low]>=array[mid])
			return findPivot(array,low,mid-1);
		else 
			return findPivot(array,mid+1,high);
	}

	public static void main(String[] args){
		int[] arr = {3,4,5,6,1,2};
		System.out.println("Rotated index for " + Arrays.toString(arr)+" is " + findPivot(arr,0,5));

		int[] a = {1,2,3,4,5,6};
		System.out.println("Rotated index for " + Arrays.toString(a)+" is " + findPivot(a,0,5));

		int[] b = {6,1,2,3,4,5};
		System.out.println("Rotated index for " + Arrays.toString(b)+" is " + findPivot(b,0,5));
	}
}
