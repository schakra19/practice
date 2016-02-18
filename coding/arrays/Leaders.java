import java.util.*;
public class Leaders{
	public static void printLeaders(int[] arr){
		int max_from_right = arr[arr.length-1];
		System.out.print(max_from_right+" ");
		for(int i = arr.length-2; i>=0; i--){
			if(arr[i]>max_from_right){
				max_from_right = arr[i];
				System.out.print(max_from_right+" ");
			}
		}
	}

	public static void replaceWithNextGreatest(int[] arr){
		int max_from_right = arr[arr.length-1];
		arr[arr.length-1] = -1;
		for(int i=arr.length-2;i>=0;i--){
			int temp = arr[i];
			arr[i] = max_from_right;
			if(max_from_right < temp)
				max_from_right = temp;
		}
	}

	public static void main(String[] args){
		int[] arr = {16,17,4,3,5,2};
		System.out.println("Original Array "+Arrays.toString(arr));
		System.out.print("Leaders are ");
		printLeaders(arr);
		System.out.println();
		replaceWithNextGreatest(arr);
		System.out.println(Arrays.toString(arr));
	}
}
