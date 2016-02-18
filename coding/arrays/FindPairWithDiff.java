//Find a pair with given difference in an unsorted array
//time complexity - O(nlogn)
import java.util.*;
public class FindPairWithDiff{


	//Method -1 (Using hashmap)
	public static void findPairWithDiff(int[] arr, int diff){
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
		for(int i=0;i<arr.length;i++){
			hm.put(arr[i],1);
		}
		for(int i=0;i<arr.length;i++){
			if(hm.containsKey(arr[i]+diff)){
				System.out.println("Found pair " + arr[i] + " and " + (arr[i]+diff));
				return;
			}
		}
		System.out.println("No such pair found");
	}

	//Method - 2 (Sorting and traversing to find the pair)
	public static void findDiff(int[] arr, int diff){
		Arrays.sort(arr);
		int i=0;
		int j=1;
		int size = arr.length;
		
		while(i < size && j < size){
			if(arr[j]-arr[i]==diff){
				System.out.println("Found pair " + arr[i] +" and "+arr[j]);
				return;
			}
			else if(arr[j]-arr[i] < diff)
				j++;
			else
				i++;
		}
		System.out.println("No such pair found");
		
	}
	public static void main(String[] args){
		int[] arr = {5,20,3,2,50,80};
		//findPairWithDiff(arr,30);
		findDiff(arr,47);
		findDiff(arr,67);
	}
}
