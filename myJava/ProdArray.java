import java.util.*;

public class ProdArray {

	static void productArray(int[] arr){
		int i;
		int temp = 1;
		int[] prod = new int[arr.length];

	for(i=0; i < arr.length; i++){
		prod[i] = temp;
		temp *= arr[i];
	}

	temp = 1;
	for(i=arr.length-1; i>=0; i--){
		prod[i] *= temp;
		temp *= arr[i];
	}

	for(i=0; i < arr.length; i++)
		System.out.print(prod[i]+" ");

	}

	public static void main(String[] args){
		int[] arr = {10,3,5,6,2};
		productArray(arr);

		//Java's Inbuilt sort 
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));

		for(int i =0; i < prod.length; i++)
			System.out.print(prod[i]+" ");
	}
}

	
