//Find maximum sum of a continguous elements (subarray)
//Example {-2, -3, 4, -1, -2, 1, 5, -3} , ans = 7
import java.util.*;

public class SumSubArray{

	public static int largestSumSubArray(int[] arr){
		int curr_max = arr[0];
		int max_so_far = curr_max;
		for(int i=1;i<arr.length;i++){
			curr_max = Math.max(curr_max+arr[i],arr[i]);
			max_so_far = Math.max(curr_max,max_so_far);
		}
		return max_so_far;
	}
	public static void main(String[] args){
		int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println(Arrays.toString(arr));
		System.out.println("Largest sum is " +largestSumSubArray(arr));
	}
}
